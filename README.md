Credit management services.

How to run it in containers:

Tools needed:
- maven
- docker, docker-compose

Run:
- Build all services (no script yet) manually with mvn clean package so it will generate jars. 
- run docker-compose.yml with "sudo docker-compose up"

Notes:
- All folders by docker are created in local directory - no root needed
- Change dockers permissions locally to not use sudo
- You can call services separately (on localhost, ports 8081-8083), 
but for now there are communication issues so services cannot communicate with each other and with database.


