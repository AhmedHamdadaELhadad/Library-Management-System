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

## Books Management
- [![Run Books in Postman](https://run.pstmn.io/button.svg)](https://gold-flare-136526.postman.co/workspace/Team-Workspace~0995296d-00d7-473d-88f9-ff181e750100/folder/24469503-a1595cb2-50fb-434c-8ad6-461cb5e90f82?action=share&creator=24469503&ctx=documentation)
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
- [![Run in Postman](https://run.pstmn.io/button.svg)](https://gold-flare-136526.postman.co/workspace/Team-Workspace~0995296d-00d7-473d-88f9-ff181e750100/folder/24469503-af1a9054-4ced-4691-9703-ed3cb4368af4?action=share&creator=24469503&ctx=documentation)

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

### Borrowing Management :
- [![Run in Postman](https://run.pstmn.io/button.svg)](https://gold-flare-136526.postman.co/workspace/Team-Workspace~0995296d-00d7-473d-88f9-ff181e750100/folder/24469503-68f0ffc7-26ab-4a9e-b2a2-9bc049cdb740?action=share&creator=24469503&ctx=documentation)
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


## Entity-Relationship Diagram

```mermaid
erDiagram
    Books {
        SERIAL id PK
        VARCHAR title
        VARCHAR author
        INTEGER publicationYear
        VARCHAR isbn "UNIQUE"
    }
    Patron {
        SERIAL id PK
        VARCHAR name
        VARCHAR contactInfo "UNIQUE"
    }
    BorrowingRecord {
        SERIAL id PK
        DATE borrowDate
        DATE returnDate
        INTEGER book_id FK
        INTEGER patron_id FK
    }

    Books ||--o{ BorrowingRecord : borrows
    Patron ||--o{ BorrowingRecord : borrows

