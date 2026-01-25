FROM maven:3.9.6-eclipse-temurin-21

ENV PROJECT_HOME /usr/src/todolist
ENV JAR_NAME todolist.jar

RUN mkdir -p $PROJECT_HOME
WORKDIR $PROJECT_HOME

COPY . .

RUN mvn clean package -DskipTests

RUN mv $PROJECT_HOME/target/$JAR_NAME $PROJECT_HOME

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "todolist.jar"]