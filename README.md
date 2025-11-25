# Java Voting System (Review 1)

This project is a simple voting system built in Java using JDBC and MySQL.  
The goal of Review 1 is to set up the core project structure, demonstrate OOP concepts, and establish database connectivity.

---

## 🚀 Technologies Used

- Java
- JDBC
- MySQL
- Eclipse IDE

---

## 📁 Project Structure

src
└─ com.votingsystem.model → User, Candidate, Vote (OOP Models)
└─ com.votingsystem.dao → DAO Interfaces
└─ com.votingsystem.dao.impl → DAO Implementations using JDBC
└─ com.votingsystem.util → DBConnection class
└─ com.votingsystem.ui → DBTest + App (test runner)


---

## 🗄 Database Design

**Database name:** `voting_db`

Tables: `users`, `candidates`, `votes`

SQL script used:

```sql
CREATE DATABASE voting_db;
USE voting_db;
