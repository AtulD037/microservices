Spring Cloud Config Server
A centralized configuration management service for microservices architecture, providing externalized configuration in a distributed system with Git-backed storage and service discovery integration.

🚀 Quick Start
Prerequisites
Java 17+

Maven 3.6+

Git repository with configuration files

Run the Application
bash
# Using Maven wrapper (recommended)
./mvnw spring-boot:run

# Or using Maven directly
mvn spring-boot:run
The server will start on http://localhost:8888

📁 Project Structure

spring-cloud-config-server/
├── src/main/java/com/in28minutes/microservices/spring_cloud_config_server/
│   └── SpringCloudConfigServerApplication.java
├── src/main/resources/
│   └── application.properties
├── src/test/java/
│   └── SpringCloudConfigServerApplicationTests.java
├── pom.xml
├── mvnw & mvnw.cmd
└── .gitignore
⚙️ Configuration
Application Properties

spring.application.name=config-server
server.port=8888
spring.config.import=optional:configserver:
spring.cloud.config.server.git.uri=file:///path/to/your/git-localconfig-repo
spring.cloud.config.server.git.default-label=master
Git Repository Structure
Create a local Git repository with configuration files:


git-localconfig-repo/
├── application.yml                 # Default configuration for all services
├── application-dev.yml             # Development environment
├── application-prod.yml            # Production environment
├── eureka-server.yml              # Naming server configuration
├── currency-exchange-service.yml   # Service-specific configuration
└── currency-conversion-service.yml # Another service configuration
🔍 API Endpoints
Once running, access configurations via REST endpoints:

Endpoint	Description	Example
/{application}/{profile}	Get configuration in JSON	http://localhost:8888/currency-exchange-service/default
/{application}-{profile}.yml	Get YAML format	http://localhost:8888/currency-exchange-service-default.yml
/{application}-{profile}.properties	Get properties format	http://localhost:8888/currency-exchange-service-default.properties
🏗️ Microservices Architecture Integration
Service Discovery (Eureka)
Config server registers with Eureka Server

Other microservices discover config server automatically

Enables load balancing and high availability

API Gateway
Gateway retrieves routing configuration from config server

Centralized management of routes and filters

Dynamic updates without restart

Client Services Configuration
Add to your microservice's application.yml:


spring:
  application:
    name: your-service-name
  config:
    import: "configserver:http://localhost:8888"
  profiles:
    active: default
🛡️ Resilience Patterns
Circuit Breaker
Services use cached configuration if config server is unavailable

Automatic retry logic for failed requests

Fallback to local configuration files

Configuration Refresh
Runtime configuration updates without restart

Use @RefreshScope annotation on beans

Call /actuator/refresh endpoint for manual refresh

🔧 Key Features
✅ Centralized Configuration Management
✅ Git-backed Version Control
✅ Environment-specific Profiles
✅ Service Discovery Integration
✅ Dynamic Configuration Refresh
✅ Encryption/Decryption Support
✅ RESTful API
✅ Spring Boot 3.x Compatible

🧪 Testing
Health Check
bash
curl http://localhost:8888/actuator/health
Configuration Retrieval
bash
# Get default application configuration
curl http://localhost:8888/application/default

# Get service-specific configuration
curl http://localhost:8888/currency-exchange-service/default
📚 Learning Path
This Config Server is part of a complete microservices learning journey:

✅ Config Server (Current) - Centralized configuration

🔄 Eureka Server - Service discovery and registration

🌐 API Gateway - Routing and load balancing

⚡ Circuit Breaker - Fault tolerance with Resilience4j

📊 Distributed Tracing - Request tracking with Zipkin

📈 Monitoring - Metrics with Micrometer

🛠️ Development Commands
bash
# Build the project
./mvnw clean compile

# Run tests
./mvnw test

# Package as JAR
./mvnw clean package

# Run the JAR
java -jar target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar

# Skip tests during build
./mvnw clean package -DskipTests
🐛 Troubleshooting
Common Issues
❌ "No spring.config.import property defined"


# Add to application.properties
spring.config.import=optional:configserver:
❌ Git repository not found

Verify spring.cloud.config.server.git.uri path exists

Ensure Git repository is initialized and has commits

❌ Configuration not refreshing

Add @RefreshScope to configuration classes

Call POST to /actuator/refresh endpoint

📖 Additional Resources
Spring Cloud Config Documentation

Spring Boot Documentation

Microservices Patterns

📝 Notes
Package name changed from spring-cloud-config-server to spring_cloud_config_server due to naming conventions

Uses local file system Git repository for learning purposes

Production deployments should use remote Git repositories

Consider implementing security for production use

🎯 Next Steps: Set up Eureka Server for service discovery and register this Config Server as a client service.
