package com.example.resitecapp.Alumnos;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Proyecto;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class FragmentDictProyecto extends Fragment{

    TextInputEditText fechaNacimiento;

    MaterialTextView txtTitulo, txtAcronimo, txtTipo, txtRealizacion;

    MaterialTextView titulo;
    private ScrollView info;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        return inflater.inflate(R.layout.fragment_dictproyecto, container, false);
    }

    private Proyecto proyecto;
    public FragmentDictProyecto(Proyecto proyecto){
        this.proyecto = proyecto;

    }

    private String mensajeVacio;

    public void MostrarDatos(){
        mensajeVacio = "Falta agregar";
        String contenido = null;

        if(this.proyecto == null){
            titulo.setText("Sin datos de Proyecto");
            return;
        }
        info.setVisibility(View.VISIBLE);

        contenido = "Titulo: ";
        contenido += (proyecto.getTitulo() == null || proyecto.getTitulo().equals(""))?  mensajeVacio:  proyecto.getTitulo();
        txtTitulo.setText(contenido);
        contenido = "Acronimo: ";
        contenido += (proyecto.getAcronimo() == null || proyecto.getAcronimo().equals(""))? mensajeVacio: proyecto.getAcronimo();
        txtAcronimo.setText(contenido);
        contenido = "Tipo: ";
        contenido += (proyecto.getTipo() == null || proyecto.getTipo().equals(""))? mensajeVacio:  proyecto.getTipo();
        txtTipo.setText(contenido);
        contenido = "Realizacion: ";
        contenido += (proyecto.getRealizacion() == null || proyecto.getRealizacion().equals(""))? mensajeVacio:  proyecto.getRealizacion();
        txtRealizacion.setText(contenido);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(DictamenSingleton.getInstance().getDictamen() == null) {
            this.proyecto = null;
        }else{
            this.proyecto = DictamenSingleton.getInstance().getDictamen().getProyecto();
        }
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtAcronimo = view.findViewById(R.id.txtAcronimo);
        txtTipo = view.findViewById(R.id.txtTipo);
        txtRealizacion = view.findViewById(R.id.txtRealizacion);
        titulo = view.findViewById(R.id.titulo);
        info = view.findViewById(R.id.info);
        MostrarDatos();
    }

    @Override
    public void onResume() {
        super.onResume();
        actualizarProyecto();
    }

    public void actualizarProyecto() {
        if(DictamenSingleton.getInstance().getDictamen() == null)
            return;
        this.proyecto = DictamenSingleton.getInstance().getDictamen().getProyecto();
        MostrarDatos();
    }
}
