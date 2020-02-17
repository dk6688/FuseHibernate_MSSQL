# FuseHibernate_MSSQL
FUSE Hibernate integration with MS SQL

Intention of this project is to guide, setup of basic CRUD operations using Hibernate on FUSE 7.4 version with MSSQL server

This project can be build using following command on maven

mvn clean install

Then need to install bunddles using following command on FUSE environment 

feature:repo-add mvn:com.fuse.hibernate.example/Feature/1.0-SNAPSHOT/xml
feature:install osgi-customer-management-datasource
feature:install Model
feature:install Service
feature:install Application

You can refer to complete guide of project structure from following blog post 
https://nirmalbalasooriya.blogspot.com/2020/02/external-active-mq-hibernate-with-jboss.html
