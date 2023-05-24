package com.example.resitecapp.objects;

public class DictamenSingleton {
    private static DictamenSingleton intancia;
    private Dictamen dictamen;

    private DictamenSingleton(){

    }

    public static DictamenSingleton getInstance(){
        if(intancia == null){
            intancia = new DictamenSingleton();
        }
        return intancia;
    }

    public Dictamen getDictamen(){
        return dictamen;
    }

    public void setDictamen(Dictamen dictamen){
        this.dictamen = dictamen;
    }
}
