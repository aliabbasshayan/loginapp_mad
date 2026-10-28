# SmartPortal - Android Application (Assignment 2)

**Course**: Android Application Development (Java + XML)  
**Student Name**: Shayan Ali Abbas  
**Student ID / Roll No**: 24108231  
**Email**: 24108231@szabist.com  
**Institution**: SZABIST Islamabad  
**Program**: BS Artificial Intelligence (5th Semester)  

---

## 📱 Project Overview

**SmartPortal** is a native Android application built using **Java** and **XML**. It serves as a student portal for SZABIST Islamabad, providing authentication workflows, password recovery, academic module dashboard, and student profile details.

---

## ✨ Features & Screen Flow

1. **Splash Screen (`SplashActivity`)**:
   - Displays the official SmartPortal logo and tagline.
   - Built using **ConstraintLayout**.
   - Automatically navigates to the Login screen via an Explicit Intent after 2 seconds (or directly to Dashboard if already logged in).

2. **Login Screen (`LoginActivity`)**:
   - Accepts Email / Student ID and Password inputs using `TextInputLayout` controls.
   - Implements input validation (empty field check & format validation).
   - Validates user credentials locally (Default: `24108231@szabist.com` / `24108231`).
   - Built using **ConstraintLayout**.
   - Links to Register and Forgot Password screens.

3. **Register Screen (`RegisterActivity`)**:
   - Fields: Full Name, Email, Password, and Confirm Password.
   - Input validation: Email regex match, minimum password length (6+ chars), password matching check.
   - Saves new user registrations to local `SharedPreferences` (`UserSession`).
   - Built using **LinearLayout** inside a `ScrollView`.

4. **Forgot Password Screen (`ForgotPasswordActivity`)**:
   - Accepts registered email and initiates a simulated password recovery request.
   - Validates email format and existence.
   - Navigates to Reset Password screen via an Explicit Intent with Intent Extras.
   - Built using **ConstraintLayout**.

5. **Reset Password Screen (`ResetPasswordActivity`)**:
   - Accepts New Password and Confirm Password inputs.
   - Validates match and length requirements.
   - Updates user password and redirects back to Login screen.
   - Built using **LinearLayout**.

6. **Dashboard Screen (`DashboardActivity`)**:
   - Features a 2x2 grid displaying 4 main academic modules:
     1. **Profile & ID** -> Navigates to Student Profile
     2. **My Courses** -> Displays registered BS AI 5th Semester subjects
     3. **Attendance & Marks** -> Displays attendance summary and status
     4. **Settings & Info** -> Displays application & developer metadata
   - Demonstrates **GridLayout** with Material Cards (`MaterialCardView`).
   - Header displays personalized welcome greeting (`Hello, Shayan Ali Abbas!`).

7. **Profile Screen (`ProfileActivity`)**:
   - Displays full student details:
     - **Name**: Shayan Ali Abbas
     - **ID**: 24108231
     - **Email**: 24108231@szabist.com
     - **Institution**: SZABIST Islamabad
     - **Program**: BS Artificial Intelligence
     - **Semester**: 5th Semester
   - Includes a **Logout** button that clears session flags and navigates back to Login screen.
   - Built using **ConstraintLayout** and `MaterialCardView`.

---

## 🛠️ Mandatory Technical Requirements Met

| Requirement | Implementation Detail |
| :--- | :--- |
| **Language & Layouts** | Java + XML |
| **ConstraintLayout** | Demonstrated in `SplashActivity`, `LoginActivity`, `ForgotPasswordActivity`, `ProfileActivity` |
| **LinearLayout** | Demonstrated in `RegisterActivity`, `ResetPasswordActivity`, `CoursesActivity`, `AttendanceActivity`, `SettingsActivity` |
| **GridLayout** | Demonstrated in `DashboardActivity` (2x2 Module Grid) |
| **Android Resources** | String resources (`strings.xml`), Default colors (`res/values/colors.xml`), and Night-mode colors (`res/values-night/colors.xml`) |
| **Input Controls** | `TextInputLayout`, `TextInputEditText`, `Button`, `TextView`, `ImageView`, `MaterialCardView` |
| **Input Validation** | Empty checks, Regex Email validation, Password length check, and Password match validation with `setError()` |
| **Explicit Intents** | Used across all activities for explicit activity-to-activity navigation |
| **Simulated Auth** | `UserSession` helper class managing session state and credentials via `SharedPreferences` |

---

## 🛠️ How to Build and Run

1. Open **Android Studio** (2023.x / 2024.x / 2026.x).
2. Select **Open** and select the project directory `android-login-app`.
3. Allow Gradle to sync.
4. Connect an Android Device or start an Emulator.
5. Click **Run 'app'** or execute `./gradlew assembleDebug` in terminal.

---

## 🔑 Test Login Credentials

- **Email**: `24108231@szabist.com`
- **Password**: `24108231`
*(Or register a new account on the Registration screen!)*
