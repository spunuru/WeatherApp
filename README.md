WeatherApp
==========

1. WeatherApp application displays 7 day weather forecast for a city selected
by user. 
2. UI is developed using ExtJS framework. 
3. REST API is developed using Spring framework.
4. Sprint Boot is used to minimize configuration and use defaults.


What is in it?
-----------------

WeatherApp contains following two folders -
1. weatherapp folder - contains maven based Java project.
2. weatherapp_js folder - contains ExtJS project.


Building WeatherApp
--------------------

Prerequisites

1. JDK 1.6 or higher is required.
2. Maven should be installed.

Steps.

1. clone WeatherApp
2. cd weatherapp
3. mvn clean install

Note - it is not required to build ExtJS project (in weatherapp_js folder). 
It is already built and included in Java project (in weatherapp folder).


Running WeatherApp
--------------------
cd weatherapp

java -jar target/weatherapp-0.1.0.jar

Open URL http://localhost:8080 in Browser

Select a city to check the weather forecast

Checking logs
--------------
Check weatherapp.log in the current folder where java -jar command is run.
