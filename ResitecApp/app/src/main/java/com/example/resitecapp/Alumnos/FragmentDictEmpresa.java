package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Empresa;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class FragmentDictEmpresa extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dictempresa, container, false);
    }
    String mensajeVacio;
    MaterialTextView txtLugar, txtRfc, txtGiro, txtCalle, txtColonia, txtCodigoPostal, txtCiudad, txtFax;
    MaterialTextView txtTelefono, txtTelefonoExt, txtNombre, txtPuesto;

    MaterialTextView titulo;
    private Empresa empresa;
    ScrollView info;
    public FragmentDictEmpresa(Empresa empresa){
        this.empresa = empresa;
        /*
        if(this.empresa == null){
            System.out.println("empresa es null");
        }
        System.out.println("Datos de la empresa");
        System.out.println("lugar: " + empresa.getLugar());
        System.out.println("rfc: " + empresa.getRfc());
        System.out.println("giro: " + empresa.getGiro());
        System.out.println("domicilio: " + empresa.getDomicilio());*/


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(DictamenSingleton.getInstance().getDictamen() == null) {
            this.empresa = new Empresa();
        }else {
            this.empresa = DictamenSingleton.getInstance().getDictamen().getEmpresa();
        }
        titulo = view.findViewById(R.id.titulo);

        titulo = view.findViewById(R.id.titulo);

        txtLugar = view.findViewById(R.id.txtLugar);
        txtRfc = view.findViewById(R.id.txtRfc);
        txtGiro = view.findViewById(R.id.txtGiro);
        txtCalle = view.findViewById(R.id.txtCalle);
        txtColonia = view.findViewById(R.id.txtColonia);
        txtCodigoPostal = view.findViewById(R.id.txtCodigoPostal);
        txtCiudad = view.findViewById(R.id.txtCiudad);
        txtFax = view.findViewById(R.id.txtFax);
        txtTelefono = view.findViewById(R.id.txtTelefono);
        txtTelefonoExt = view.findViewById(R.id.txtTelefonoExt);
        txtNombre = view.findViewById(R.id.txtNombreTitular);
        txtPuesto = view.findViewById(R.id.txtPuestoTitular);
        info = view.findViewById(R.id.info);
        MostrarDatos();
    }

    public void MostrarDatos(){
        mensajeVacio = "Falta agregar";
        String contenido = null;

        if(this.empresa == null){
            titulo.setText("Sin datos de Empresa");
            return;
        }
        info.setVisibility(View.VISIBLE);

        contenido = "Lugar: ";
        contenido += (empresa.getLugar() == null || empresa.getLugar().equals(""))?  mensajeVacio:  empresa.getLugar();
        txtLugar.setText(contenido);
        contenido = "RFC: ";
        contenido += (empresa.getRfc() == null || empresa.getRfc().equals(""))? mensajeVacio: empresa.getRfc();
        txtRfc.setText(contenido);
        contenido = "Giro: ";
        contenido += (empresa.getGiro() == null || empresa.getGiro().equals(""))? mensajeVacio:  empresa.getGiro();
        txtGiro.setText(contenido);
        contenido = "Calle: ";
        contenido += (empresa.getDomicilio() == null || empresa.getDomicilio().equals(""))? mensajeVacio:  empresa.getDomicilio();
        txtCalle.setText(contenido);
        contenido = "Colonia: ";
        contenido += (empresa.getColonia() == null || empresa.getColonia().equals(""))? mensajeVacio: empresa.getColonia();
        txtColonia.setText(contenido);
        contenido = "Codigo Postal: ";
        contenido += (empresa.getCodigoPostal() == null || empresa.getCodigoPostal().equals(""))? mensajeVacio: empresa.getCodigoPostal();
        txtCodigoPostal.setText(contenido);
        contenido = "Ciudad: ";
        contenido += (empresa.getCiudad() == null || empresa.getCiudad().equals(""))? mensajeVacio:  empresa.getCiudad();
        txtCiudad.setText(contenido);
        contenido = "Fax: ";
        contenido += (empresa.getFax() == null || empresa.getFax().equals(""))? mensajeVacio:  empresa.getFax();
        txtFax.setText(contenido);
        contenido = "Telefono: ";
        contenido += (empresa.getTelefono() == null || empresa.getTelefono().equals(""))? mensajeVacio: empresa.getTelefono();
        txtTelefono.setText(contenido);
        contenido = "Extencion de Telefono: ";
        contenido += (empresa.getTelefonoExtension() == null || empresa.getTelefonoExtension().equals(""))? mensajeVacio: empresa.getTelefonoExtension();
        txtTelefonoExt.setText(contenido);
        contenido = "Nombre de titular: ";
        contenido += (empresa.getNombreTitular() == null || empresa.getNombreTitular().equals(""))? mensajeVacio: empresa.getNombreTitular();
        txtNombre.setText(contenido);
        contenido = "Puesto del titular: ";
        contenido += (empresa.getPuestoTitular() == null || empresa.getPuestoTitular().equals(""))? mensajeVacio: empresa.getPuestoTitular();
        txtPuesto.setText(contenido);

    }

    @Override
    public void onResume() {
        super.onResume();
        actualizarEmpresa();
    }

    public void actualizarEmpresa() {
        if(DictamenSingleton.getInstance().getDictamen() == null)
            return;
        this.empresa = DictamenSingleton.getInstance().getDictamen().getEmpresa();
        MostrarDatos();
    }
}
