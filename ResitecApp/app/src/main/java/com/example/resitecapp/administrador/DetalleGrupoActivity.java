package com.example.resitecapp.administrador;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.Asesor;
import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleGrupoActivity extends AppCompatActivity {
    //private Grupo grupo;
    MaterialTextView tituloProyecto;
    MaterialTextView txtAcronimo;
    MaterialTextView txtAsesorInterno;
    MaterialTextView txtAlumnos;
    int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detgrupo_administrador);
        //grupo = (Grupo) getIntent().getSerializableExtra("grupo");
        //System.out.println("Nombre del proyecto: " + grupo.getNomProyecto());
        tituloProyecto = findViewById(R.id.tituloProyecto);
        txtAcronimo = findViewById(R.id.txtAcronimo);
        txtAsesorInterno = findViewById(R.id.txtAsesorInterno);
        txtAlumnos = findViewById(R.id.txtAlumnos);
        id = getIntent().getIntExtra("id", 0);
        //tituloProyecto.setText("ID Proyecto: " + id);
        getGrupo();

    }

    public void getGrupo(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.100.9:8000/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<List<Grupo>> call = myApiService.getGrupo(id+"");
        call.enqueue(new Callback<List<Grupo>>() {

            @Override
            public void onResponse(Call<List<Grupo>> call, Response<List<Grupo>> response) {
                try {
                    if(response.isSuccessful()){
                        List<Grupo> grup = response.body();
                        Grupo grupo = grup.get(0);
                        tituloProyecto.setText(grupo.getNomProyecto());
                        txtAcronimo.setText(grupo.getAcronimoProyecto());
                        txtAsesorInterno.setText(grupo.getAsesor().getNombre());
                        List<Alumno> alumnos = grupo.getAlumnos();
                        String aux = "";
                        for(int i = 0; i< alumnos.size(); i++){
                            aux+= alumnos.get(i).getNombre()+"\n";
                        }
                        txtAlumnos.setText(aux);

                    }
                }catch (Exception ex){
                    Toast.makeText(DetalleGrupoActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Grupo>> call, Throwable t) {
                Toast.makeText(DetalleGrupoActivity.this, "Error de conexion " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
