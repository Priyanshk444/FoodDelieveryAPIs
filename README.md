# 🍔 Food Delivery App

A full-stack web application that allows users to browse, order, and manage food items with role-based access and a secure, scalable backend.

## 📸 Demo 
https://youtu.be/L9uUhZwP_OQ

## 🚀 Overview

This Food Delivery App provides a responsive and component-based frontend with robust backend APIs for managing food items, user authentication, and admin operations.

Key features include:
- JWT-based authentication and role-based authorization
- Admin-restricted routes for managing menu items
- Secure RESTful APIs built with Spring Boot
- Persistent MySQL database with JPA and Hibernate
- Clean UI built with React and styled components

## 🛠️ Tech Stack

**Frontend:**
- React.js
- HTML5 / CSS3 / JavaScript

**Backend:**
- Java
- Spring Boot
- Spring Security
- RESTful API

**Database:**
- MySQL with Hibernate JPA

**Tools:**
- IntelliJ IDEA / VS Code
- Postman for API testing
- Git & GitHub for version control

---

## ✨ Features

- ✅ Responsive and component-based UI
- 🔐 JWT authentication with Spring Security
- 👤 Role-based access control (Admin, User)
- 🍽️ CRUD operations for food items (Admin only)
- 🛒 Cart and order management
- 🔗 Integrated frontend with backend APIs

---

## ⚙️ Getting Started

### 1. Clone the repository
git clone https://github.com/yourusername/food-delivery-app.git
cd food-delivery-app

### 2. Backend Setup (Spring Boot)
cd backend

 Configure MySQL credentials in application.properties
./mvnw spring-boot:run

### 3. Frontend Setup (React)
cd frontend
npm install
npm start

## 🧪 API Endpoints
POST /auth/register – Register a new user

POST /auth/login – Login and get JWT token

GET /items – Fetch available food items

POST /items – (Admin only) Add new food item

PUT /items/{id} – (Admin only) Update food item

DELETE /items/{id} – (Admin only) Delete food item

GET /cart – View user's cart

POST /cart/add – Add item to cart

## 🔐 Authentication
Uses JWT for session management.
Add the token to Authorization header as:
Bearer <your_token_here>

## 📁 Folder Structure
/frontend     # React frontend
/backend      # Spring Boot backend

## 📬 Contact
Created by Priyansh Kumar
GitHub: Priyanshk444

