# Student Course Management System

This project is a console-based Java application developed using Object-Oriented Programming (OOP) principles. 
It allows users to manage students and courses, enroll students in courses, and store data using text files.

## Features
- Add students
- Remove students
- Add courses
- Remove courses
- Enroll students in courses
- View all students
- View all courses
- Store and load data from text files


## Project Structure
- `src/model/Student.java` - represents the student entity
- `src/model/Courses.java` - represents the course entity
- `src/repository/StudentRepository.java` - manages student data
- `src/repository/CoursesRepository.java` - manages course data
- `src/service/EnrollmentService.java` - handles student enrollments in courses
- `src/util/FileUtil.java` - provides file handling utilities
- `src/Main.java` - entry point of the application

## Data Files
- `students.txt` - stores student information
- `courses.txt` - stores course information
- `enrollments.txt` - stores enrollment data

## Concepts Implemented
- Classes and objects
- Encapsulation
- Object relationships
- Lists for storing students and courses
- Basic CRUD (Create, Read, Update, Delete) operations
- File Handling
