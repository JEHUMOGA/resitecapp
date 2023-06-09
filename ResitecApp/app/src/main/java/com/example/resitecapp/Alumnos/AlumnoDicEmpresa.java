package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Empresa;
import com.google.android.material.textfield.TextInputEditText;

public class AlumnoDicEmpresa extends AppCompatActivity {
    TextInputEditText lugar, rfc, giro, calle, colonia, codigoPostal, ciudad, fax, telefono, telefonoExt;
    TextInputEditText nombreTitular, puestoTitular;

    private Empresa empresa;

    private Button btnTerminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dicempresa);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lugar = findViewById(R.id.txtNombreEmpresa);
        rfc = findViewById(R.id.txtRFCEmpresa);
        giro = findViewById(R.id.txtGiro);
        calle = findViewById(R.id.txtCalleEmpresa);
        colonia = findViewById(R.id.txtColoniaEmpresa);
        codigoPostal = findViewById(R.id.txtCodigoPEmpresa);
        ciudad = findViewById(R.id.txtCiudadEmpresa);
        telefono = findViewById(R.id.txtTelefonoEmpresa);
        telefonoExt = findViewById(R.id.txtTelefonoExt);
        nombreTitular = findViewById(R.id.txtNombreTitular);
        puestoTitular = findViewById(R.id.txtPuestoTitular);

        if(DictamenSingleton.getInstance().getDictamen() == null){
            this.empresa = new Empresa();
        }else {
            this.empresa = DictamenSingleton.getInstance().getDictamen().getEmpresa();
        }
        AsignarValores(empresa.getLugar(), lugar);
        AsignarValores(empresa.getRfc(), rfc);
        AsignarValores(empresa.getGiro(), giro);

        AsignarValores(empresa.getColonia(), colonia);
        AsignarValores(empresa.getCodigoPostal(), codigoPostal);
        AsignarValores(empresa.getCiudad(), ciudad);
        AsignarValores(empresa.getTelefono(), telefono);
        AsignarValores(empresa.getTelefonoExtension(), telefonoExt);
        AsignarValores(empresa.getNombreTitular(), nombreTitular);
        AsignarValores(empresa.getPuestoTitular(), puestoTitular);
        btnTerminar = findViewById(R.id.btnTerminar);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarVacio(lugar);
                validarVacio(rfc);
                validarVacio(giro);
                validarVacio(calle);
                validarVacio(colonia);
                validarVacio(codigoPostal);
                validarVacio(ciudad);
                validarVacio(telefono);
                validarVacio(nombreTitular);
                validarVacio(puestoTitular);

                if(count > 0){
                    return;
                }
                empresa.setLugar(lugar.getText().toString());
                empresa.setRfc(rfc.getText().toString());
                empresa.setGiro(giro.getText().toString());
                empresa.setDomicilio(calle.getText().toString());
                empresa.setColonia(colonia.getText().toString());
                empresa.setCodigoPostal(codigoPostal.getText().toString());
                empresa.setCiudad(ciudad.getText().toString());
                empresa.setTelefono(telefono.getText().toString());
                empresa.setNombreTitular(nombreTitular.getText().toString());
                empresa.setPuestoTitular(puestoTitular.getText().toString());

                DictamenSingleton.getInstance().getDictamen().setEmpresa(empresa);
                onBackPressed();
            }
        });


    }

    private int count;
    public void validarVacio(TextInputEditText edit){
        count = 0;
        String text = edit.getText().toString().trim();
        if(text.isEmpty()){
            edit.setError("Campo obligatorio");
            edit.requestFocus();
            count++;
        }
    }

    public void AsignarValores(String info, TextInputEditText component){
        if(info == null || info.isEmpty()){
            component.setText("");
            return;
        }
        component.setText(info);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
