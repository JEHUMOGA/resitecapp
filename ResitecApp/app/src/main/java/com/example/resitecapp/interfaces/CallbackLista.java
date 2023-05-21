package com.example.resitecapp.interfaces;

import java.util.List;

public interface CallbackLista <T>{
    void onSuccess(List<T> callback);
    void onFailure(String mensaje);
}
