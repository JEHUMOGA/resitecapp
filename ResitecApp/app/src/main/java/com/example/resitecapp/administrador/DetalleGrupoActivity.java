package com.example.resitecapp.administrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.resitecapp.R;
import com.example.resitecapp.controller.GrupoController;
import com.example.resitecapp.interfaces.CallbackSimple;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.Grupo;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class DetalleGrupoActivity extends Fragment {
    MaterialTextView tituloProyecto;
    MaterialTextView txtAcronimo;
    MaterialTextView txtAsesorInterno;
    MaterialTextView txtAlumnos;
    int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("Entro Detalle");
        return inflater.inflate(R.layout.detgrupo_administrador, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Entro Activity");
        Toolbar toolbar = view.findViewById(R.id.toolbar);
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

        tituloProyecto = view.findViewById(R.id.tituloProyecto);
        txtAcronimo = view.findViewById(R.id.txtAcronimo);
        txtAsesorInterno = view.findViewById(R.id.txtAsesorInterno);
        txtAlumnos = view.findViewById(R.id.txtAlumnos);

        id = getArguments().getInt("id", 0);
        getGrupo();
    }

    public void getGrupo(){
        System.out.println("getGrupo de DetalleGrupo");
        GrupoController grupoController = new GrupoController();
        grupoController.getGrupo(id, new CallbackSimple<Grupo>() {


            @Override
            public void onSuccess(Grupo callback) {
                Grupo grupo = callback;
                tituloProyecto.setText(grupo.getNomProyecto());
                txtAcronimo.setText(grupo.getAcronimoProyecto());
                txtAsesorInterno.setText(grupo.getAsesor().getNombre());

                System.out.println(grupo.getNomProyecto());
                System.out.println(grupo.getAcronimoProyecto());
                System.out.println(grupo.getAsesor().getNombre());
                System.out.println("Alumnos");

                List<Alumno> lista = grupo.getAlumnos();
                String alumns = "";
                for(Alumno alumno: lista){
                    alumns+= alumno.getNombre() + "\n" + alumno.getCorreoInstitucional() + "\n\n";
                    System.out.println(alumns);
                }
                txtAlumnos.setText(alumns);
            }

            @Override
            public void onFailure(String mensaje) {
                Toast.makeText(DetalleGrupoActivity.this.getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.popBackStack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
