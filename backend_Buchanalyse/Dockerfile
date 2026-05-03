FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY backend_Buchanalyse .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/backend_buchanalyse-0.0.1-SNAPSHOT.jar"]