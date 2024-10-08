# Library-Management-System
This is a Spring Boot application for managing a library, including books, patrons, and borrowing records.
## Requirements
● Implement RESTful endpoints to handle the following operations:       
● Book management endpoints            
● Patron management endpoints            
● Borrowing endpoints   
WITH Validation and Error Handling,Transaction Management 

## Technologies Used
- Java 8
- Spring Boot
- Spring Data JPA
- Lombok
- SQL(H2)
- Maven
## Installation
  1. Clone the repository:
   git clone https://github.com/AhmedHamdadaELhadad/Library-Management-System.git

2. Navigate to the project directory:
   ```bash
   cd Library-Management-System
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
## Running the Application

The application runs on `http://localhost:8080`.

# API Endpoints:

## Patron Books
- **Get all books:**
  - Method: `GET`
  - URL: `/api/books`

- **Get a book by ID:**
  - Method: `GET`
  - URL: `/api/books/{id}`

- **Add a new book:**
  - Method: `POST`
  - URL: `/api/books`
  - 
- **Update a book:**
  - Method: `PUT`
  - URL: `/api/books/{id}`
  - 
- **Delete a book:**
  - Method: `DELETE`
  - URL: `/api/books/{id}`
## Patron Management

- **Get all patrons:**
  - Method: `GET`
  - URL: `/api/patrons`

- **Get a patron by ID:**
  - Method: `GET`
  - URL: `/api/patrons/{id}`

- **Add a new patron:**
  - Method: `POST`
  - URL: `/api/patrons`

- **Update a patron:**
  - Method: `PUT`
  - URL: `/api/patrons/{id}`

- **Delete a patron:**
  - Method: `DELETE`
  - URL: `/api/patrons/{id}`

### Borrowing and Returning Books:

- **Borrow a book:**
  - Method: `POST`
  - URL: `/api/borrow/{bookId}/patron/{patronId}`

- **Return a book:**
  - Method: `PUT`
  - URL: `/api/return/{bookId}/patron/{patronId}`



## Database Configuration 

### The application uses an embedded H2 database. The database can be accessed via the H2 console at `http://localhost:8080/h2-console`.

- **JDBC URL:** `jdbc:h2:mem:lms
- **Username:** `sa`
- **Password:** 














   
