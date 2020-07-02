FROM java:8-jre-alpine
MAINTAINER yangrd <zhugeyangyang1994@163.com>
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/' /etc/apk/repositories
VOLUME /tmp
ADD ./ipress-run/target/*.jar /app.jar
RUN sh -c 'touch /app.jar'
RUN echo $(date) > /image_built_at

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=rel"]