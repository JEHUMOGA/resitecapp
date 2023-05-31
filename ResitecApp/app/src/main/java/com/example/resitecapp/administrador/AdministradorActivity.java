package com.example.resitecapp.administrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resitecapp.R;
import com.example.resitecapp.interfaces.RecyclerViewPosition;
import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.objects.ListaGrupos;
import com.example.resitecapp.services.MyApiService;
import com.example.resitecapp.services.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdministradorActivity extends Fragment implements RecyclerViewPosition {
    List<Grupo> grupos;
    View view;
    private Button btnAgregar;

    ViewGroup container;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.container = container;
        return inflater.inflate(R.layout.activity_administrador, this.container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        grupos = new ArrayList<Grupo>();

        btnAgregar = view.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsignarIntegrantes asignarIntegrantes = new AsignarIntegrantes();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, asignarIntegrantes)
                        .addToBackStack(null)
                        .commit();
            }
        });
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

        DetalleGrupoActivity detalleGrupoFragment = new DetalleGrupoActivity();
        Bundle args = new Bundle();
        args.putInt("id", id);
        detalleGrupoFragment.setArguments(args);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, detalleGrupoFragment)
                .addToBackStack(null)
                .commit();

    }


}
