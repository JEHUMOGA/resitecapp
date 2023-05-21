package com.example.resitecapp.administrador;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class AgregarGrupos extends Fragment {
    Button btnAgregar, btnAsignar;
    TextInputEditText nombreEmpresa, rfcEmpresa, calleEmpresa, coloniaEmpresa, codigoPostalEmpresa;
    TextInputEditText ciudadEmpresa, faxEmpresa, telefenoEmpresa, nombreTitularEmpresa, telefonoTitularEmpresa;
    TextInputEditText nombreProyecto, nombreAsesorInterno, acronimoProyecto, nombreAsesorExterno, puestoAsesorExterno;
    TextInputEditText areaAsesorExterno, emailAsesorExterno, telefonoAsesorExterno;
    ScrollView detalleEmpresa, detalleProyecto, detalleAsesorExterno;
    LinearLayout layoutEmpresa, layoutProyecto, layoutAsesorExterno;
    private int band;

    CardView cardEmpresa, cardProyecto, cardAsesorExterno;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_agregargrupos, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detalleEmpresa = view.findViewById(R.id.detalleEmpresas);
        layoutEmpresa = view.findViewById(R.id.layoutEmpresa);
        detalleProyecto = view.findViewById(R.id.detalleProyecto);
        layoutProyecto = view.findViewById(R.id.layoutProyecto);
        detalleAsesorExterno = view.findViewById(R.id.detalleAsesorExterno);
        layoutAsesorExterno = view.findViewById(R.id.layoutAsesorExterno);

        nombreEmpresa = view.findViewById(R.id.txtNombreEmpresa);
        rfcEmpresa = view.findViewById(R.id.txtRFCEmpresa);
        calleEmpresa = view.findViewById(R.id.txtCalleEmpresa);
        coloniaEmpresa = view.findViewById(R.id.txtColoniaEmpresa);
        codigoPostalEmpresa = view.findViewById(R.id.txtCodigoPEmpresa);
        ciudadEmpresa = view.findViewById(R.id.txtCiudadEmpresa);
        faxEmpresa = view.findViewById(R.id.txtFaxEmpresa);
        telefenoEmpresa = view.findViewById(R.id.txtTelefonoEmpresa);
        nombreTitularEmpresa = view.findViewById(R.id.txtNombreTitular);
        telefonoTitularEmpresa = view.findViewById(R.id.txtTelefonoTitularEmpresa);
        nombreProyecto = view.findViewById(R.id.txtnombreProyecto);
        acronimoProyecto = view.findViewById(R.id.txtAcronimo);
        nombreAsesorExterno = view.findViewById(R.id.txtNombreAsesorExt);
        puestoAsesorExterno = view.findViewById(R.id.txtPuestoAsesorExt);
        areaAsesorExterno = view.findViewById(R.id.txtAreaAsesorExt);
        emailAsesorExterno = view.findViewById(R.id.txtEmailAsesorExt);
        telefonoAsesorExterno = view.findViewById(R.id.txtTelefonoAsesorExt);

        cardEmpresa = view.findViewById(R.id.cardEmpresa);
        cardEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(view, layoutEmpresa, detalleEmpresa);
            }
        });

        cardProyecto = view.findViewById(R.id.cardProyecto);
        cardProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(view, layoutProyecto, detalleProyecto);
            }
        });
        cardAsesorExterno = view.findViewById(R.id.cardAsesorExterno);
        cardAsesorExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(view, layoutAsesorExterno, detalleAsesorExterno);
            }
        });

        btnAsignar = view.findViewById(R.id.btnAsignar);
        btnAsignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnAgregar = view.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Nombre: " + nombreEmpresa.getText() + " RFC: " + rfcEmpresa.getText());
                validarVacio(nombreEmpresa);
                validarVacio(rfcEmpresa);
                validarVacio(calleEmpresa);
                validarVacio(coloniaEmpresa);
                validarVacio(codigoPostalEmpresa);
                validarVacio(ciudadEmpresa);
                validarVacio(telefenoEmpresa);
                validarVacio(nombreTitularEmpresa);
                validarVacio(telefonoTitularEmpresa);
                validarVacio(nombreProyecto);
                validarVacio(acronimoProyecto);
                validarVacio(nombreAsesorExterno);
                validarVacio(puestoAsesorExterno);
                validarVacio(areaAsesorExterno);
                validarVacio(emailAsesorExterno);
                validarVacio(telefonoAsesorExterno);
            }
        });
    }

    public void expand(View view, LinearLayout layout, ScrollView detalle) {
        int v = (detalle.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detalle.setVisibility(v);
    }

    public void validarVacio(TextInputEditText edit){
        String text = edit.getText().toString().trim();
        if(text.isEmpty()){
            edit.setError("Campo obligatorio");
            edit.requestFocus();
            band++;
        }
    }

}
