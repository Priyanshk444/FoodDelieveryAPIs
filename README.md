# Food Delivery APIs

This project is a Spring Boot-based REST API for a food delivery system, integrating MySQL as the database. It provides endpoints for user authentication, food management, cart operations, and address management.

## Technologies Used
- **Spring Boot** - Backend framework
- **Spring Security** - Authentication and authorization
- **MySQL** - Database for storing data
- **JWT (JSON Web Token)** - Secure authentication
- **Hibernate JPA** - ORM for database operations
- **Spring Data JPA** - Database interaction

## Setup Instructions

### Prerequisites
- Java 17+
- MySQL installed and running
- Postman or any API testing tool (optional)

### Clone the Repository
```bash
    git clone https://github.com/your-username/food-delivery-api.git
    cd food-delivery-api
```

### Configure Database
Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_del
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.security.user.name=root
spring.security.user.password=root
spring.security.user.roles=ADMIN
```

### Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### **Authentication** (`/auth`)
- **User Login**: `POST /auth/user/login`
- **User Registration**: `POST /auth/user/register`

### **Food Management** (`/food`)
- **Get all food items**: `GET /food`
- **Add food items (Admin Only)**: `POST /food`
- **Delete a food item (Admin Only)**: `DELETE /food`
- **Add add-ons (Admin Only)**: `POST /food/addOn`
- **Delete add-ons (Admin Only)**: `DELETE /food/addOn`

### **Cart Management** (`/cart`)
- **Add item to cart**: `POST /cart/{userId}`
- **Get cart items**: `GET /cart/{userId}`
- **Delete item from cart**: `DELETE /cart/item/{cartItemId}`
- **Clear cart**: `DELETE /cart/{userId}`

### **Address Management** (`/address`)
- **Get all addresses of a user**: `GET /address/{userId}`
- **Add an address**: `POST /address/{userId}`

## Security
- Uses **Spring Security** with **JWT authentication** for securing endpoints.
- Admin-restricted routes require an authenticated token with `ADMIN` role.


## Author
Priyansh Kumar

