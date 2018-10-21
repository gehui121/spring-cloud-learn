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
	@EnableDiscoveryClient 作用是使用于consul、zookeeper作为注册中心，用于发现与消费服务
	@EnableEurekaClient 是默认的Eureka作为注册中心
	Zookeeper是临时节点类型，
	
	
		