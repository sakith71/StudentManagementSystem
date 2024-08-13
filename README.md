# Student Management System

## Overview
The **Student Management System** is a Java-based application designed to manage students, modules, and related data. This project streamlines the management process by providing a structured system to handle student information and course modules efficiently.

## Description
The **Student Management System** is a comprehensive application designed to simplify the process of managing students and their associated academic modules. Built using Java, this system provides a user-friendly interface for administrators, teachers, or school staff to efficiently handle student records and course modules.

## Key Components

The **Student Management System** is composed of several key components, each playing a critical role in the functionality and structure of the application:

### 1. **Student Class**
   - **Purpose**: Represents a student in the system.
   - **Attributes**:
     - `name`: The name of the student.
     - `id`: A unique identifier for each student.
     - `modules`: A list or collection of modules that the student is enrolled in.
   - **Functions**:
     - Methods to get and set student details.
     - Methods to enroll and remove students from modules.

### 2. **Module Class**
   - **Purpose**: Represents an academic module/course in the system.
   - **Attributes**:
     - `moduleName`: The name of the module.
     - `moduleCode`: A unique code to identify the module.
     - `enrolledStudents`: A list or collection of students enrolled in the module.
   - **Functions**:
     - Methods to get and set module details.
     - Methods to add or remove students from the module.

### 3. **StudentManagementSystem Class**
   - **Purpose**: The main class that ties together the functionality of the student and module classes.
   - **Attributes**:
     - `students`: A collection or database of all students in the system.
     - `modules`: A collection or database of all modules in the system.
   - **Functions**:
     - Methods to add, update, or delete student records.
     - Methods to create, update, or delete modules.
     - Methods to assign students to modules and manage enrollments.

### 4. **Data Storage and Persistence**
   - **Purpose**: Ensures that student and module data are stored and can be retrieved even after the application is closed.
   - **Features**:
     - The system could be designed to save data in files, databases, or other forms of persistent storage.
     - Methods to load and save data automatically when the system starts and stops.

### 5. **User Interface (if applicable)**
   - **Purpose**: Provides a user-friendly way to interact with the system.
   - **Features**:
     - If there is a graphical or command-line interface, it allows users to add, modify, and manage student and module data easily.
     - The interface guides the user through various operations, ensuring that the system is easy to use.

### Objectives
The primary goal of this project is to create a robust and scalable system that reduces the administrative burden associated with managing student information and academic modules. By leveraging object-oriented programming principles, this application ensures that the data is well-organized, easy to manipulate, and secure.

### Use Cases
- **Educational Institutions**: Schools, colleges, and universities can use this system to manage their student databases and course offerings.
- **Tutoring Centers**: Small to medium-sized tutoring centers can keep track of their students and the subjects they are enrolled in.
- **Online Learning Platforms**: The system can be adapted to manage students and courses for e-learning platforms.

## Features
- **Student Management**: Add, update, and delete student records.
- **Module Management**: Manage course modules, including module details and the students enrolled.
- **Data Storage**: Persist student and module data for retrieval and updates.

## Project Structure
The project consists of the following main files:

- **StudentManagementSystem.java**: The main class that manages the overall functionality of the application.
- **Student.java**: The class representing a student, containing attributes such as name, ID, and enrolled modules.
- **Module.java**: The class representing a module, containing attributes such as module name, code, and the list of enrolled students.

## Installation
To run this project on your local machine, follow these steps:

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/sakith71/StudentManagementSystem.git
    ```
2. **Navigate to the Project Directory**:
    ```bash
    cd StudentManagementSystem
    ```
3. **Compile the Java Files**:
    ```bash
    javac *.java
    ```
4. **Run the Application**:
    ```bash
    java StudentManagementSystem
    ```

## Usage
Once the application is running, you can:

- Add new students and modules.
- Update or delete existing student and module records.
- Assign students to modules.


## Contact
If you have any questions or suggestions, feel free to reach out at [sakiththewmika71@gmail.com](mailto:sakiththewmika71@gmail.com).
