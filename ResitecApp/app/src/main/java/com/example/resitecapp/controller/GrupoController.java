package com.example.resitecapp.controller;

import com.example.resitecapp.interfaces.CallbackLista;
import com.example.resitecapp.interfaces.CallbackSimple;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.EnviarGrupo;
import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GrupoController {
    private EnviarGrupo enviarGrupo;
    private Url url;
    private String mensaje;

    public GrupoController(){
        enviarGrupo = new EnviarGrupo();
        url = new Url();
    }

    public void crearGrupo(String asesor, List<Alumno> alumnos, CallbackLista callback){

        enviarGrupo.setAsesor(asesor);
        enviarGrupo.setAlumnos(alumnos);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url.getUrl())
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<Void> call = myApiService.agregarGrupo(enviarGrupo);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful())
                    mensaje= "Grupo creado correctamente";
                else
                    mensaje="El grupo no se pudo crear " + response.message();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                mensaje="Error en la conexion: " + t.getMessage();
                callback.onFailure(mensaje);
            }
        });
    }

    public void getGrupo(int id, CallbackSimple callback){
        Url url = new Url();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url.getUrl())
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<Grupo> call = myApiService.getGrupo(id);
        System.out.println("Obtener grupo: " + id);
        call.enqueue(new Callback<Grupo>() {

            @Override
            public void onResponse(Call<Grupo> call, Response<Grupo> response) {
                try {
                    if(!response.isSuccessful()){
                        callback.onFailure("Error al consultar grupo");
                        return;
                    }

                    Grupo grup = response.body();
                    callback.onSuccess(grup);
                }catch (Exception ex){
                    callback.onFailure(ex.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Grupo> call, Throwable t) {
                callback.onFailure("Error de conexion " + t.toString());
            }
        });
    }

    public String getMensaje(){
        return mensaje;
    }
}
