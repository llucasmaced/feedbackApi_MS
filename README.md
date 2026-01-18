# 📝 Feedback Microservice API

A simple microservice API responsible for handling feedback on posts.  
Users can submit a **rating (score)** and a **comment** associated with a specific post.

## 🚀 Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- SQLite3
- Maven

## 📌 Features

- Submit feedback for a specific post
- Store rating and comment
- Persist data using SQLite
- RESTful API architecture
- Lightweight microservice design

## 📂 Project Structure

```text
📁 feedback-microservice
 ┣ 📁 src
 ┃ ┣ 📁 main
 ┃ ┃ ┣ 📁 java
 ┃ ┃ ┃ ┗ 📁 com.llmcd.feedback
 ┃ ┃ ┃   ┣ 📁 controller
 ┃ ┃ ┃   ┣ 📁 service
 ┃ ┃ ┃   ┣ 📁 repository
 ┃ ┃ ┃   ┗ 📁 model
 ┃ ┃ ┗ 📁 resources
 ┃ ┃   ┗ 📁 db
 ┃ ┃      ┗ 📁 migration
 ┃ ┃   ┗ 📄 application.properties
 ┣ 📄 pom.xml
 ┣ 📄 README.md
