package com.example.resitecapp.controller;

import com.example.resitecapp.interfaces.CallbackLista;
import com.example.resitecapp.objects.Asesor;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsesorController {
    private Url url;
    private String mensaje;
    List<Asesor> listaAsesor;

    public AsesorController(){
        listaAsesor = new ArrayList<Asesor>();
        url= new Url();
    }

    public void listaAsesores(CallbackLista callback){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url.getUrl())
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<List<Asesor>> call = myApiService.getAsesores();
        call.enqueue(new Callback<List<Asesor>>() {

            @Override
            public void onResponse(Call<List<Asesor>> call, retrofit2.Response<List<Asesor>> response) {
                try {
                    if (!response.isSuccessful()){
                        mensaje = "FAILURE";
                    }
                    listaAsesor = response.body();
                    callback.onSuccess(listaAsesor);
                }catch (Exception ex){
                    mensaje = "EXCEPTION: " + ex.getMessage();
                    callback.onFailure(mensaje);
                }
            }

            @Override
            public void onFailure(Call<List<Asesor>> call, Throwable t) {
                mensaje = "ERROR DE CONEXION: " + t.toString();
                callback.onFailure(mensaje);
            }
        });
    }
}
