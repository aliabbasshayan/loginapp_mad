package com.szabist.smartportal;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ImageView btnBack = findViewById(R.id.btnCoursesBack);
        btnBack.setOnClickListener(v -> finish());
    }
}
