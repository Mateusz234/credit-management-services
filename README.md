# Credit management services.

##Running in Docker:

Tools needed:
- maven
- docker, docker-compose (step-by-step instruction: https://docs.docker.com/install/)

###Run:
- Build all services (no script yet) manually with mvn clean package so it will generate jars. 
- run docker-compose.yml with "sudo docker-compose up --build" it will build docker images
with current jars from target folder in every service and then run containers with services and database.

##Notes:
All folders by docker are created in local directory  
  
(from documentation) "The Docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo."   
So to prevent it you must create new group:   
 - sudo groupadd docker    
Then add yourself to that group:  
 - sudo usermod -aG docker $USER    
relog and now you can use docker commands without sudo prefix. (Note that new docker group grants privileges equivalent to the root user)  
more info: https://docs.docker.com/install/linux/linux-postinstall/



