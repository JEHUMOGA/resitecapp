package com.example.resitecapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.resitecapp.Alumnos.alumnoActivity;
import com.example.resitecapp.Alumnos.dictamenProyecto;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity  {
    private TextInputEditText editTextCorreo, editTextPassword;
    private TextInputLayout contenedorCorreo, contenedorPassword;
    private Button btnIngresar;
    private TextView viewApi;
    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCorreo=findViewById(R.id.editTextCorreo);
        contenedorCorreo = findViewById(R.id.contendedorCorreo);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = editTextCorreo.getText().toString().trim();
                if(correo.isEmpty()){
                    editTextCorreo.setError("Campo obligatorio");
                    editTextCorreo.requestFocus();
                    return;
                }

                Intent usuario = new Intent(MainActivity.this, alumnoActivity.class);
                usuario.putExtra("correo", correo);
                startActivity(usuario);

            }
        });


        focusListenerCorreo();
    }

    private void focusListenerCorreo(){
        editTextCorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    contenedorCorreo.setHelperText(validarCorreo());
                }
            }
        });
    }
    private String validarCorreo(){
        String cadanaCorreo = editTextCorreo.getText().toString();
        if(!Patterns.EMAIL_ADDRESS.matcher(cadanaCorreo).matches()){
            return "Correo Electronico Invalido";
        }
        return null;
    }

    private void focusListenerPassword(){
        editTextCorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    contenedorPassword.setHelperText(validarPassword());
                }
            }
        });
    }
    private String validarPassword(){
        String cadenaPassword = editTextPassword.getText().toString();
        if(cadenaPassword.length() < 8){
            return "Minimo 8 caracteres";
        }
        return null;
    }

}
