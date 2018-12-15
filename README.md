
java -jar eureka-server.jar --spring.profiles.active=server1
第一章：搭建Eureka服务注册中心
	spring.application.name：服务名称
	server.port：服务端口号
	eureka.client.service-url.defaultZone：Eureka默认的服务地址空间信息配置
	eureka.client.fetch-registry：是否从其他Eureka注册中心同步服务列表（单节点无需配置启用）.
	eureka.client.register-with-eureka：是否将自己作为服务注册到其他Eureka服务注册中心（单节点无需配置启用）.
	server-uptime：已经启动的耗时
	current-memory-usage：当前占用的内存总量
	Instances currently registered with Eureka：注册到该中心的服务列表
	ipAddr：当前Eureka Server的IP地址，如果没有配置eureka.instance.ip-address那么这里使用默认的IP地址。
	
	高可用启动EurekaServer
		java -jar sssxxxx.jar --spring.profiles.active=server1
	启动jar包指定端口
		java -jar xxxx.jar --server.port=20000
		
自我保护机制：
	本地开发环境建议关闭Eureka自我保护机制
	eureka.server.enable-self-preservation=false
	生产环境建议开启Eureka自我保护机制(默认开启)
	
如果服务真的宕机
	解决办法：本地调用应该设置重试机制，保证接口网络延迟幂等性，开启一些服务的降级功能，不能一直调不通的服务
	
第二章：SpringCloud整合Zookeeper作为注册中心
	zookeeper下载地址：https://zookeeper.apache.org/
	安装步骤：
		1.创建安装目录，将下载的zookeeper-3.4.9.tar.gz压缩包解压
		2.windows启动脚本在bin目录下zkServer.cmd
		3.启动之前，修改配置文件；Zookeeper 的配置文件在 conf 目录下，这个目录下有 zoo_sample.cfg 和 log4j.properties，
		需要将 zoo_sample.cfg 改名为 zoo.cfg，因为 Zookeeper 在启动时会找这个文件作为默认配置文件
		4.配置完成后，双机bin目录下的zkServer.cmd启动
		5.检查服务是否启动，可以通过 netstat – ano 命令查看是否有你配置的 clientPort 端口号在监听服务
	可视化工具：
		下载地址：https://issues.apache.org/jira/secure/attachment/12436620/ZooInspector.zip
		解压，进入目录ZooInspector\build
		运行zookeeper-dev-ZooInspector.jar
		点击左上角连接按钮，输入Zookeeper服务地址：ip:2181

	@EnableDiscoveryClient 作用是使用于consul、zookeeper作为注册中心，用于发现与消费服务
	@EnableEurekaClient 是默认的Eureka作为注册中心
	Zookeeper是临时节点类型，
	
	搭建spring-cloud-eureka-parent
	手写客户端负载均衡：
		算法：总请求数对远程服务器数量取模得到实际下标就是远程服务器的位置，
			总请求数 1
			远程服务器数：2台
			1%2=1 对应下标位置List[1]就是第二台服务器
		流程：
			1.当消费者调用生产者时接口时，
			2.先以生产者在注册中心的别名 eureka-service 在注册中心获取所有该别名对应的实际接口地址，
			3.订单服务获取到实际地址后，缓冲到本地（jvm客户端）
			4.在本地使用实际接口地址实现远程的rpc调用。底层是以HttpClient实现
			
			本代码中使用强加，建议使用原子计数器 因为线程安全，效率高，使用cas 无锁机制。
			
	Ribbon与Nginx的区别：
		ribbon是本地客户端负载均衡，原理：在调用接口时，会在eureka注册中心上获取注册到注册中心的服务列表，之后缓冲到本地的jvm中，然后
		Nginx是服务端负载均衡，客户端所有的请求交给Nginx，然后由Nginx实现请求转发。
		应用场景：ribbon本地负载均衡器适合在微服务rpc远程调用，比如dubbo springcloud
				  nginx服务器负载均衡适合于针对服务器端，比如tomcat，jetty
	声明式Feign客户端
		springcloud中支持两种远程调用工具，
			rest：实际开发中基本上不用
			feign：以后在实际开发中常用的，声明式的Http客户端调用工具，采用接口+注解方式实现，易读性强，
			使用Feign客户端实现客户端远程调用
				特别注意：在使用restful风格时，定义的Feign接口中使用的@PathVariable(value = "name")注解必须加value，否则报错
				消费者中@PathVariable可以不用加value
				@Autowired注解注入Feign接口对象时，IDEA编译报错，不用管，使用功能没问题
				接口不能实例化，实例化的是其实现类
		
		
	搭建springcloud2.0-itwolf-parent项目，	
		将实体类创建在接口服务项目中，方便依赖该接口服务的项目调用，
		<dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
		@Data注解自动生成get/set方法
		进行feign客户端调用接口，在接口项目中rest绑定参数时，@PathVariable注解必须加value="xxxx"
				在生产者、消费者中均制定requestMapping，并且使用@PathVariable接收参数 ，可以不写value
				
		服务雪崩效应：默认情况下，tomcat只有一个线程池处理客户端的所有请求这样的话在高并发下，如果客户端所有的请求堆积到同一个服务接口上，
					就会产生tomcat 的所有线程去处理该服务接口，可能会导致其他服务接口无法访问。
					tomcat 有个线程池，每个线程去处理客户端发送的每次请求
					
					服务降级使用fallback返回类型必须与接口类型一致
					
		
		spring-cloud config
			git环境上文件命名规则：
				/{application.name}-dev.properties/ 
				/{application.name}-prd.properties/
			config-client 的应用名称为：application.name，必须与git上的文件名称一致
			使用手动刷新配置文件，依赖中添加actuator
			步骤：先post请求http://localhost:30003/actuator/refresh
				2.config-client请求为修改后的配置信息
				注意：项目中配置文件只能命名bootstrap.yml，application.yml启动报错 
			手动刷新：http://localhost:30004/actuator/refresh
					如果集群需要每个微服务都需要刷新，
			
		1.网关 API Gateway (网关) --接口网关注意：接口没有界面
			网关概念：相当于客户端请求统一先请求到网关服务器上，再由网关服务器转发到实际的服务地址上，类似于Nginx
			网关的作用：1.拦截客户端所有的请求，对该请求进行权限控制、负载均衡、日志管理、接口调用监控等。
			
			
		2.接口在服务架构和微服务背景下产生，目的是为了解耦，在rpc远程调用中产生
		3.接口分类：
			开放接口-- 其他机构合作伙伴进行调用（必须在外网）
				需要通过appid+appsocet生成accessToken进行通讯，对接支付开发，微信开发，
				目的可以授权一些可口权限，OAuth2.0 协议方式，第三方联合登录
			内部接口：一般只能    在局域网中进行访问，服务与服务之间调用关系都在同一个微服务系统中，目的是为了保证安全问题。
		面试题：现在让你去设计一套公司项目接口，你会如何设计？
			考虑：接口权限（开放接口|内部接口）、考虑幂等性、安全性（https）防止篡改数据（验证签名）、使用网关拦截、接口实现黑名单和白名单，接口使用http协议+json
			格式restful目的是为了跨平台、考虑高并发、对接口实现服务保护、熔断、隔离、降级之类、最后使用统一API管理平台api swagger
		
		网关和过滤器的区别：
			过滤器拦截单个tomcat服务器请求
			网关是拦截整个微服务所有的请求
		网关分为内网网关和外网网关，
		Nginx与Zuul区别：
			相同点：
			1.Zuul和Nginx都可以实现负载均衡，反向代理、过滤请求、实现网关效果
			不同点：
			2.Nginx采用C语言编写的，
			 Zuul采用的是java语言编写
			 Zuul中的负载均衡采用的是Ribbon+Uereka实现本地负载均衡
			 Nginx中的负载均衡采用的是服务器端的负载均衡，
			 Nginx比Zuul的实现功能更加强大，因为Nginx可以整合一些脚本语言，（Nginx+Lua），Nginx适合服务器端的负载均衡
			 Zuul适合微服务中实现网关，
			 最好建议Nginx+Zuul实现网关，Nginx作用实现反向代理，Zuul对微服务实现网关拦截，比如对黑名单白名单控制。
			 为什么不用Nginx实现网关呢？
				因为微服务网关是针对整个服务实现统一请求拦截，网关基本上都是采用自己熟悉的语言开发的，方便易学。
			 
			 网关服务，订单服务，会员服务都是在同一个局域网内
			 
		swagger
		微服务接口时，如果是get请求使用GetMapping
					  如果是post请求使用postMapping
					  不建议使用requestMapping因为生成的swagger文档时支持很多种请求方式。
		ui界面路径
		http://gw.itwolf.com/swagger-ui.html
		http://localhost:50000/swagger-ui.html
		
		ELK开源实时日志分析平台：Elasticsearch、Logstash、Kiabana
			Elasticsearch：承担存储和分析功能，具有分布式、零配置、自动发现、索引自动分片、副本机制及自动搜索负载等特点。
			Logstash：负责收集数据和进行简单数据处理，并将采集的数据输出给ElasticSearch，通过Logstash我们可以采集各微服务实例所生成的日志，
			Kiabana:负责将Logstash所采集的日志，利用Elasticsearch进行搜索分析，通过友好的可视化界面，提供日志的可视化分析，搜索和报表统计等功能。
		

		消息总线：（底层通过MQ实现的）其实通过消息中间件主题模式，他使用广播消息的机制被所有在注册中心注册的微服务实例进行监听和消费，以广播的形式将消息推送到注册中心的所有微服务列表
			
		
		
		spring-cloud-stream消息驱动：整合常用MQ的框架，rabbitMQ、kafka 让开发人员不需要具体指导MQ底层实现，只需要转注核心业务逻辑的实现即可，
						底层实现：Stream组件对rabbitMQ和kafka，进行封装层同一个API，开发人员只需要对接Stream即可。
			项目：stream-productor、stream-consumer
			1.创建消息通道
			   @Output("my_stream_channel")
				SubscribableChannel sendMsg();
			2.生产者投递消息
			 Message build = MessageBuilder.withPayload(msg.getBytes()).build();
			boolean flag = sendMessage.sendMsg().send(build);
			3.开启绑定
			@EnableBinding(ISendMessage.class)
			
			消费者：监听消息通道
			//1.创建监听消息的通道
			@Input("my_stream_channel")
			SubscribableChannel sendMsg();
			//2.接收消息
			@StreamListener("my_stream_channel")
			//3.绑定监听器
			@EnableBinding(IReadMsg.class)//绑定监听器

			rabbitMQ默认以通道名称创建交换机，消费者在启动的时候随机创建一个队列名称
			激活rabbitMQ在命令行输入"D:\JAVA\Develop\rabbitMQ\RabbitMQ\rabbitmq_server-3.7.9\sbin\rabbitmq-plugins.bat" enable rabbitmq_management
			
			命令行查看已有用户及用户的角色：
			rabbitmqctl.bat list_users
			
			rabbitMQ服务访问路径：http://localhost:15672/
			如果想改为kafka，只需要将依赖、application.yml中改为kafka即可
			
			consumer group 保证一条消息在同一个组中只用一个 消费者进行消费，轮训机制。如果消费者集群部分组，则会出现重复消费的情况
server:
  port: 10020
spring:
  application:
    name: stream-consumer
  cloud:
    stream:
      bindings:
      #指定管道名称
        my_stream_channel:
        #指定应用实例属于stream消费组
          group: stream
		  
		  
		迁移kafka：
		1.修改pom.xml,依赖该为kafka
		2.修改application.xml 连接为kafka连接，默认是rabbitMQ
		3.代码业务逻辑不变
			
	
Ribbon进阶：
		负载均衡策略
		全局策略设置：只需加一个配置类，创建一个IRule实现类对象即可
		order-service使用的是全局策略设置负载均衡策略，--随机策略
		ribbon超时与重试
			使用Http发送请求，由于网络原因，此时的调用进行时限控制以及实现之后重试尤为重要
		Ribbon的饥饿加载
			Ribbon在进行客户端负载均衡的时候并不是在启动时就加载上下文，而是在实际请求的时候采取创建，因此这个特性往往会让我们的第一次调用显得颇为疲软乏力
			严重的时候会引起调用超时，所以开启饥饿加载，在启动的时候便加载所有配置项的应用程序上下文
		
Hystrix是一个延迟和容错库，隔离远程系统、服务和第三方库，阻止级联故障，在复杂的分布式系统中实现恢复能力。		
	设计目标：
		1.通过客户端库对延迟和故障进行保护和控制
		2.在一个复杂的分布式系统中停止级联故障
		3.快速失败和迅速恢复
		4.在合理的情况下回退和优雅降级
		5.开启近实时监控，告警和操作控制
		
-------------------将消息驱动注解注释掉了，监听日志太频繁------------		
		
Hystrix Dashboard 
	访问路径：http://localhost:9010/hystrix
		监控：http://localhost:30001/actuator/hystrix.stream
	
Turbine：
	访问路径：http://localhost:9020/hystrix
	监控：http://localhost:9020/turbine.stream
	只有使用hystrix才能被检测到，

HystrixBadRequestException这个异常是由非法参数或者非系统异常引起的，hystrix不会降级的，不会触发fallback，
	在Feign Client 中可以使用ErrorDecoder实现对不触发fallback、这类异常的包装，在实际的使用中，很多时候调用接口会抛出400-500之间的错误，
	此时可以通过它进行封装。

一般情况下Ribbon的时间应短于Hystrix超时时间。

Hystrix请求缓存：Hystrix的请求缓存是在同一个请求中进行，在进行第一次调用结束后对结果缓存，
			然后接下来同参数的请求将会使用第一次的结果，缓冲的生命周期只是在一次请求中有效。
	初始化请求上下文，
		Hystrix的缓存在一次请求内有效，这要求请求要在一个Hystrix上下文里，可以使用filter过滤器或者interceptor拦截器初始化，

$ cd $HOME
$ mkdir config-repo
$ cd config-repo
$ git init .
$ echo info.foo: bar > application.properties
$ git add -A .
$ git commit -m "Add application.properties"

Zuul：
	 在实际项目中我们往往会在网关层涉及鉴权，限流，动态路由，文件上传，参数转换，以及做其他逻辑与业务处理。
	 Zuul的核心逻辑是有一系列紧密配合工作的Filter来实现的，他们能够在进行HTTP请求或者响应的时候执行相关操作。
	 
	 





































	
		