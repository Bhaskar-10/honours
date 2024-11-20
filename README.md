# EduTrack CI

EduTrack CI is a Spring Boot-based Student Management System providing a RESTful API to manage student data. It includes user registration, login, profile management, and is deployed via a Jenkins CI/CD pipeline to AWS.

---

## Features

- **User Registration**: Secure registration for new students.
- **User Login**: Login with email and password.
- **Unique Accounts**: Prevents duplicate account creation using the same email.
- **Student Information Management**: 
  - Retrieve student details.
  - Update student details.

---

## API Endpoints

### Base URL: `/students`

1. **Register a Student**
   - **Endpoint**: `POST /students/register`
   - **Request Body**:
     ```json
     {
       "name": "John Doe",
       "email": "john.doe@example.com",
       "password": "securepassword"
     }
     ```
   - **Response**:
     - `201 Created`: Registration successful.
     - `400 Bad Request`: Email already exists.

2. **Login**
   - **Endpoint**: `POST /students/login`
   - **Request Body**:
     ```json
     {
       "email": "john.doe@example.com",
       "password": "securepassword"
     }
     ```
   - **Response**:
     - `200 OK`: Login successful for the given student.
     - `401 Unauthorized`: Invalid credentials.

3. **Get Student Information**
   - **Endpoint**: `GET /students/{id}`
   - **Path Parameter**: `id` (String, required)
   - **Response**:
     - `200 OK`: Returns the student's details.
     - `404 Not Found`: Student ID does not exist.

4. **Update Student Information**
   - **Endpoint**: `PUT /students/{id}`
   - **Path Parameter**: `id` (String, required)
   - **Request Body**:
     ```json
     {
       "name": "Updated Name",
       "email": "updated.email@example.com",
       "password": "newpassword"
     }
     ```
   - **Response**:
     - `200 OK`: Information updated successfully.
     - `404 Not Found`: Student ID does not exist.

---

## Technologies Used

- **Backend**: Spring Boot
- **Database**: Hibernate/JPA (integration-ready)
- **CI/CD**: Jenkins
- **Cloud Deployment**: AWS (EC2)

---

## Installation and Setup

1. **Clone the Repository**
   ```bash
   git clone <repository_url>
   cd EduTrack-CI

   ```
2. **Build and Run Locally**
    ```bash
    mvn clean install
    java -jar target/student-management-system.jar
   ```
### 3. Jenkins Pipeline
Use the provided `Jenkinsfile` to automate deployment:
1. Clone the repository.
2. Build the JAR using Maven.
3. Upload the JAR to AWS EC2.
4. Start the application on EC2.

### 4. Postman Testing
- Import the API endpoints into Postman for testing.
- Replace `{id}` with the actual student ID returned during registration.

---

## CI/CD Workflow
- **Source Code Management:** GitHub repository.
- **Build:** Maven build executed in Jenkins.
- **Deployment:** Application deployed to AWS EC2 instance via SCP/SSH.
- **Monitoring:** Logs available in Jenkins job console output.

---

## License
This project is licensed under the MIT License.

