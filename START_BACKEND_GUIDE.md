# 🚀 START BACKEND SERVER - Step by Step Guide

## ⚠️ IMPORTANT: You're getting "Error connecting to server" because the backend is not running!

---

## ✅ SOLUTION: Start Backend from IntelliJ IDEA

### **Option 1: Run Main Class (EASIEST)**

1. **Open IntelliJ IDEA**
2. **Navigate to this file:**
   ```
   src/main/java/com/campus/ecommerce/CampusEcommerceWebApplication.java
   ```
3. **Right-click on the file** in the editor
4. **Select:** `Run 'CampusEcommerceWebApplication.main()'`
5. **Wait** for the console to show:
   ```
   Started CampusEcommerceWebApplication in X.XXX seconds
   ```
6. **You should see:** `Tomcat started on port(s): 8080`

### **Option 2: Use Green Play Button**

1. **Open** `CampusEcommerceWebApplication.java`
2. **Look for** the green ▶️ play button next to `public class CampusEcommerceWebApplication`
3. **Click** the green play button
4. **Select:** `Run 'CampusEcommerceWebApplication'`

### **Option 3: Use Maven Panel**

1. **Open IntelliJ IDEA**
2. **Click** the "Maven" tab on the right side
3. **Expand:** `CampusEcommerceWeb` → `Plugins` → `spring-boot`
4. **Double-click:** `spring-boot:run`
5. **Wait** for server to start

---

## 🔍 How to Know Backend is Running?

You'll see this in IntelliJ console:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::

...
Started CampusEcommerceWebApplication in 5.123 seconds
Tomcat started on port(s): 8080 (http)
```

---

## ✅ After Backend Starts

### **Test if backend is working:**

Open these URLs in browser:
- http://localhost:8080/products (should show `[]` or list of products)
- http://localhost:8080/users (should show `[]` or list of users)

### **Then use your website:**
- http://localhost:3000/index.html (Frontend - already running)
- http://localhost:3000/register.html (Now registration will work!)

---

## ❌ Troubleshooting

### **Problem: "Port 8080 already in use"**
**Solution:**
- Stop any other application using port 8080
- Or add this to `application.properties`:
  ```
  server.port=8081
  ```
  Then update frontend URLs in HTML files to use 8081

### **Problem: "Cannot connect to database"**
**Solution:**
1. Make sure MySQL is running
2. Check if database `campus_ecommerce` exists:
   ```sql
   CREATE DATABASE IF NOT EXISTS campus_ecommerce;
   ```
3. Verify credentials in `application.properties`:
   - Username: Kaviya
   - Password: kaviya5569

### **Problem: "Maven dependencies not found"**
**Solution:**
1. In IntelliJ, click **Maven** tab (right side)
2. Click **Reload** button (circular arrows icon)
3. Wait for dependencies to download

### **Problem: "Class not found"**
**Solution:**
1. **File** → **Invalidate Caches** → **Restart**
2. After restart, rebuild project: **Build** → **Rebuild Project**

---

## 📊 Current Setup

- ✅ **Frontend Server:** Running on http://localhost:3000
- ❌ **Backend Server:** NOT RUNNING (you need to start it!)
- 📁 **Database:** MySQL (localhost:3306/campus_ecommerce)

---

## 🎯 Quick Checklist

- [ ] IntelliJ IDEA is open
- [ ] Project is loaded
- [ ] MySQL is running
- [ ] Database 'campus_ecommerce' exists
- [ ] Run CampusEcommerceWebApplication.java
- [ ] See "Started" message in console
- [ ] Test http://localhost:8080/products
- [ ] Try registration again!

---

**Once you start the backend, your registration will work! 🎉**

