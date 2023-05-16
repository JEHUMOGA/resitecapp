package com.example.resitecapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resitecapp.Alumnos.alumnoActivity;
import com.example.resitecapp.administrador.AdministradorActivity;
import com.example.resitecapp.controller.UsuarioController;
import com.example.resitecapp.objects.Usuario;
import com.example.resitecapp.services.MyApiService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
    private TextInputEditText editTextCorreo, editTextPassword;
    private TextInputLayout contenedorCorreo, contenedorPassword;
    private MaterialButton btnIngresar;
    private TextView viewApi;
    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCorreo=findViewById(R.id.editTextCorreo);
        editTextPassword=findViewById(R.id.editTextPassword);
        contenedorCorreo = findViewById(R.id.contendedorCorreo);
        contenedorPassword = findViewById(R.id.contendedorPassword);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent usuario = new Intent(MainActivity.this, alumnoActivity.class);
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


    /// Borrar despues y solo agregar lo que sea util

    //TextInputEditText numControl;
/*
    MaterialTextView txtEmail;
    MaterialTextView txtNombreUs;
    MaterialTextView txtTipo;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        txtEmail= findViewById(R.id.txtEmail);
        txtNombreUs = findViewById(R.id.txtNombreUs);
        txtTipo = findViewById(R.id.txtTipo);

        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find(editTextCorreo.getText().toString());
            }
        });
    }

    private void find(String numControl){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(new Url().getUrl())
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<List<Usuario>> call = myApiService.getUsuario(numControl);
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                try {
                    if(response.isSuccessful()){
                        List<Usuario> users = response.body();
                        Usuario us = users.get(0);
                        txtEmail.setText(us.getEmail());
                        txtNombreUs.setText(us.getNombre());
                        txtTipo.setText(us.getTipo());
                    }
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexion " + t.toString(), Toast.LENGTH_SHORT).show();
            };
        });
    }
*/

}
