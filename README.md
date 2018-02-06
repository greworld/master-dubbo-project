# dubbo-project
计划整合互联网常用技术，来实现相关业务的整合。主要目的不是为了要完成一个具体项目，而是通过项目更进一步了解技术所要解决的问题。

**整个项目不会在完全开发实现，而是希望志同道合的IT同道能够参与到项目中来，在实现业务功能的同时把遇到的问题整理出来，提交到issue上。帮助大家以一个健康的方式快速成长**

项目主要是帮助没有接触过分布式领域的做一些实战帮助大家建立这样的意识；当然也会结合学过的技术怎么运用在实际中做一些真实场景的演示；当最终我们进入到互联网公司或者涉及到分布式架构的公司里面，我们每天接触的都是这样一个模型的项目，也就不存在要不要实战项目的问题了。`


> 帮助大家对分布式架构和应用有一个整体认识
> 明白自己学到的技术真正应用到实战中是如何去解决问题的
> 帮助大家建立解决问题的思路

# 使用技术
使用Dubbo+spring 构建整个项目

Maven构建项目

Jenkins作为持续集成

使用 Apollo 配置中心

使用Spring+Spring MVC+MyBatisSSM框架

数据库连接池使用druid

数据库使用MySQL和Redis

网页采用Velocity生成静态化页面

采用ElasticSearch实现搜索服务

负载均衡使用Nginx、keepalived实现高可用

消息中间件采用ActiveMQ

在分布式事务上则采用了TCC解决时效性要求性高的分布式事务

可靠的消息服务则来解决时效性要求低的分布式事务.



# Dubbo服务

| 项目                |                  运行路径 |  备注  |
| ----------------- | --------------------: | :--: |
| dubbo-order       | 通过bootstrap类的main方法运行 | 订单服务 |
| dubbo-user        | 通过bootstrap类的main方法运行 | 用户中心 |
| greworld-activity | 通过bootstrap类的main方法运行 | 活动运营 |
| greworld-item     | 通过bootstrap类的main方法运行 | 商品中心 |
| greworld-order    | 通过bootstrap类的main方法运行 | 订单中心 |
| greworld-pay      | 通过bootstrap类的main方法运行 | 支付服务 |
| greworld-search   | 通过bootstrap类的main方法运行 | 搜索引擎 |
|                   |                       |      |
|                   |                       |      |

# web项目

> 前端这块目前就是一个gupao-protal（前端站点） 和 ssm-scaffold （后台管理）
> 前后端没有分离，所以api层写起来比较尴尬，如果有哪位同学对前端比较厉害，可以用写一个单独的前端应用
> 后端体统RESTful接口；