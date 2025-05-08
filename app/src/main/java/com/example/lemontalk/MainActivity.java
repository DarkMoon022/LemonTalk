package com.example.lemontalk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends Activity {

    private static final int SPLASH_DURATION = 2000; // 2 segundos
    private UserDatabaseHelper dbHelper;  // Instancia de la base de datos
    private LinearLayout userListLayout; // Layout donde se pondrán los botones

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la base de datos
        dbHelper = new UserDatabaseHelper(this);

        // Obtener el LinearLayout del XML
        userListLayout = findViewById(R.id.userListLayout);

        // Verificar que userListLayout no sea nulo
        if (userListLayout == null) {
            Log.e("MainActivity", "Error: userListLayout no encontrado en el XML. Verifica activity_main.xml");
            return; // Salir de la función si no se encuentra el layout
        }

        // Agregar un usuario de ejemplo
        User newUser = new User("John Doe", "john@example.com", "password123", "English");
        dbHelper.addUser(newUser);

        // Recuperar los usuarios de la base de datos y mostrarlos
        List<User> userList = dbHelper.getAllUsers();
        for (User user : userList) {
            Button userButton = new Button(this);
            userButton.setText(user.getUserName());
            userButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                intent.putExtra("userName", user.getUserName());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("selectedLanguage", user.getSelectedLanguage());
                startActivity(intent);
            });

            userListLayout.addView(userButton); // Se asegura que userListLayout no es nulo antes de usarlo
        }

        // Esperar unos segundos y luego iniciar la siguiente actividad
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, UserSelectActivity.class);
            startActivity(intent);
            finish(); // Esto cierra MainActivity
        }, SPLASH_DURATION);
    }
}
