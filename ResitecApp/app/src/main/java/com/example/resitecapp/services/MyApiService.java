package com.example.resitecapp.services;

import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.Asesor;
import com.example.resitecapp.objects.EnviarGrupo;
import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.objects.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyApiService {

    @GET("AsesoresInternos")
    public Call<List<Asesor>> getAsesores();
    @GET("Usuarios/Alumnos")
    public Call<List<Alumno>> getAlumnosDisponibles();
    @GET("Grupos")
    public Call<List<Grupo>> getGrupos();
    @GET("Grupos/{id}")
    public Call<Grupo> getGrupo(@Path("id") int id);

    @POST("Grupos")
    public Call<Void> agregarGrupo(@Body EnviarGrupo grupo);

    @GET("Usuario/{id}")
    public Call<List<Usuario>> getUsuario(@Path("id") String id);


}
