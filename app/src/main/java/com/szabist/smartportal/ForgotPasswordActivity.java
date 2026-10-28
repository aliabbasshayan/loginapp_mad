package com.szabist.smartportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextInputLayout tilForgotEmail;
    private TextInputEditText etForgotEmail;
    private Button btnSendRecovery;
    private TextView tvBackToLogin;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        userSession = new UserSession(this);

        tilForgotEmail = findViewById(R.id.tilForgotEmail);
        etForgotEmail = findViewById(R.id.etForgotEmail);
        btnSendRecovery = findViewById(R.id.btnSendRecovery);
        tvBackToLogin = findViewById(R.id.tvBackToLogin);

        // Pre-fill email for testing
        etForgotEmail.setText(userSession.getUserEmail());

        btnSendRecovery.setOnClickListener(v -> handleRecoveryRequest());

        tvBackToLogin.setOnClickListener(v -> finish());
    }

    private void handleRecoveryRequest() {
        tilForgotEmail.setError(null);

        String email = etForgotEmail.getText() != null ? etForgotEmail.getText().toString().trim() : "";

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilForgotEmail.setError(getString(R.string.invalid_email));
            return;
        }

        if (!userSession.isRegisteredEmail(email)) {
            tilForgotEmail.setError(getString(R.string.user_not_found));
            return;
        }

        Toast.makeText(this, R.string.recovery_sent, Toast.LENGTH_SHORT).show();

        // Navigate via Explicit Intent to Reset Password Activity with Intent Extra
        Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
        intent.putExtra("user_email", email);
        startActivity(intent);
        finish();
    }
}
