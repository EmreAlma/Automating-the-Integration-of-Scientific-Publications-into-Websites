# PubSync Project

## Description

PubSync is a Spring Boot-based web application designed for synchronizing and managing academic publications. It provides functionalities to interact with external publication databases, manage author and publication data, and generate exportable files.

## Features

- Fetch publication data from external APIs (e.g., DBLP API).
- CRUD operations for authors and publications.
- Generate markdown files with publication data.
- Filter and export publication data based on various criteria.

## Installation

### Prerequisites

- Java JDK (Version 17 or later)
- Spring Boot (Version 3.0.6)
- Maven for project building
- An SQL database (e.g., H2, MySQL, PostgreSQL)

### Setup

1. Clone the repository: `git clone https://github.com/EmreAlma/Integration-of-Publications.git`.
2. Navigate to the project directory: `cd pubsync`.
3. Configure your database settings in `src/main/resources/application.properties`.
4. Build the project: `mvn clean install`.
5. Run the application: `mvn spring-boot:run`.

## Usage

The application provides a web interface and REST endpoints to manage authors and publications.

### Key Endpoints

- `/ui/authors`: Manage authors (add, update, delete).
- `/all`: View all publications.
- `/ui/fetchAndSave`: Fetch and save publications for all authors.

## Database Configuration and Access

This project uses the H2 database, a lightweight in-memory database, ideal for development and testing.

### Accessing the H2 Console

1. Run the application and navigate to `http://localhost:8080/h2` in your web browser.
2. Use the following details to log in:
    - JDBC URL: `jdbc:h2:file:./data/spring-boot-h2-db`
    - Username: `your_username` (replace with your configured username, if applicable)
    - Password: `your_password` (replace with your configured password, if applicable)

The H2 console allows you to query and manage the database directly through a web interface.

### Data Storage

The H2 database is configured to store data in a file located in the `./data` directory at the root of the application.
This configuration ensures data persistence across application restarts. The data is stored in the `spring-boot-h2-db` file within this directory.


## Architecture Overview

### Service Classes

- `AuthorApiService`: Interacts with the external publication database API.
- `AuthorPublicationService`: Manages the fetching and saving of publication data for authors.
- `ConverterService`: Converts API response data to application-specific models.
- `FileService`: Generates markdown files based on publication data.
- `FilterService`: Filters publications based on specific criteria.
- `PublicationDatabaseManager`: Manages database operations for publications.

### Controllers

- `AuthorController`: Handles web requests related to authors.
- `PublicationViewController`: Manages web requests for viewing and exporting publications.

### Entity Classes

- `Author`: Represents author data.
- `Publication`: Represents publication data.

### Repository Classes

- `AuthorRepository`: Manages database operations for `Author` entities.
- `PublicationRepository`: Manages database operations for `Publication` entities.

### HTML Templates

- Thymeleaf templates for rendering UI pages.

## Development

This project follows the MVC pattern with service-oriented architecture. It's built using Spring Boot, which simplifies the bootstrapping and development of new Spring applications.

### Key Dependencies

- Spring Boot Web: For building web applications.
- Spring Boot Data JPA: For database interactions.
- Gson: For JSON parsing.
- Thymeleaf: For server-side HTML rendering.

## Testing

Unit tests can be added in the `src/test` directory. Spring Boot's support for embedded databases and mocking makes it convenient to test service layers.

## License

This project is licensed under the MIT License.

## Contributors

- Emre Alma