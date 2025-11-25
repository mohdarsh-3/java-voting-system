Java Voting System – Review 1 Submission
By:

Mohd Arsh (24scse1180015)
Shivam Gupta (24scse1180615)

🚀 Project Overview

This is a Java-based Voting System implemented using
✔ Core Java
✔ OOP Principles
✔ DAO Layer Architecture
✔ JDBC
✔ MySQL Database
✔ Multithreading + Synchronization

This project fulfills all Review-1 requirements under Java GUI/Web-based project criteria.

🏗 Project Architecture
src/
 └─ com.votingsystem.model        → User, Candidate, Vote
 └─ com.votingsystem.dao          → DAO Interfaces (UserDAO, CandidateDAO, VoteDAO)
 └─ com.votingsystem.dao.impl     → JDBC DAO Implementations
 └─ com.votingsystem.util         → DBConnection (MySQL Connector)
 └─ com.votingsystem.service      → VotingService (business logic + synchronized voting)
 └─ com.votingsystem.ui           → DBTest, App, ThreadDemo (console UI/testing)

🗄 Database Schema (MySQL)
Tables:

users

candidates

votes

Schema Script:
CREATE DATABASE voting_db;
USE voting_db;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'VOTER') NOT NULL
);

CREATE TABLE candidates (
    candidate_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    party VARCHAR(100),
    description VARCHAR(255)
);

CREATE TABLE votes (
    vote_id INT PRIMARY KEY AUTO_INCREMENT,
    voter_id INT NOT NULL,
    candidate_id INT NOT NULL,
    vote_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (voter_id),
    FOREIGN KEY (voter_id) REFERENCES users(user_id),
    FOREIGN KEY (candidate_id) REFERENCES candidates(candidate_id)
);

INSERT INTO users (username, password_hash, role)
VALUES ('admin', 'admin', 'ADMIN'),
       ('arsh', '1234', 'VOTER');

INSERT INTO candidates (name, party, description)
VALUES ('Candidate A', 'Party X', 'For development'),
       ('Candidate B', 'Party Y', 'For education');

✔ Review-1 Rubric Mapping (All Requirements Covered)
1️⃣ OOP Implementation – ✓

Inheritance → Admin extends User

Polymorphism → Notifier, ConsoleNotifier, EmailNotifier

Interfaces → DAO interfaces + Notifier

Encapsulation → All model classes

Abstraction → DAO structure

Exception Handling → DAOException

2️⃣ Collections & Generics – ✓

List<Candidate>

List<User>

Map<Candidate, Integer> for vote counting

3️⃣ Multithreading & Synchronization – ✓

ThreadDemo.java

Multiple threads trying to vote simultaneously

synchronized castVote() in VotingService

Ensures no race conditions

Output (Proof):

[NOTIFY] Vote recorded for voter 2 -> candidate 1
Thread-1 -> true
[NOTIFY] Voter 2 already voted.
Thread-2 -> false
Thread test finished.

4️⃣ JDBC Connectivity – ✓

DBConnection class

MySQL Connector JAR

PreparedStatements

Secure parameterized queries

5️⃣ DAO Classes for Database Operations – ✓

CandidateDAO + Impl

UserDAO + Impl

VoteDAO + Impl

All CRUD operations implemented using JDBC.

🧪 Console Output (Screenshots in PPT)
✔ DB Connection Test

Shows:

Connection Successful: true

✔ Candidate List

Displays all candidates from DB

✔ SHOW TABLES

Proof of schema creation

✔ Multithreading Output

Demonstrates synchronization working perfectly

📌 GitHub Repository

https://github.com/mohdarsh-3/java-voting-system

🛠 How to Run
Prerequisites

JDK 17+

Eclipse/VSCode/IntelliJ

MySQL 8+

MySQL Connector JAR

Steps

Import project in Eclipse

Add MySQL Connector JAR inside /lib

Update DB credentials in DBConnection.java

Run MySQL script

Run:

DBTest.java

App.java

ThreadDemo.java

📞 Contact

For any queries:
Mohd Arsh – 24scse1180015
Shivam Gupta – 24scse1180615