# 📚 Quiz Application

Welcome to the **Quiz Application**, a full-stack web-based quiz platform where users can register, take quizzes, and administrators can manage questions seamlessly.

## 🚀 Features
- **User Registration & Login**
- **Role-Based Access (Admin & Users)**
- **Quiz Management** (Add/Edit/Delete Questions)
- **CSV Upload for Bulk Questions**
- **H2 Database (Local) / MySQL (For Production)**
- **Webcam Capture for Monitoring**
- **Responsive UI with Bootstrap**

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot
- **Frontend:** HTML, Bootstrap, JavaScript
- **Database:** H2 (Dev) / MySQL (Production)
- 
## 📦 Setup Instructions
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Hritik-Raj-13/QuizApplication
cd quiz-application
```

### 2️⃣ Configure Database
#### 🛠 Using H2 (Default for Development)
No setup required. H2 is in-memory.
Password is "password"

#### 🛠 Using MySQL (For Production)
Update `application.properties`

### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```
Application runs on: **`http://localhost:8082/`**

### 4️⃣ Accessing the Admin Panel
By default, admin panel is available at:
```
http://localhost:8082/admin
```
Alternatively, use the **Admin Panel Button** on the main page.

## 🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## 📜 License
MIT License © 2024 Hritik Raj

---
_Enjoy Building! 🎯_

