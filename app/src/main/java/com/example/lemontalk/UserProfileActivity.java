package com.example.lemontalk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UserProfileActivity extends Activity {

    private TextView profileUserName;
    private TextView profileEmail;
    private TextView profileLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileUserName = findViewById(R.id.profileUserName);
        profileEmail = findViewById(R.id.profileEmail);
        profileLanguage = findViewById(R.id.profileLanguage);

        // Recuperar datos del Intent
        String userName = getIntent().getStringExtra("userName");
        String email = getIntent().getStringExtra("email");
        String language = getIntent().getStringExtra("selectedLanguage");

        // Verificar que los datos no sean nulos antes de asignarlos
        profileUserName.setText("Nombre: " + (userName != null ? userName : "No disponible"));
        profileEmail.setText("Correo: " + (email != null ? email : "No disponible"));
        profileLanguage.setText("Idioma: " + (language != null ? language : "No disponible"));
    }
}
