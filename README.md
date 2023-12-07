# RestAPI
# Library Management System

This is a simple Library Management System API implemented using Spring Boot and PostgreSQL.

## Prerequisites
- Java 8 or later
- PostgreSQL database installed and running

## How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system

**Configure Database:**
Open src/main/resources/application.properties.
Update the spring.datasource.url, spring.datasource.username, and spring.datasource.password properties with your PostgreSQL configuration.

**Run the Application:**
./mvnw spring-boot:run
The application will start at http://localhost:8080

To seed the database with mock data, we can use the following endpoint:
curl -X POST http://localhost:8080/api/books/seed

**API Documentation**
1. Get All Books
Endpoint: GET /api/books
Description: Retrieve a list of all books in the library.
Response:
Success (200 OK):
```bash
[
  {
    "id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publicationYear": "1925-04-10",
    "genre": "Classic"
  },

  {
    "id": 2,
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "publicationYear": "1960-07-11",
    "genre": "Fiction"
  },
  
  {
    "id": 3,
    "title": "The Catcher in the Rye",
    "author": "J.D. Salinger",
    "publicationYear": "1951-07-16",
    "genre": "Coming-of-age"
  },
  
  {
    "id": 4,
    "title": "1984",
    "author": "George Orwell",
    "publicationYear": "1949-06-08",
    "genre": "Dystopian"
  },
  // ... other books
]
```
Not Found (404 Not Found):
"No books found"

2. Add a New Book
Endpoint: POST /api/books
Description: Add a new book to the library.
Request:
```bash
{
  "title": "The Catcher in the Rye",
  "author": "J.D. Salinger",
  "publicationYear": "1951-07-16",
  "genre": "Coming-of-age"
}
```
**Response:** Success (200 OK):
```bash
"Book details added successfully"
```

3. Update a Book by ID
Endpoint: PUT /api/books/{id}
Description: Update the details of a specific book.
**Request:**
```bash
{
  "title": "Updated Title",
  "author": "Updated Author",
  "publicationYear": "2000-01-01",
  "genre": "Updated Genre"
}
```
**Response:**
Success (200 OK):
```bash
{
  "id": 1,
  "title": "Updated Title",
  "author": "Updated Author",
  "publicationYear": "2000-01-01",
  "genre": "Updated Genre"
}
```
**Not Found (404 Not Found):**
```bash
"Book not found"
```

4. Seed Database with Mock Data
Endpoint: POST /api/books/seed
Description: Populate the database with sample book entries.
**Response:**
```bash
"Mock data seeded successfully"
```
