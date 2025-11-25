# 🗳️ Java Voting System – Review 1 Submission  
### **By:**  
- **Mohd Arsh (24scse1180015)**  
- **Shivam Gupta (24scse1180615)**  

---

## 📌 **Project Overview**
This is a **Java-based Voting System** built as part of **Review-1** for the Java GUI/Web-based project evaluation.  
The project demonstrates strong understanding and implementation of:

- Core Java  
- OOP Concepts  
- JDBC & MySQL  
- DAO Architecture  
- Collections & Generics  
- Multithreading & Synchronization  

This version is a **Console-Based Prototype**, fully aligned with Review-1 requirements.

---

## 📂 **Project Structure (src folder)**

src/
└─ com.votingsystem.model
├─ User.java
├─ Candidate.java
├─ Vote.java
└─ Admin.java (Inheritance)
└─ com.votingsystem.dao
├─ UserDAO.java
├─ CandidateDAO.java
├─ VoteDAO.java
├─ DAOException.java
└─ com.votingsystem.dao.impl
├─ UserDAOImpl.java
├─ CandidateDAOImpl.java
├─ VoteDAOImpl.java
└─ com.votingsystem.service
├─ Notifier.java (Interface)
├─ ConsoleNotifier.java
├─ EmailNotifier.java
└─ VotingService.java (synchronized method)
└─ com.votingsystem.ui
├─ App.java (Main runner)
├─ DBTest.java (Test DB connection)
└─ ThreadDemo.java (Multithreading test)
└─ com.votingsystem.util
└─ DBConnection.java

sql
Copy code

---

## 🛢️ **Database Schema**

### **Database:** `voting_db`

#### **Users Table**
| Column | Type | Description |
|-------|------|-------------|
| user_id | INT (PK, AI) | Unique user |
| username | VARCHAR(50) | Unique |
| password_hash | VARCHAR(255) | Password |
| role | ENUM('ADMIN', 'VOTER') | Role |

#### **Candidates Table**
| Column | Type |
|--------|------|
| candidate_id | INT (PK, AI) |
| name | VARCHAR(100) |
| party | VARCHAR(100) |
| description | VARCHAR(255) |

#### **Votes Table**
| Column | Type | Notes |
|--------|------|--------|
| vote_id | INT (PK, AI) |
| voter_id | INT | FK → users(user_id), **UNIQUE** |
| candidate_id | INT | FK → candidates(candidate_id) |
| vote_time | TIMESTAMP | Auto timestamp |

---

## 🔗 **JDBC Connection**
Used **MySQL Connector/J (mysql-connector-j-9.x.x)**.  
DBConnection class provides centralized connection handling:

```java
Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
⚙️ DAO Architecture
Fully implemented DAO Pattern:

UserDAO, CandidateDAO, VoteDAO

Implemented by UserDAOImpl, CandidateDAOImpl, VoteDAOImpl

All database operations are modular and reusable

🧠 OOP Concepts Implemented
✔ Inheritance
Admin extends User.

✔ Polymorphism
Notifier → implemented by ConsoleNotifier and EmailNotifier.

✔ Encapsulation
Private fields with getters/setters in all model classes.

✔ Interfaces
DAO interfaces + Notifier interface.

✔ Exception Handling
Custom DAOException for wrapping SQLExceptions.

📚 Collections & Generics
Used:

java
Copy code
List<Candidate>
Map<Candidate, Integer>
Map used for result counting → demonstrates Generics & advanced collection usage.

🧵 Multithreading & Synchronization
The VotingService contains:

java
Copy code
public synchronized boolean castVote(...)
This ensures thread-safe voting, preventing double votes when multiple threads run.

ThreadDemo.java demonstrates concurrency:

Thread-1 → vote inserted

Thread-2 → blocked (voter already voted)

📸 Screenshots Included in PPT
DB connection test

Candidate list output

SHOW TABLES

Results map

Multithreading (ThreadDemo) output

🔗 GitHub Repository
👉 https://github.com/mohdarsh-3/java-voting-system

📝 How to Run
1. Import project into Eclipse
2. Ensure MySQL server is running
3. Create database:
sql
Copy code
SOURCE voting_db.sql;
4. Run:
DBTest.java

App.java

ThreadDemo.java

