package com.example.resitecapp.controller;
/*
import android.view.View;
import android.widget.Toast;

import com.example.resitecapp.MainActivity;
import com.example.resitecapp.objects.Response;
import com.example.resitecapp.objects.Usuario;
import com.example.resitecapp.services.MyApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
*/
public class UsuarioController {
    /*
}
    Response<Usuario> responseObject;
    public UsuarioController(){
        responseObject = new Response<Usuario>();
    }
    public Response<Usuario> find(String numControl){
        System.out.println(numControl);
        Response<Usuario> responseObject = new Response<Usuario>();
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<List<Usuario>> call = myApiService.getUsuario(numControl);
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, retrofit2.Response<List<Usuario>> response) {
                try {
                    if(response.isSuccessful()){
                        List<Usuario> users = response.body();
                        Usuario us = users.get(0);
                        /*txtEmail.setText(us.getEmail());
                        txtNombreUs.setText(us.getNombre());
                        txtTipo.setText(us.getTipo());*/
                        /*responseObject.setObjecto(us);
                        responseObject.setMensaje("OK");
                        return responseObject;
                    }
                }
                catch (Exception ex){
                    //Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    responseObject.setMensaje(ex.getMessage());
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error de conexion " + t.toString(), Toast.LENGTH_SHORT).show();
                responseObject.setMensaje("Error de conexion " + t.toString());
            }
        });

    }
*/
}
