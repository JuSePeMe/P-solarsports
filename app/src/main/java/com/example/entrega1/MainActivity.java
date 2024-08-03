package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aplicar Edge-to-Edge

        // Validación de correo
        TextInputLayout tilEmail = findViewById(R.id.tilEmail);
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        Button button = findViewById(R.id.ini_sesion);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String email = editTextNombre.getText().toString();
                    if (!isValidEmail(email)) {
                        tilEmail.setError("Ingrese un correo válido");
                    } else {
                        tilEmail.setError(null);
                    }
                }
            });
        }

        // Navegación al layout de registrarse
        Button registerButton = findViewById(R.id.bt_registrar);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Navegar a la actividad de registrarse
                Intent intent = new Intent(MainActivity.this, RegistrarseActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}