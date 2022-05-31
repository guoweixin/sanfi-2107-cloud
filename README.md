# SpringCloud课堂笔记

### 分布式微服务治理解决方案（框架）

```bat
分布式：将一个大的应用按功能拆分成多个小应用，部署在不同服务器上。
微服务：将一个大的应用按功能拆分成多个小应用（每个应用都是可独立部署和测试），称为微服务。

赛诺菲 --》
      会议微服务
      视频微服务
      ...
```

### 搭建架构

```bat
sanfi  （父工程pom: 1、统一版本管理 2、对子模块进行拆分和聚合）
├── sanfi-common -- 公共工具类核心包 [普通jar]
├── sanfi-api --  公共服务接口（模型、异常）     
├── sanfi-meeting --  会议微服务 【8080】	 
├── sanfi-video -- 视频微服务[8085]
├── sanfi-fastdfs --文件上传服务器（建议现在用阿里云OSS）
├── sanfi-kafka --  中间件服务器
├── sanfi-redis -- redis服务器
├── cloud
	├── hystrix-dashBoard -- 熔断器[9080]
	├── hystrix-trubine -- 集群熔断器[9088]
	├── sanfi-config -- 配置中心[8888]
	├── sanfi-eureka -- 服务注册与发现[9001 9002 9003]
	├── sanfi-gateway -- Spring Cloud Gateway网关[9999]
	├── sanfi-zuul -- Spring Cloud Zuul网关[8000]
```



# 