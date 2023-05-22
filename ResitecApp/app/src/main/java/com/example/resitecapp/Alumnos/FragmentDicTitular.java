package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.AsesorExterno;
import com.google.android.material.textview.MaterialTextView;

public class FragmentDicTitular extends Fragment {

    MaterialTextView txtNombre, txtPuesto, txtArea, txtEmail, txtTelefeno;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dictitular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtNombre = view.findViewById(R.id.txtNombre);
        txtPuesto = view.findViewById(R.id.txtPuesto);
        txtArea = view.findViewById(R.id.txtArea);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtTelefeno = view.findViewById(R.id.txtTelefono);

        MostrarDatos();
    }

    private AsesorExterno asesorExterno;
    public FragmentDicTitular(AsesorExterno asesorExterno){
        this.asesorExterno = asesorExterno;

        if(asesorExterno == null){
            System.out.println("asesor externo es null");
        }
        System.out.println("Datos del Asesor Externo");
        //System.out.println("nombreAsesor: " + asesorExterno.getNombre());
        //System.out.println("puesto: " + asesorExterno.getPuesto());
        //System.out.println("area: " + asesorExterno.getArea());

    }

    private String mensajeVacio;

    public void MostrarDatos(){
        mensajeVacio = "Falta agregar";
        String contenido = null;

        contenido = "Nombre: ";
        contenido += (asesorExterno.getNombre() == null || asesorExterno.getNombre().equals(""))?  mensajeVacio:  asesorExterno.getNombre();
        txtNombre.setText(contenido);
        contenido = "Puesto: ";
        contenido += (asesorExterno.getPuesto() == null || asesorExterno.getPuesto().equals(""))? mensajeVacio: asesorExterno.getPuesto();
        txtPuesto.setText(contenido);
        contenido = "Area: ";
        contenido += (asesorExterno.getArea() == null || asesorExterno.getArea().equals(""))? mensajeVacio:  asesorExterno.getArea();
        txtArea.setText(contenido);
        contenido = "Email: ";
        contenido += (asesorExterno.getEmail() == null || asesorExterno.getEmail().equals(""))? mensajeVacio:  asesorExterno.getEmail();
        txtEmail.setText(contenido);
        contenido = "Telefono: ";
        contenido += (asesorExterno.getTelefono() == null || asesorExterno.getTelefono().equals(""))? mensajeVacio:  asesorExterno.getTelefono();
        txtTelefeno.setText(contenido);

    }


}
