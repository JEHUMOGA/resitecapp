package com.example.resitecapp.interfaces;

public interface CallbackSimple <T>{
    void onSuccess(T callback);
    void onFailure(String mensaje);
}
