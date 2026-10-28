package com.szabist.smartportal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcomeUser, tvStudentId;
    private ImageView btnHeaderProfile;
    private MaterialCardView cardProfile, cardCourses, cardAttendance, cardSettings, cardLogoutQuick;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        userSession = new UserSession(this);

        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        tvStudentId = findViewById(R.id.tvStudentId);
        btnHeaderProfile = findViewById(R.id.btnHeaderProfile);

        cardProfile = findViewById(R.id.cardProfile);
        cardCourses = findViewById(R.id.cardCourses);
        cardAttendance = findViewById(R.id.cardAttendance);
        cardSettings = findViewById(R.id.cardSettings);
        cardLogoutQuick = findViewById(R.id.cardLogoutQuick);

        // Display user details
        tvWelcomeUser.setText(getString(R.string.greeting_user, userSession.getUserName()));
        tvStudentId.setText("ID: " + userSession.getStudentId() + " | BS AI");

        // Module 1: Profile
        cardProfile.setOnClickListener(v -> openProfileScreen());
        btnHeaderProfile.setOnClickListener(v -> openProfileScreen());

        // Module 2: Courses
        cardCourses.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, CoursesActivity.class);
            startActivity(intent);
        });

        // Module 3: Attendance
        cardAttendance.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, AttendanceActivity.class);
            startActivity(intent);
        });

        // Module 4: Settings
        cardSettings.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // Logout
        cardLogoutQuick.setOnClickListener(v -> performLogout());
    }

    private void openProfileScreen() {
        Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void performLogout() {
        userSession.logout();
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
