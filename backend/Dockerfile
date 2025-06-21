# Use Eclipse Temurin base image (OpenJDK 17)
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy everything from your backend project into the container
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the Spring Boot application
RUN ./mvnw clean install -DskipTests -Dmaven.test.skip=true


# Expose port (Render will override with $PORT anyway)
EXPOSE 8080

# Run the Spring Boot app
CMD ["./mvnw", "spring-boot:run"]
