# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#FROM alpine:latest
#CMD ["/bin/sh"]
From openjdk:8
COPY /Users/surajit.samui/.m2/repository/com/javainuse/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
