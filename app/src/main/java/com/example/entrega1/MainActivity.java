package com.example.entrega1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.entrega1.model.Usuario;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Usuario user;
    TextInputLayout tilEmail;
    EditText    edcorreo;
    EditText    password;
    Button      botonLogin;
    Button      botonRegister;
    TextView tvRecuperacontra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent registroIntent = new Intent(this, RegistrarseActivity.class);
        Intent principalIntent = new Intent(this, Principal.class);


        //leer los datos del archivo
        File file = new File(getFilesDir(), "datos.txt");
        ArrayList<Usuario>  usuarios = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){
                //dividir la linea en los datos del usuario separados
                String[] userData = line.split(",");
                String nombre = userData[0];
                String correo = userData[1];
                String nickname = userData[2];
                String passwordData = userData[3];

                //Crear un objeto usuario y aniadirlo a la lista de usuarios
                Usuario nuevoUsuario = new Usuario(nombre, correo, nickname, passwordData);
                usuarios.add(nuevoUsuario);
            }
            reader.close();
            for(Usuario usuario : usuarios){
                Log.d("Usuarios",
                        "Nombre: " + usuario.getNombre() + ", Correo: " + usuario.getCorreo() +
                                ", Nickname: " + usuario.getNickname() + ", Password: " + usuario.getPassword());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        // Configurar el evento de click para el boton de ingreso

        // Validación de correo
        tilEmail = findViewById(R.id.tilEmail);
        edcorreo = findViewById(R.id.ed_correo);

        password = findViewById(R.id.ed_contrasenia);
        botonLogin = findViewById(R.id.bt_ini_sesion);

        tvRecuperacontra = findViewById(R.id.tv_recuperacontra);


        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edcorreo.getText().toString();
                if (!isValidEmail(email)) {
                    tilEmail.setError("Ingrese un correo válido");
                } else {
                    tilEmail.setError(null);
                    //login(); // Llama al método de inicio de sesión

                    if (!edcorreo.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                        String inputUsuario    = edcorreo.getText().toString();
                        String inputPassword = password.getText().toString();


                        // Buscar el usuario coincidente en la lista de usuarios
                        for (Usuario usuario : usuarios) {

                            if (usuario.getPassword().equals(inputPassword)) {
                                if (usuario.getNickname().equals(inputUsuario) || usuario.getCorreo().equals(inputUsuario) || usuario.getNombre().equals(inputUsuario)) {
                                    // Si se encuentra una coincidencia, iniciar la actividad principal y salir del bucle
                                    startActivity(principalIntent);
                                    return;
                                }
                            }
                        }
                        // Si no se encontró una coincidencia, mostrar un mensaje de error utilizando Toast
                        Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




        // Navegación al layout de registrarse
        botonRegister= findViewById(R.id.bt_registrar);
        botonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Navegar a la actividad de registrarse
                Intent intent = new Intent(MainActivity.this, RegistrarseActivity.class);
                startActivity(intent);
            }
        });
        // Aviso recupera contrasenia
        tvRecuperacontra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Funcionalidad aún no disponible", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void login() {
//        String inputUsuario    = this.edcorreo.getText().toString();
//        String inputPassword = this.password.getText().toString();



    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}