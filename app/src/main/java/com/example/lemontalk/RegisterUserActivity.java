package com.example.lemontalk;

import android.app.Activity;
import android.os.Bundle;

public class RegisterUserActivity extends Activity {

    private UserDatabaseHelper dbHelper;  // Base de datos SQLite

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        dbHelper = new UserDatabaseHelper(this);  // Inicializar la base de datos SQLite

        // Ahora puedes usar dbHelper para agregar, obtener, actualizar, o eliminar usuarios.
    }
}
