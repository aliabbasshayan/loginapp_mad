package com.szabist.smartportal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView btnProfileBack;
    private TextView tvProfileNameHeader, tvDetailName, tvDetailId, tvDetailEmail, tvDetailInstitution, tvDetailProgram, tvDetailSemester;
    private Button btnProfileLogout;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userSession = new UserSession(this);

        btnProfileBack = findViewById(R.id.btnProfileBack);
        tvProfileNameHeader = findViewById(R.id.tvProfileNameHeader);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailId = findViewById(R.id.tvDetailId);
        tvDetailEmail = findViewById(R.id.tvDetailEmail);
        tvDetailInstitution = findViewById(R.id.tvDetailInstitution);
        tvDetailProgram = findViewById(R.id.tvDetailProgram);
        tvDetailSemester = findViewById(R.id.tvDetailSemester);
        btnProfileLogout = findViewById(R.id.btnProfileLogout);

        // Populate student profile fields
        tvProfileNameHeader.setText(userSession.getUserName());
        tvDetailName.setText(userSession.getUserName());
        tvDetailId.setText(userSession.getStudentId());
        tvDetailEmail.setText(userSession.getUserEmail());
        tvDetailInstitution.setText(UserSession.DEFAULT_INSTITUTION);
        tvDetailProgram.setText(UserSession.DEFAULT_PROGRAM);
        tvDetailSemester.setText(UserSession.DEFAULT_SEMESTER);

        btnProfileBack.setOnClickListener(v -> finish());

        btnProfileLogout.setOnClickListener(v -> {
            userSession.logout();
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
