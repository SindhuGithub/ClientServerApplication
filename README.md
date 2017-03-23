 


This is simple client server application which contains a simple form with each field in a separate slot of a table. 
This form is geared to post towards “/”. There are three fields in the EmployeeForm(name, age, email) 
and next to each field is a secondary element used to show any validations errors.


And submit button to submit the form. If the employee enters the information that violates the  @valid constraints, 
it will bounce back to this page with the error message on display. If the information is correct, the employee routed
to the next web page. 


Main application class file name resides in package com.atex.blogping  that initiates the operations
AtexApplication.java

Software used to develop & build the application:
OS 32/64 bit JAVA 1.8(jdk1.8.0_91) Spring Boot 1.4 Maven 3.0.5 Junit 4.11 Intellij 2015

To build the application:
mvn clean install mvn verify test

Test cases
Tests covers expected operations mentioned in the assignment. There are 5 test cases run when application is built, 
any changes in application can be easily caught by tests.
