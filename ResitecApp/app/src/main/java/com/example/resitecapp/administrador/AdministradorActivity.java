package com.example.resitecapp.administrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resitecapp.MainActivity;
import com.example.resitecapp.R;
import com.example.resitecapp.interfaces.RecyclerViewGrupo;
import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.objects.ListaGrupos;
import com.example.resitecapp.objects.Usuario;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdministradorActivity extends Fragment implements RecyclerViewGrupo {
    List<Grupo> grupos;
    View view;
/*
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        grupos = new ArrayList<Grupo>();
        init();
    }
*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_administrador, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        grupos = new ArrayList<Grupo>();
        init();
    }

    public void init(){
        System.out.println("Entro Init");
        getGrupos();

    }
    private void setupRecyclerView(List<Grupo> grupos) {
        ListaGrupos listaGrupos = new ListaGrupos(grupos, this.getContext(), this);
        RecyclerView recyclerView = view.findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(listaGrupos);

    }
    private List<Grupo> getGrupos(){
        final List<Grupo> responseGrupos = new ArrayList<>();
        System.out.println("Entro getGrupos");
        String url = new Url().getUrl();
        System.out.println("URL: " + url);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build();
        MyApiService myApiService = retrofit.create(MyApiService.class);
        Call<List<Grupo>> call = myApiService.getGrupos();
        call.enqueue(new Callback<List<Grupo>>() {
            @Override
            public void onResponse(Call<List<Grupo>> call, Response<List<Grupo>> response) {
                try {
                    if(response.isSuccessful()){
                        grupos = response.body();
                        setupRecyclerView(grupos);

                    }
                }catch (Exception ex){
                    Toast.makeText(AdministradorActivity.this.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Grupo>> call, Throwable t) {
                Toast.makeText(AdministradorActivity.this.getContext(), "Error de conexion " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return grupos;
    }

    @Override
    public void onItemClick(int position) {
        int id = grupos.get(position).getIdProyecto();
        System.out.println("ID del proyecto: " + id);
        Intent intent = new Intent(AdministradorActivity.this.getContext(), DetalleGrupoActivity.class);
        intent.putExtra("id", id);
        //intent.putExtra("")
        startActivity(intent);
    }
}
