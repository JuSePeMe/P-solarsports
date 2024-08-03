package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse_layout);

        ImageView img_back = findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}



//        EditText etEmail = findViewById(R.id.etEmail);
//        EditText etPassword = findViewById(R.id.etPassword);
//        Button btnRegister = findViewById(R.id.btnRegister);
//
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Obtener los valores ingresados por el usuario
//                String email = etEmail.getText().toString();
//                String password = etPassword.getText().toString();
//
//                // Aquí puedes agregar la lógica para manejar el registro, como validar los campos
//                if (email.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(RegistrarseActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Lógica de registro aquí
//                    Toast.makeText(RegistrarseActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
//                    // Finalizar la actividad o navegar a otra actividad
//                    finish();
//                }
//            }
//        });

