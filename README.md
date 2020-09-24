## name
mysql-json-java

## Overview
sample code for using json format data from mysql

## Requirement
- Java 11
- Eclipse:2020-09 is recommended
- [docker-mysql-java](https://github.com/CHI-3/docker-mysql-java) with Docker or Docker Toolbox


## Usage
1. Download and unzip this package  or clone this project. Then, move it to the workspace directory in Eclipse directory.

2. Import the project into Eclipse as 'Existing Gradle Project'.

3. Create Docker container with [docker-mysql-java](https://github.com/CHI-3/docker-mysql-java) and start it.

4. Change MySQL connection settings in application.yml to your environment.

5. When it's finished, run as Spring Boot App.

6. Access URL below with your browser or api test tool.

**List of items by category**  
http://*{hostname}*:*{port number}*/item/category/*{categoryId}*

**Indivisual item**  
http://*{hostname}*:*{port number}*/item/indivisual/*{itemId}*

## Author
CHI-3


## References
- [Jackson使い方メモ | Qiita](https://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c)
