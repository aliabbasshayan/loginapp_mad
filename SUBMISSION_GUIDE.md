# Assignment 2 Submission & Screenshot Checklist

**Student**: Shayan Ali Abbas (24108231)  
**Program**: BS AI (Semester 5) - SZABIST Islamabad  

---

## 1. Submission Document Content Checklist

When preparing your Word/PDF submission document, include the following sections:

### Section A: Project Details
- **App Name**: SmartPortal
- **Developer Name**: Shayan Ali Abbas
- **Student ID**: 24108231
- **Email**: 24108231@szabist.com
- **Repository Link**: `[Insert Your GitHub Repository URL Here]`

---

### Section B: Screenshots of Code
Take screenshots of the following key source code files in Android Studio:
1. **`AndroidManifest.xml`** (Showing activity declarations and launcher intent filter)
2. **`LoginActivity.java`** (Showing explicit intent and input validation logic)
3. **`DashboardActivity.java`** (Showing grid module handlers)
4. **`UserSession.java`** (Showing simulated authentication and credentials)
5. **`activity_login.xml`** (Showing ConstraintLayout layout)
6. **`activity_dashboard.xml`** (Showing GridLayout declaration)
7. **`activity_register.xml`** (Showing LinearLayout declaration)
8. **`strings.xml`** & **`values-night/colors.xml`** (Showing alternative Android resources)

---

### Section C: Screenshots of Application Output Screens
Run the app on an emulator or physical phone and take screenshots of:
1. **Splash Screen**
2. **Login Screen** (Normal & with validation errors)
3. **Registration Screen** (Filled out & validation errors)
4. **Forgot Password Screen**
5. **Reset Password Screen**
6. **Dashboard Screen** (2x2 Grid of modules)
7. **Student Profile Screen** (Displaying Shayan Ali Abbas, 24108231, SZABIST)
8. **Courses Screen** (BS AI Semester 5 Subjects)
9. **Dark / Night Mode Screenshot** (Demonstrating `values-night` colors)

---

### Section D: Screenshot of GitHub Repository
Take a screenshot showing:
1. Your repository on github.com.
2. All committed files (`app/`, `build.gradle`, `README.md`).

---

## 2. Steps to Push Code to GitHub

Open Terminal or Command Prompt in the project folder (`android-login-app`) and run:

```bash
git init
git add .
git commit -m "Complete Assignment 2: SmartPortal Android App (Java + XML)"
git branch -M main
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/android-login-app.git
git push -u origin main
```
*(Replace `YOUR_GITHUB_USERNAME` with your actual GitHub username).*
