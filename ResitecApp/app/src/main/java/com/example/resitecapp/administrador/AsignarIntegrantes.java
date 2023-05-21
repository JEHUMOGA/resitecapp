package com.example.resitecapp.administrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resitecapp.R;
import com.example.resitecapp.controller.AlumnoController;
import com.example.resitecapp.controller.AsesorController;
import com.example.resitecapp.controller.GrupoController;
import com.example.resitecapp.interfaces.CallbackLista;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.Asesor;
import com.example.resitecapp.objects.Grupo;
import com.example.resitecapp.objects.ListaAlumnoAdapter;
import com.example.resitecapp.objects.ListaAsesorAdapter;

import java.util.ArrayList;
import java.util.List;

public class AsignarIntegrantes extends Fragment{

    public List<Alumno> listaAlumnos;
    public List<Alumno> listaFiltrada;
    public List<Alumno> listaAlumnosSelect;
    public List<Asesor> listaAsesor, listaAsesorSelect;

    RecyclerView recyclerViewAlumnos;
    RecyclerView recyclerViewAlumnosSelect;
    RecyclerView recyclerViewAsesores, recyclerViewAsesoresSelect;
    SearchView searchViewAlumno;

    ListaAlumnoAdapter adapter;
    ListaAlumnoAdapter adapterSelect;
    ListaAsesorAdapter asesorAdapter, asesorAdapterSelect;
    private Toolbar toolbar;

    Button btnAgregar;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_asignarintegrantes, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        listaAlumnos = new ArrayList<Alumno>();
        listaAlumnosSelect = new ArrayList<Alumno>();
        listaFiltrada = new ArrayList<Alumno>();

        listaAsesor = new ArrayList<Asesor>();
        listaAsesorSelect = new ArrayList<Asesor>();

        btnAgregar = view.findViewById(R.id.btnCrear);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearGrupo();
                listaAlumnosSelect.clear();
                for (Asesor asesor: listaAsesorSelect){
                    listaAsesor.add(asesor);
                }
                listaAsesorSelect.clear();
                adapterSelect.notifyDataSetChanged();
                adapter.notifyDataSetChanged();
                asesorAdapter.notifyDataSetChanged();
                asesorAdapterSelect.notifyDataSetChanged();
            }
        });
        getAlumnos();
        generaAsesores();
    }

    public  void crearGrupo(){
        int sizeAlumnos = listaAlumnosSelect.size();
        int sizeAsesor = listaAsesorSelect.size();

        if(sizeAlumnos < 1 || sizeAsesor < 1){
            Toast.makeText(AsignarIntegrantes.this.getContext(), "Debe seleccionar al menos un alumno y un asesor", Toast.LENGTH_SHORT).show();
            return;
        }
        Asesor asesor = listaAsesorSelect.get(0);
        GrupoController grupoController = new GrupoController();
        grupoController.crearGrupo(asesor.getCorreo(), listaAlumnosSelect, new CallbackLista<Grupo>() {
            @Override
            public void onSuccess(List<Grupo> callback) {

            }

            @Override
            public void onFailure(String mensaje) {
                Toast.makeText(AsignarIntegrantes.this.getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(AsignarIntegrantes.this.getContext(), "Grupo creado", Toast.LENGTH_SHORT).show();
    }
    private void setupRecyclerViewAlumnos(List<Alumno> alumnos) {
        listaFiltrada.addAll(alumnos);
        adapter = new ListaAlumnoAdapter(listaFiltrada, this.getContext());

        recyclerViewAlumnos = view.findViewById(R.id.listaAlumnos);
        recyclerViewAlumnos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAlumnos.setAdapter(adapter);

        adapterSelect = new ListaAlumnoAdapter(listaAlumnosSelect, this.getContext());

        recyclerViewAlumnosSelect = view.findViewById(R.id.listaAlumnosSelect);
        recyclerViewAlumnosSelect.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAlumnosSelect.setAdapter(adapterSelect);

        adapter.setOnItemClickListener(new ListaAlumnoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Alumno alumno) {
                agregar(alumno, listaAlumnos, listaAlumnosSelect);
                listaFiltrada.remove(alumno);
                adapterSelect.notifyDataSetChanged();
                adapter.notifyDataSetChanged();
            }
        });

        adapterSelect.setOnItemClickListener(new ListaAlumnoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Alumno alumno) {
                eliminarSelect(alumno, listaAlumnos, listaAlumnosSelect);
                listaFiltrada.add(alumno);
                adapter.notifyDataSetChanged();
                adapterSelect.notifyDataSetChanged();
            }
        });

        searchViewAlumno = view.findViewById(R.id.searchViewAlumno);
        searchViewAlumno.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrarAlumnos(newText);
                return false;
            }
        });

        adapter.notifyDataSetChanged();

    }
    private void setupRecyclerViewAsesores(List<Asesor> asesor) {

        asesorAdapter = new ListaAsesorAdapter(asesor, this.getContext());

        recyclerViewAsesores = view.findViewById(R.id.listaAsesores);
        recyclerViewAsesores.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAsesores.setAdapter(asesorAdapter);

        asesorAdapterSelect = new ListaAsesorAdapter(listaAsesorSelect, this.getContext());

        recyclerViewAsesoresSelect = view.findViewById(R.id.listaAsesoresSelect);
        recyclerViewAsesoresSelect.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAsesoresSelect.setAdapter(asesorAdapterSelect);

        asesorAdapter.setOnItemClickListener(new ListaAsesorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Asesor asesor) {
                agregar(asesor, listaAsesor, listaAsesorSelect);
                asesorAdapter.notifyDataSetChanged();
                asesorAdapterSelect.notifyDataSetChanged();
            }
        });
        asesorAdapterSelect.setOnItemClickListener(new ListaAsesorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Asesor asesor) {
                eliminarSelect(asesor, listaAsesor, listaAsesorSelect);
                asesorAdapter.notifyDataSetChanged();
                asesorAdapterSelect.notifyDataSetChanged();
            }
        });
        asesorAdapter.notifyDataSetChanged();
    }
    private void filtrarAlumnos(String query){
        listaFiltrada.clear();

        for(Alumno alumno: listaAlumnos){
            String nombre = alumno.getNombre().toLowerCase();
            String correo = alumno.getCorreo().toLowerCase();
            if(nombre.contains(query.toLowerCase()) || correo.contains(query.toLowerCase())){
                listaFiltrada.add(alumno);
            }
        }
        adapter.notifyDataSetChanged();
    }
    private void getAlumnos(){
        AlumnoController alumnoController = new AlumnoController();
        alumnoController.listaAlumnos(new CallbackLista<Alumno>() {
            @Override
            public void onSuccess(List<Alumno> alumnos) {
                listaAlumnos = alumnos;
                setupRecyclerViewAlumnos(listaAlumnos);
            }

            @Override
            public void onFailure(String mensaje) {
                Toast.makeText(AsignarIntegrantes.this.getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void generaAsesores(){
        AsesorController asesorController = new AsesorController();
        asesorController.listaAsesores(new CallbackLista<Asesor>() {
            @Override
            public void onSuccess(List<Asesor> asesor) {
                listaAsesor = asesor;
                setupRecyclerViewAsesores(listaAsesor);
            }

            @Override
            public void onFailure(String mensaje) {
                Toast.makeText(AsignarIntegrantes.this.getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public <T, U> void agregar(T integrante, List<T> lista, List<T> listaSelect){
        lista.remove(integrante);
        listaSelect.add(integrante);

    }

    public <T,U> void eliminarSelect(T integrante, List<T> lista, List<T> listaSelect){
        listaSelect.remove(integrante);
        lista.add(integrante);

    }

}
