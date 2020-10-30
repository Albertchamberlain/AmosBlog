# AmosBlog
Amos的个人博客

基于 SpringBoot整合其它组件 实现的博客系统，包含用户注册、登录、找回密码，文章管理、分类管理、标签管理、评论管理、用户管理、角色管理和权限管理等功能。 技术栈： Spring+SpringMVC+MyBatis

后端开发工具： IDEA DataGrip
前端开发工具：VScode

由于还没做权限管理，评论直接把用户信息去掉了。

涉及到的技术栈
1.前端
JS框架：JQuery
CSS框架：Semantic UI官网
Markdown编辑器：编辑器 Markdown
代码高亮：代码高亮 prism
动画效果：动画 animate.css



2.后端
核心框架：SpringBoot 2.2.5
项目构建：jdk1.8、Maven 3
持久层框架：Mybatis(后续重构为MybatisPlus)
缓存框架：springBoot整合Redis
模板框架：Thymeleaf
分页插件：PageHelper(后续重构为使用MybatisPlus内置分页功能)
运行环境：阿里云Centos7
3.数据存储
MySQL+Redis(热点文章（Top序列）)


1.数据表设计
博客数据表：t_blog
分类数据表：t_type
用户数据表：t_user
评论数据表：t_comment
留言数据表：t_message
友链数据表：t_friend
相册数据表：t_picture