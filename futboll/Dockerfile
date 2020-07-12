FROM gradle:4.7.0-jdk8-alpine AS build

#maintainer
MAINTAINER hkdemircan06@gmail.com

COPY . /home/app/api
WORKDIR /home/app/api


EXPOSE 8080



ENTRYPOINT ["java","-jar","/home/app/api/build/libs/futboll-0.0.1-SNAPSHOT.jar","--spring.profiles.active=product"]