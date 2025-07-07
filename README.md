# DinamicBoard

DinamicBoard is an interactive, dynamic, and multi-user web application that allows you to manage strokes on a digital board.

## Technologies

- Java 17
- Spring Boot 3.5.3
- Maven

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/DinamicBoard.git
   cd DinamicBoard
   ```
## Build and run the application:

  ```bash
  mvn spring-boot:run
  ```

## API Endpoints

* GET /strokes
  
  Retrieves the list of current strokes
  
* POST /strokes
  
  adds a new stroke.

  JSON Body:
  ```json
  {
    "x": 10.5,
    "y": 20.0,
    "color": "#FF0000"
  }  
  ```
* DELETE /strokes
  
Deletes all strokes.

## Configuration
you can change the port and application name in src/main/resources/application.properties.


