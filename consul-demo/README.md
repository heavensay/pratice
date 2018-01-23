# consul服务发现练习项目

## consul练习使用到了3个项目

- 服务提供者server-provider-1, server-provider-2
- 服务消费者server-consumer

## 项目环境

   springcloud，jdk8，consul服务端
	
		
##查看效果
consul服务端访问以下地址获取web ui服务列表：  
http://127.0.0.1:8500/ui/#/dc1/services查看服务列表

服务消费端访问以下地址获取对应服务：  
http://127.0.0.1:8082/services  
http://127.0.0.1:8082/discovery