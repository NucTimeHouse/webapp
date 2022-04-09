# 时光小屋私密照片分享平台
## 技术栈
#### 前端框架
 - Bootstrap
 - Vue
 - Layui
#### 后台框架
 - Spring
 - Spring MVC
 - Mybatis
 - Tomcat
## 项目进度
#### 已实现：
 - 用户
   - 登录注册
 - 照片
   - 查看
   - 上传
   - 下载
   - 删除
   - 分享
 - 相册
   - 添加相册
   - 删除相册
   - 查看相册
 - 回收站
   - 恢复照片
   - 彻底删除照片

 
## 使用须知
 - 本程序在用户注册时需要通过邮件发送激活码，因此请确保您的邮箱开启了SMTP服务。
 - 克隆后您需要在resource目录下添加mail.properties文件,内容如下。
```properties
mail.host=yourEmailHost #目前仅支持QQ邮箱或绑定在QQ邮箱的域名邮箱
mail.password=yourEmailPassword  #在邮箱服务上开启SMTP时授予的密码
mail.organization=yourOrganizationName  #这决定了发邮件时使用的公司名 可任意填写
```
 - 数据库文件位于webapp下。
