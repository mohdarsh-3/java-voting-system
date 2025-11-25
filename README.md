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

---

## 🗄 Database Design

**Database name:** `voting_db`

Tables: `users`, `candidates`, `votes`

---

## 🔧 How to Run

1. Install MySQL and create database `voting_db`
2. Add MySQL JDBC Driver to Eclipse (`mysql-connector-j-x.x.jar`)
3. Update DB credentials in `DBConnection.java`
4. Run `DBTest.java` to verify connection
5. Run `App.java` to print all candidates from database

---

## ✔ Features Completed in Review 1

- Project structure with packages
- Java OOP model classes (User, Candidate, Vote)
- JDBC connection to MySQL via `DBConnection.java`
- DAO interfaces + JDBC implementation
- Console output showing live data from database

---

## ⏭ Planned in Review 2

- Full GUI using Swing
- Login system (Admin/Voter)
- Voting logic (only one vote allowed)
- Display election results in UI
- Password hashing & validation

---

## 🔗 GitHub Link

https://github.com/mohdarsh-3/java-voting-system

