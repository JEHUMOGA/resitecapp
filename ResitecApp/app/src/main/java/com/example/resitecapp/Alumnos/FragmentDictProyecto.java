package com.example.resitecapp.Alumnos;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.Proyecto;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class FragmentDictProyecto extends Fragment{

    TextInputEditText fechaNacimiento;

    MaterialTextView txtTitulo, txtAcronimo, txtTipo, txtRealizacion;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        return inflater.inflate(R.layout.fragment_dictproyecto, container, false);
    }

    private Proyecto proyecto;
    public FragmentDictProyecto(Proyecto proyecto){
        this.proyecto = proyecto;
        if(this.proyecto == null){
            System.out.println("proyecto es null");
        }

        System.out.println("Datos del Proyecto");
        System.out.println("idProyecto: " + proyecto.getEmpresaID());
        System.out.println("acronimo: " + proyecto.getAcronimo());
        System.out.println("titulo: " + proyecto.getTitulo());

    }

    private String mensajeVacio;

    public void MostrarDatos(){
        mensajeVacio = "Falta agregar";
        String contenido = null;

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
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtAcronimo = view.findViewById(R.id.txtAcronimo);
        txtTipo = view.findViewById(R.id.txtTipo);
        txtRealizacion = view.findViewById(R.id.txtRealizacion);

        MostrarDatos();
        /*fechaNacimiento = view.findViewById(R.id.txtNacimientoEstudiante);
        fechaNacimiento.setOnClickListener(this);*/
    }

/*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtNacimientoEstudiante:
                showDatePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog(){
        DatePickerFragment newDatePicker = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day+" / " + (month+1) + " / " + year;
                fechaNacimiento.setText(selectedDate);
            }
        });
        newDatePicker.show(getActivity().getSupportFragmentManager(),"datePicker");
    }*/
}
