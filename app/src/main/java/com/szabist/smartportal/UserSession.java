package com.szabist.smartportal;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession {
    private static final String PREF_NAME = "SmartPortalPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_USER_PASS = "userPassword";
    private static final String KEY_STUDENT_ID = "studentId";

    // Default hardcoded credentials for student Shayan Ali Abbas
    public static final String DEFAULT_NAME = "Shayan Ali Abbas";
    public static final String DEFAULT_EMAIL = "24108231@szabist.com";
    public static final String DEFAULT_PASS = "24108231";
    public static final String DEFAULT_ID = "24108231";
    public static final String DEFAULT_INSTITUTION = "SZABIST Islamabad";
    public static final String DEFAULT_PROGRAM = "BS Artificial Intelligence";
    public static final String DEFAULT_SEMESTER = "5th Semester";

    private final SharedPreferences prefs;

    public UserSession(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        // Initialize default user if not already set
        if (!prefs.contains(KEY_USER_EMAIL)) {
            registerUser(DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_PASS, DEFAULT_ID);
        }
    }

    public void registerUser(String name, String email, String password, String studentId) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_USER_NAME, name);
        editor.putString(KEY_USER_EMAIL, email.trim().toLowerCase());
        editor.putString(KEY_USER_PASS, password);
        editor.putString(KEY_STUDENT_ID, studentId);
        editor.apply();
    }

    public boolean validateCredentials(String emailOrId, String password) {
        String savedEmail = prefs.getString(KEY_USER_EMAIL, DEFAULT_EMAIL);
        String savedPass = prefs.getString(KEY_USER_PASS, DEFAULT_PASS);
        String savedId = prefs.getString(KEY_STUDENT_ID, DEFAULT_ID);

        String input = emailOrId.trim().toLowerCase();
        boolean isUsernameOrEmailMatch = input.equals(savedEmail) || input.equals(savedId.toLowerCase());
        return isUsernameOrEmailMatch && password.equals(savedPass);
    }

    public boolean isRegisteredEmail(String email) {
        String savedEmail = prefs.getString(KEY_USER_EMAIL, DEFAULT_EMAIL);
        return email.trim().equalsIgnoreCase(savedEmail);
    }

    public void updatePassword(String newPassword) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_USER_PASS, newPassword);
        editor.apply();
    }

    public void setLoggedIn(boolean isLoggedIn) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public String getUserName() {
        return prefs.getString(KEY_USER_NAME, DEFAULT_NAME);
    }

    public String getUserEmail() {
        return prefs.getString(KEY_USER_EMAIL, DEFAULT_EMAIL);
    }

    public String getStudentId() {
        return prefs.getString(KEY_STUDENT_ID, DEFAULT_ID);
    }

    public void logout() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, false);
        editor.apply();
    }
}
