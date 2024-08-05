package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrarseActivity extends AppCompatActivity {

    Button botonRegistrarse; // boton de registro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse_layout);
        //accion boton registrarse

        botonRegistrarse = findViewById(R.id.button);
        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarse();
            }
            });

        //navegar al inicio de sesion
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registrarse(){
        //verificacion de campos

        //verificacion correo
        TextInputLayout tilCorreoRegistro = findViewById(R.id.tilCorreoRegistro);
        EditText edCorreoRegistro = findViewById(R.id.ed_correo_registro);

        TextInputLayout tilPassRegistro = findViewById(R.id.tilPassRegistro);
        EditText edPassRegistro = findViewById(R.id.ed_pass_registro);

// ... dentro de un listener (ej. un botón o un TextWatcher)
        String correo = edCorreoRegistro.getText().toString();
        String contrasenia = edPassRegistro.getText().toString();

        if (!isValidEmail(correo)) {
            tilCorreoRegistro.setError("Ingrese un correo válido");
        }


         else {
            tilCorreoRegistro.setError(null);
            // ... continuarcon el proceso
        }

        //validacion contrasenia campo uno

        edPassRegistro.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                String password = s.toString();
                validatePassword(tilPassRegistro, password);
            }
        });




    }
    private void validatePassword(TextInputLayout tilPassRegistro, String password) {
        if (password.length() < 8) {
             tilPassRegistro.setError("La contraseña debe tener al menos 8 caracteres.");
        } else if (!password.matches(".*[A-Z].*")) {
             tilPassRegistro.setError("La contraseña debe contener al menos una letra mayúscula.");
        } else if (!password.matches(".*[a-z].*")) {
             tilPassRegistro.setError("La contraseña debe contener al menos una letra minúscula.");
        } else if (!password.matches(".*\\d.*")) {
             tilPassRegistro.setError("La contraseña debe contener al menos un número.");
        } else if (!password.matches(".*[!@#\\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
             tilPassRegistro.setError("La contraseña debe contener al menos un carácter especial.");
        } else {
             tilPassRegistro.setError(null); // No hay errores
        }
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
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

