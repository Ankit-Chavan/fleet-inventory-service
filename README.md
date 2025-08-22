Fleet-Inventory-service
Scalable Spring Boot service for fleet inventory and allocation with secure REST APIs, optimized data structures for fast allocations, JPA persistence, Docker support, and a pluggable ML predictor for utilization forecasting and demand-driven allocation.

Project description
Fleet Inventory Service is a scalable Spring Boot microservice for managing vehicle inventory, automated allocation, and utilization forecasting. It exposes secure REST APIs to manage inventory and allocations, uses optimized in-memory and persistent data structures for high-throughput allocation decisions, and includes a pluggable ML predictor to forecast vehicle usage and improve allocation efficiency. The service is production-ready with metrics, DB migrations, and Docker support for easy deployment.

Key features
RESTful APIs for inventory and allocation management
Efficient server-side allocation engine using optimized data structures
ML-based utilization and demand prediction (pluggable predictor)
Role-based security and observability (metrics/actuator)
JPA-backed persistence with DB migration scripts
Docker and docker-compose for local/dev deployments
Unit tests and simple CI-friendly build
Tech stack (short)
Java 17, Spring Boot, Spring Data JPA, Spring Security, MySQL, Maven, Docker, optional ML runtime.****
