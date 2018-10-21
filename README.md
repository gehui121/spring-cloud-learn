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
		