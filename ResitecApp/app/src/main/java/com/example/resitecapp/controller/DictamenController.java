package com.example.resitecapp.controller;

import com.example.resitecapp.interfaces.CallbackSimple;
import com.example.resitecapp.objects.CorreoInstitucional;
import com.example.resitecapp.objects.Dictamen;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DictamenController {
    private Url url;

    public  DictamenController(){
        this.url = new Url();
    }
    public void getDictamen(CorreoInstitucional correoInstitucional, CallbackSimple<Dictamen> callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url.getUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<Dictamen> call = myApiService.getDictamen(correoInstitucional);
        call.enqueue(new Callback<Dictamen>() {
            @Override
            public void onResponse(Call<Dictamen> call, Response<Dictamen> response) {
                if(!response.isSuccessful()){
                    callback.onFailure("Error al obtener Dictamen");
                }
                Dictamen dictamen = response.body();
                callback.onSuccess(dictamen);
            }

            @Override
            public void onFailure(Call<Dictamen> call, Throwable t) {
                callback.onFailure("Error en la conexcion: " + t.toString());
            }
        });
    }
}
