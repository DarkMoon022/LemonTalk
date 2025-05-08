package com.example.lemontalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserSelectActivity extends AppCompatActivity {

    private LinearLayout userListLayout;
    private Button newUserButton;
    private static final int REQUEST_CODE_REGISTER_USER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        // Inicializar vistas
        userListLayout = findViewById(R.id.userListLayout);
        newUserButton = findViewById(R.id.newUserButton);

        // Llamar a RegisterUserActivity al hacer clic en el botón
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserSelectActivity.this, RegisterUserActivity.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTER_USER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Verificar si la respuesta proviene de RegisterUserActivity
        if (requestCode == REQUEST_CODE_REGISTER_USER && resultCode == RESULT_OK) {
            String newUserName = data.getStringExtra("newUserName");
            if (newUserName != null && !newUserName.isEmpty()) {
                addUserToList(newUserName); // Agregar el nuevo usuario a la lista
            } else {
                // Mostrar un mensaje si el nombre es vacío o no válido
                Toast.makeText(UserSelectActivity.this, "El nombre del usuario no puede estar vacío", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Método para agregar un nuevo usuario a la lista
    private void addUserToList(String userName) {
        // Crear un nuevo layout para el item del usuario
        LinearLayout userItemLayout = new LinearLayout(this);
        userItemLayout.setOrientation(LinearLayout.HORIZONTAL);
        userItemLayout.setPadding(16, 16, 16, 16); // Añadir un poco de espacio entre los elementos

        // Crear un botón para el nombre de usuario
        Button userButton = new Button(this);
        userButton.setText(userName);
        userButton.setTextColor(getResources().getColor(android.R.color.white)); // Color del texto
        userButton.setBackgroundColor(getResources().getColor(R.color.userBackgroundColor)); // Color de fondo
        userButton.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        userButton.setPadding(16, 16, 16, 16); // Añadir espacio al botón

        // Crear un TextView para el nivel del usuario
        TextView userLevelText = new TextView(this);
        userLevelText.setText("Nivel 1");
        userLevelText.setTextColor(getResources().getColor(android.R.color.holo_green_dark)); // Color del texto

        // Agregar el botón y el texto del nivel al layout horizontal
        userItemLayout.addView(userButton);
        userItemLayout.addView(userLevelText);

        // Agregar el layout del item al layout principal
        userListLayout.addView(userItemLayout);
    }
}
