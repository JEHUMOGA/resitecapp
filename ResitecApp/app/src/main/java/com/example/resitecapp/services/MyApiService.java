package com.example.resitecapp.services;

import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.objects.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApiService {

    @GET("Grupos")
    public Call<List<Grupo>> getGrupos();
    @GET("Grupos/{id}")
    public Call<List<Grupo>> getGrupo(@Path("id") String id);

    @GET("Usuario/{id}")
    public Call<List<Usuario>> getUsuario(@Path("id") String id);
}
