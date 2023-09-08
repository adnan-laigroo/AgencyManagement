# Hospital Management System Project with Extra Features in Spring Boot

The Hospital Management System project is a RESTful API designed to manage various activities of a hospital, including patient management, doctor management, appointment management, patient record management, prescription management, medicine management, and medical test management. The project aims to streamline hospital operations, reduce manual work, and improve service efficiency.

## Project Objective

The main objective of this project is to provide an online platform for managing hospital activities. The system allows doctors to check appointments, view patient records, prescribe medicines, and order medical tests. Receptionists can book appointments for new patients, manage patient records, and handle prescription and medical test requests. Admins have access to all functionalities and can manage doctors, receptionists, medicines, and medical tests. By digitizing the workflow and integrating various functionalities, the project reduces manual work, streamlines processes, and improves overall efficiency.

## Actors/Users

The application has four main actors (users):

1. Admin: Responsible for managing doctors, receptionists, medicines, and medical tests.
2. Doctor: Can view appointments, access patient records, prescribe medicines, and order medical tests.
3. Receptionist: Can add, edit, and view patients, appointments, prescriptions, and medical test requests.
4. Pharmacist: Can manage medicines, including adding, updating, and deleting medicines from the inventory.

## Functional Requirements

### Admin

The admin has the following tasks and responsibilities:

- Add, delete, and update doctors
- View the list of doctors
- Add, delete, and update receptionists
- View the list of receptionists
- Add, delete, and update medicines
- View the list of medicines
- Add, delete, and update medical tests
- View the list of medical tests
- Change password

### Doctor

The doctor can perform the following operations:

- View appointments
- View patient records
- Prescribe medicines for patients
- Order medical tests for patients
- Change password

### Receptionist

The receptionist can perform the following operations:

- Add, edit, and view patients
- Add, edit, and view appointments
- Add, edit, and view prescriptions
- Add, edit, and view medical test requests
- Change password

### Pharmacist

The pharmacist can perform the following operations:

- Add, edit, and view medicines
- Change password

## Data Model and Backend Validation

### Doctor

The `Doctor` class has the following fields and backend validations:

- `firstname` (String): Only alphabets are allowed.
- `lastname` (String): Only alphabets are allowed.
- `emailid` (String, PK): Should be a valid email address. It serves as the doctor's username.
- `phoneno` (String): Only digits are allowed, and it must have at least 10 characters.
- `speciality` (String): Represents the doctor's specialization.

### Receptionist

The `Receptionist` class has the following fields and backend validations:

- `firstname` (String): Only alphabets are allowed.
- `lastname` (String): Only alphabets are allowed.
- `emailid` (String, PK): Should be a valid email address. It serves as the receptionist's username.
- `phoneno` (String): Only digits are allowed, and it must have at least 10 characters.

### Patient

The `Patient` class has the following fields and backend validations:

- `patid` (int, PK): Automatically generated ID with the format "P" followed by 5 digits.
- `firstname` (String): Only alphabets are allowed.
- `lastname` (String): Only alphabets are allowed.
- `address` (Address): Represents the patient's address.
- `phoneno` (String): Only digits are allowed, and it must have at least 10 characters.
- `symptom` (String): Represents the patient's symptom.

### Appointment

The `Appointment` class has the following fields and backend validations:

- `apid` (int, PK): Automatically generated ID with the format "A" followed by 6 digits.
- `patid` (int): Must exist in the `Patient` entity.
- `bloodGroup` (String): Should be a valid blood group value.
- `docid` (int): Must exist in the `Doctor` entity. The `docid` should be according to the patient's symptom.
- `appointmentDate` (LocalDate): Represents the appointment date and should be automatically entered as the current date.
- `appointmentTime` (String): Represents the appointment time in the format "hh:mm:ss".
- `appointmentStatus` (String): Represents the appointment status. It should be initially set to "pending" and can be updated by doctors, admin, or receptionists after the patient and doctor meeting.

### Prescription

The `Prescription` class has the following fields:

- `prescriptionId` (int, PK): Automatically generated ID for the prescription.
- `patientId` (int): Must exist in the `Patient` entity.
- `doctorId` (int): Must exist in the `Doctor` entity.
- `diagnosis` (String): Represents the doctor's diagnosis.
- `medicines` (List of `Medicine`): Contains the list of prescribed medicines.
- `medicalTests` (List of `MedicalTest`): Contains the list of prescribed medical tests.

### Medicine

The `Medicine` class has the following fields:

- `medicineId` (int, PK): Automatically generated ID for the medicine.
- `medicineName` (String): Represents the name of the medicine.
- `manufacturer` (String): Stores the name of the medicine manufacturer.
- `description` (String): Provides a description of the medicine.
- `price` (double): Represents the price of the medicine.
- `quantity` (int): Indicates the quantity of the medicine in stock.

### MedicalTest

The `MedicalTest` class has the following fields:

- `testId` (int, PK): Automatically generated ID for the medical test.
- `testName` (String): Represents the name of the medical test.
- `testDescription` (String): Provides a description of the medical test.
- `testPrice` (double): Represents the price of the medical test.
- `testType` (String): Indicates the type of the medical test.

### Prescription Generation PDF

A new feature has been added to the Hospital Management System project, which allows the generation of prescription PDFs. When a doctor creates a prescription for a patient, the system automatically generates a PDF document that includes the patient's details, doctor's details, diagnosis, prescribed medicines, and medical tests. This PDF can be easily downloaded, printed, or shared with the patient for their reference.

## Technologies Used

The project is implemented using the following technologies:

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (Database)
- Maven (Dependency Management)
- Postman (API Testing)
- iText PDF Library (for generating prescription PDFs)

## Features

The Hospital Management System project offers the following features:

1. Appointment Time Conflict Check: Before saving the appointment, the system checks for appointment time conflicts and assigns the appointment to the doctor with the least pending appointments. If a conflict is found, the system automatically assigns the appointment to the next available doctor.

2. Prescription Generation PDF: The system generates a PDF document for each prescription, including patient details, doctor details, diagnosis, prescribed medicines, and medical tests. This feature helps in maintaining accurate and printable prescription records.

3. CRUD Operations: The system provides CRUD (Create, Read, Update, Delete) operations for managing doctors, receptionists, medicines, medical tests, patients, appointments, and prescriptions.

4. Role-based Access Control: The system supports role-based access control, allowing different users (admin, doctor, receptionist) to access and perform specific functionalities based on their roles.

5. Data Validation: The system applies backend validation to ensure data integrity and prevent invalid inputs during the creation and modification of entities.

6. Database Persistence: The system uses Spring Data JPA and Hibernate for seamless integration with the database and efficient data persistence.

7. API Documentation: The system includes API endpoints that can be easily tested and explored using tools like Postman. The project documentation provides details about the available endpoints and their usage.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).
3. Configure the MySQL database connection in `application.properties`.
4. Build the project using Maven.
5. Run the application.
6. Use Postman or any other API testing tool to test the endpoints.

## API Endpoints

The project exposes the following API endpoints:

- `/api/doctors` (GET, POST, PUT, DELETE): Used for managing doctors.
- `/api/receptionists` (GET, POST, PUT, DELETE): Used for managing receptionists.
- `/api/medicines` (GET, POST, PUT, DELETE): Used for managing medicines.
- `/api/medicaltests` (GET, POST, PUT, DELETE): Used for managing medical tests.
- `/api/patients` (GET, POST, PUT, DELETE): Used for managing patients.
- `/api/appointments` (GET, POST, PUT, DELETE): Used for managing appointments.
- `/api/prescriptions` (GET, POST, PUT, DELETE): Used for managing prescriptions.

Note: Replace `api` with the appropriate base URL or endpoint base path.

## Project Structure

The project follows a standard Spring Boot application structure:

- `src/main/java/com/example/hospital`: Contains the main Java classes and packages.
  - `config`: Contains the configuration classes for Spring Boot and the database.
  - `controller`: Contains the RESTful API controllers.
  - `dto`: Contains the Data Transfer Objects used for request/response mapping.
  - `exception`: Contains the custom exception classes.
  - `model`: Contains the entity classes representing the data model.
  - `repository`: Contains the JPA repositories for database operations.
  - `service`: Contains the service classes for business logic.
  - `util`: Contains utility classes, including the prescription PDF generator.
  - `HospitalManagementSystemApplication.java`: The entry point of the Spring Boot application.
- `src/main/resources`: Contains the application properties and database schema script.
- `src/test/java/com/example/hospital`: Contains the test classes.

## Conclusion

The Hospital Management System project provides a comprehensive solution for managing various activities within a hospital. It leverages Spring Boot and other technologies to build a scalable and efficient backend system. The addition of the prescription PDF generation feature enhances the functionality and usability of the system. The project can be further expanded and customized to meet specific requirements, such as user authentication, billing management, and integration with external systems.

Feel free to explore the project, contribute to its development, or adapt it for your specific needs. If you have any questions or need assistance, please reach out to us.

Happy coding!
