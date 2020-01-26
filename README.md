# Fuse CXF REST API with Hibernate (MSSQL)
FUSE Hibernate integration with MS SQL

Intention of this project is to guide, setup of basic CRUD operations using CXF REST API using Hibernate on FUSE 7.4 version with MSSQL server

This project can be build using following command on maven

mvn clean install

Then need to install bunddles using following command on FUSE environment 

feature:repo-add mvn:com.fuse.hibernate.example/Feature/1.0-SNAPSHOT/xml
feature:install osgi-customer-management-datasource
feature:install Model
feature:install Service
feature:install Application

Once application running on FUSE you can run following commands to test the API

To Create new person
curl -X POST -T C:/Users/Person3.xml -H "Content-Type: text/xml" http://localhost:8181/cxf/crm/personservice/persons

To Update existing person
curl -X PUT -T C:/Users/Person.xml -H "Content-Type: text/xml" http://localhost:8181/cxf/crm/personservice/persons

To Get existing person
curl -X GET http://localhost:8181/cxf/crm/personservice/persons/1

To Delete existing person
curl -X DELETE http://localhost:8181/cxf/crm/personservice/persons/1

You can refer to complete guide of project structure from following blog post 
https://nirmalbalasooriya.blogspot.com/2020/01/jboss-fuse-74-with-jpa-hibernate-in.html.