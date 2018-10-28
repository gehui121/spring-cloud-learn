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
					就会产生tomcat 的所有线程池去处理该服务接口，可能会导致其他服务接口无法访问。
					tomcat 有个线程池，每个线程去处理客户端发送的每次请求
					
		
		
		
		
		
		
		
		
		
		
		
	
		