package com.example.resitecapp.tabAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.resitecapp.Alumnos.FragmentDicAlumno;
import com.example.resitecapp.Alumnos.FragmentDicTitular;
import com.example.resitecapp.Alumnos.FragmentDictEmpresa;
import com.example.resitecapp.Alumnos.FragmentDictProyecto;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.Dictamen;
import com.example.resitecapp.objects.Empresa;
import com.example.resitecapp.objects.Proyecto;

public class TabAdapter extends FragmentStateAdapter {
    private Dictamen dictamen;
    private Empresa empresa;
    private Proyecto proyecto;
    private AsesorExterno asesorExterno;
    private Alumno alumno;
    public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Dictamen dictamen) {
        super(fragmentManager, lifecycle);
        this.dictamen = dictamen;
        imprimirDatos(dictamen);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: {
                return new FragmentDicTitular(asesorExterno);
            }
            case 2: {
                return new FragmentDictProyecto(proyecto);
            }
            case 3: {
                return new FragmentDicAlumno(alumno);
            }
        }
        return new FragmentDictEmpresa(empresa);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public void imprimirDatos(Dictamen dictamen){


        if(dictamen.getAlumno() == null){
            System.out.println("alumno es null");
        }
        empresa = dictamen.getEmpresa();
        proyecto = dictamen.getProyecto();
        asesorExterno = dictamen.getAsesorExterno();
        alumno = dictamen.getAlumno();




    }
}
