# Credit management services.

##Running in Docker:

Tools needed:
- maven
- docker - https://docs.docker.com/install/linux/docker-ce/ubuntu/
- docker-compose - https://docs.docker.com/compose/install/

###Run:
- Build all services (no script yet) manually with mvn clean package in every service so it will generate jars. 
- run docker-compose.yml with "docker-compose up --build" it will build docker images
with current jars from target folder in every service and then run containers with services and database.

###Use examples
- After running applications, credit service is available at http://localhost:8081,  
product service at http://localhost:8082 and customer service at http://localhost:8083.  
- To get all credits access http://localhost:8081/getCredits.  
- To get product for selected credit: (if exists) http://localhost:8082/getProduct/creditId. 
- To get customer for selected credit:  (if exists) http://localhost:8083/getCustomer/creditId. 
- There are already some credits defined in database.
- To create new credit send POST request (using for example postman or some other service/application)  
like: localhost:8081/createCredit/name/surname/personalId/productName/value/creditName.  


##Notes:
All folders by docker are created in local directory  
  
(from documentation) "The Docker daemon binds to a Unix socket instead of a TCP port. By default that Unix socket is owned by the user root and other users can only access it using sudo."   
So to prevent it you must create new group:   
 - sudo groupadd docker    
Then add yourself to that group:  
 - sudo usermod -aG docker $USER    
relog and now you can use docker commands without sudo prefix. (Note that new docker group grants privileges equivalent to the root user)  
more info: https://docs.docker.com/install/linux/linux-postinstall/

##TODO
- Add tests for DAO and controllers



