package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.Empresa;
import com.google.android.material.textview.MaterialTextView;

public class FragmentDicAlumno extends Fragment {
    MaterialTextView txtNombre, txtApePaterno, txtApeMat, txtNumeroControl, txtFechaNacimiento, txtCalle, txtColonia, txtCodigoPostal;
    MaterialTextView txtCiudad, txtPais, txtNss, txtTipoSeguro, txtSexo, txtCorreoPersonal, txtTelefenoPersonal, txtTelefonoCasa, txtCorrioInstitucional;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dicalumno, container, false);
    }
    private Alumno alumno;
    public FragmentDicAlumno(Alumno alumno){
        this.alumno = alumno;
        if(this.alumno == null){
            System.out.println("alumno es null");
        }
        System.out.println("Datos del Alumno");
        System.out.println("numero de control: " + alumno.getNumerodecontrol());
        System.out.println("nombre Alumno: " + alumno.getNombre());
        System.out.println("apePaterno: " + alumno.getApePat());
        System.out.println("apeMaterno: " + alumno.getApeMat());
        System.out.println("correo Institucional: " + alumno.getCorreoInstitucional());

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
