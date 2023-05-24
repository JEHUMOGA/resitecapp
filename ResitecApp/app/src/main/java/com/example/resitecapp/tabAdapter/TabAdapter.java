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
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: {
                System.out.println("Entro Asesor");
                return new FragmentDicTitular(asesorExterno);
            }
            case 2: {
                System.out.println("Entro Proyecto");
                return new FragmentDictProyecto(proyecto);
            }
            case 3: {
                System.out.println("Entro Alumno");
                return new FragmentDicAlumno(alumno);
            }
        }
        System.out.println("Entro Empresa");
        return new FragmentDictEmpresa(empresa);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
