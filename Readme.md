<p align="center">
  <img src="https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/logo.png" alt="ТвоеРасписание"/>
</p>

# Облачное приложение "ТвоеРасписание" (используя Spring)
![JDK version](https://img.shields.io/static/v1?label=JDK&message=1.8%2B&color=<COLOR>)
![Database](https://img.shields.io/static/v1?label=Database&message=PostgreSQL&color=<COLOR>)
![build](https://img.shields.io/static/v1?label=build&message=Maven&color=<COLOR>)
![SpringBoot](https://img.shields.io/static/v1?label=SpringBoot&message=2.2.1&color=<COLOR>)
![TemplateEngine](https://img.shields.io/static/v1?label=TemplateEngine&message=Thymeleaf&color=<COLOR>)
![ORM](https://img.shields.io/static/v1?label=ORM&message=Hibernate&color=<COLOR>)



Простое приложение планировщик

Ссылка для демонстрации работы: https://viazmin-web.herokuapp.com
 
## _Причины создания_

 Данный проект создан для демонстрации возможностей Spring и в целях личного обучения 

## _Скриношты_
[![ТвоеРасписание](https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/Screenshot_1.jpg)]()
[![ТвоеРасписание](https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/Screenshot_2.jpg)]()
[![ТвоеРасписание](https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/Screenshot_3.jpg)]()
[![ТвоеРасписание](https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/Screenshot_4.jpg)]()
[![ТвоеРасписание](https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/Screenshot_5.jpg)]()
[![ТвоеРасписание](https://thumb.cloud.mail.ru/weblink/thumb/xw1/e4QB/p6cn6h4Fs/Screenshot_6.jpg)]()

## _Участие в разработке_

В зависимости от того, где вы хотите запустить проект (localhost или, например, на Heroku) следует редактировать файл `application.properties` в директории `src/main/resources`.

Пример для **localhost** :

```
server.port=8082
server.servlet.context-path=/

#spring.datasource.url=jdbc:postgresql://localhost:<порт вашей БД, для PostgreSQL по умолчанию это 5432>/todo_app_db
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_app_db
#<по умолчанию в PostgreSQL username это postgres>
spring.datasource.username=postgres 
spring.datasource.password=<Ваш пароль от БД>

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
```

Если все было настроено правильно, Вы сможете запустить проект на Вашей локальной машине. Создавать БД вручную не нужно. За Вас все должен сделать Hibernate

Пример для **Heroku** :

```
server.port=${PORT}
server.servlet.context-path=/

spring.datasource.url=${JDBC_DATABASE_URL}
spring.datasource.username=${JDBC_DATABASE_USERNAME}
spring.datasource.password=${JDBC_DATABASE_PASSWORD}

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
```
