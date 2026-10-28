package com.szabist.smartportal;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class AttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        ImageView btnBack = findViewById(R.id.btnAttendanceBack);
        btnBack.setOnClickListener(v -> finish());
    }
}
