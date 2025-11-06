# 🚖 GoRide – Ride-Hailing Backend System

<div align="center">
  <a href="https://goride-g1n3.onrender.com/swagger-ui/index.html" target="_blank">
    <img src="https://img.shields.io/badge/🚀_Live_API_Docs-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Live API Docs">
  </a>
  <a href="https://hub.docker.com/r/komalrathore22032001/goride-backend" target="_blank">
    <img src="https://img.shields.io/badge/View_on-DockerHub-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker Hub">
  </a>
</div>




<br>

## 📖 Project Overview
**GoRide** is a full-stack **ride-hailing backend system** built with **Java Spring Boot** that powers a complete cab booking lifecycle — from **booking a ride**, to **matching nearby drivers**, to **tracking live locations**, and **completing rides**.  
It’s designed for scalability, clean architecture, and secure communication through JWT authentication.

---

## ✨ Key Features

* **🚗 Complete Ride Lifecycle:** Book, match, track, and complete rides.  
* **📍 Geo-Spatial Matching:** Real-time nearest-driver detection using PostGIS and Hibernate Spatial.  
* **🔐 Secure Authentication:** JWT-based stateless login system with Spring Security.  
* **🧩 Layered Architecture:** Controller → Service → Repository → Database.  
* **🐳 Containerized Setup:** Dockerized backend for quick deployment.  
* **📊 Swagger Integration:** Beautifully documented REST APIs with live testing interface.

---

## 🛠️ Technologies Used

### 🧠 Backend
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

### 🗄️ Database
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![PostGIS](https://img.shields.io/badge/PostGIS-006400?style=for-the-badge&logo=postgis&logoColor=white)

---

## 🚀 Local Development Setup

### ✅ Prerequisites
* **Java Development Kit (JDK 17+)**
* **Maven 3.9+**
* **PostgreSQL (with PostGIS extension)**
* **Docker (optional)**

---

### ⚙️ Installation & Setup

#### 1. Clone the Repository
```bash
git clone https://github.com/komalrathore0521/GoRide.git
cd GoRide
```
#### 2. Configure PostgreSQL

Create a database named `goride` and enable the **PostGIS** extension:

```sql
CREATE DATABASE goride;
\c goride;
CREATE EXTENSION postgis;
```
#### 3. Configure Environment Variables

In `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/goride
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.spatial.dialect.postgis.PostgisDialect

# JWT Config
app.jwt.secret=yourSecretKey
app.jwt.expiration=86400000
```
#### 4. Run the Application

```bash
mvn spring-boot:run
```
##### Backend will start at 👉 http://localhost:8080

##### Swagger UI: http://localhost:8080/swagger-ui/index.html



## 📚 API Documentation

Below is the complete list of API endpoints for **GoRide**, grouped by user role.  
All APIs are fully documented and testable in **[Swagger UI](http://localhost:8080/swagger-ui/index.html)**.

---

### 🔐 Authentication APIs

| Method | Endpoint | Description | Auth Required | Role |
|---------|-----------|--------------|---------------|------|
| **POST** | `/auth/signup` | Register a new user (RIDER or DRIVER) | ❌ | Public |
| **POST** | `/auth/login` | Login user and receive JWT + refresh token cookie | ❌ | Public |
| **POST** | `/auth/onboardDriver/{userId}` | Convert a user to driver (admin only) | ✅ | ADMIN |
| **POST** | `/auth/refresh` | Refresh access token using refresh cookie | ✅ | Any |

---

### 🚗 Rider APIs

#### 📤 Rider – POST Endpoints

| Method | Endpoint | Description | Auth Required | Role |
|---------|-----------|--------------|---------------|------|
| **POST** | `/rider/requestRide` | Create a new ride request (pickup, destination, vehicle type) | ✅ | RIDER |
| **POST** | `/rider/cancelRide/{rideId}` | Cancel an active or upcoming ride | ✅ | RIDER |
| **POST** | `/rider/rateDriver/{rideId}` | Rate the driver after completing a ride | ✅ | RIDER |

#### 📥 Rider – GET Endpoints

| Method | Endpoint | Description | Auth Required | Role |
|---------|-----------|--------------|---------------|------|
| **GET** | `/rider/getMyProfile` | Retrieve logged-in rider’s profile | ✅ | RIDER |
| **GET** | `/rider/getMyRides` | Get all rides of the rider (paginated + sortable) | ✅ | RIDER |

---

### 🚖 Driver APIs

#### 📤 Driver – POST Endpoints

| Method | Endpoint | Description | Auth Required | Role |
|---------|-----------|--------------|---------------|------|
| **POST** | `/driver/acceptRide/{rideRequestId}` | Accept a pending ride request | ✅ | DRIVER |
| **POST** | `/driver/startRide/{rideId}` | Mark ride as started | ✅ | DRIVER |
| **POST** | `/driver/endRide/{rideId}` | Mark ride as completed and compute fare | ✅ | DRIVER |
| **POST** | `/driver/cancelRide/{rideId}` | Cancel ongoing or accepted ride | ✅ | DRIVER |
| **POST** | `/driver/rateRider/{rideId}` | Rate the rider after a completed ride | ✅ | DRIVER |

#### 📥 Driver – GET Endpoints

| Method | Endpoint | Description | Auth Required | Role |
|---------|-----------|--------------|---------------|------|
| **GET** | `/driver/getMyProfile` | Retrieve logged-in driver’s profile | ✅ | DRIVER |
| **GET** | `/driver/getMyRides` | Get all rides assigned to driver (paginated + sortable) | ✅ | DRIVER |

---
## 🔄 Sample API Flow

Below is the typical **end-to-end flow** of a ride within the **GoRide** system, showing how each user interacts with the APIs.

    ┌────────────────────┐
    │      SIGNUP        │
    │ /auth/signup       │
    │  (Rider / Driver)  │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │       LOGIN        │
    │ /auth/login        │
    │  → Get JWT Token   │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │   REQUEST RIDE     │
    │ /rider/requestRide │
    │  (Rider creates)   │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │   ACCEPT RIDE      │
    │ /driver/acceptRide │
    │  (Driver accepts)  │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │    START RIDE      │
    │ /driver/startRide  │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │     END RIDE       │
    │ /driver/endRide    │
    │  → Fare Generated  │
    └─────────┬──────────┘
              │
              ▼
    ┌────────────────────┐
    │    RATE DRIVER     │
    │ /rider/rateDriver  │
    │  (Rider feedback)  │
    └────────────────────┘
### 💡 Summary
1. **Rider** signs up and logs in.  
2. **Rider** requests a ride → creates a ride request entry.  
3. **Driver** accepts the ride from available requests.  
4. **Driver** starts and completes the trip.  
5. **Rider** gives feedback to the driver.  
6. **System** marks the ride as completed and records ratings.

---
## 🐳 Run with Docker

You can pull and run the latest container directly from Docker Hub:

```bash
docker pull komalrathore22032001/goride-backend:latest
docker run -d -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/goride \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=postgres \
  -e APP_JWT_SECRET=change-me \
  komalrathore22032001/goride-backend:latest

