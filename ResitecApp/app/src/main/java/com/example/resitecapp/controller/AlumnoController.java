package com.example.resitecapp.controller;

import com.example.resitecapp.interfaces.CallbackLista;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.Response;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlumnoController {
    Response<List<Alumno>> responseObject;
    private Url url;
    private String mensaje;
    List<Alumno> listaAlumnos;
    public AlumnoController(){
        responseObject = new Response<List<Alumno>>();
        listaAlumnos = new ArrayList<Alumno>();
        url = new Url();
    }
    public void listaAlumnos(CallbackLista callback){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url.getUrl())
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<List<Alumno>> call = myApiService.getAlumnosDisponibles();
        call.enqueue(new Callback<List<Alumno>>() {

            @Override
            public void onResponse(Call<List<Alumno>> call, retrofit2.Response<List<Alumno>> response) {
                try {
                    if (!response.isSuccessful()){
                        mensaje = "FAILURE";
                    }
                    listaAlumnos = response.body();
                    callback.onSuccess(listaAlumnos);
                }catch (Exception ex){
                    mensaje = "EXCEPTION: " + ex.getMessage();
                    callback.onFailure(mensaje);
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                mensaje = "ERROR DE CONEXION: " + t.toString();
                callback.onFailure(mensaje);
            }
        });
    }
}

