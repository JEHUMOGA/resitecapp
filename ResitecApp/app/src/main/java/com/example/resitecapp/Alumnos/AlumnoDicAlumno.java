package com.example.resitecapp.Alumnos;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.DictamenSingleton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlumnoDicAlumno extends AppCompatActivity {

    TextInputEditText fechaNacimiento, numeroControl, nombre, apePat, apeMat, domicilioCalle, domicilioColonia;
    TextInputEditText domicilioCp, ciudad, pais, numeroSeguroSocial, tipoSeguro, sexo, correoPersonal, telefonoPersonal;
    TextInputEditText telefonoCasa, correoInstitucional;

    Button btnTerminar;

    private Alumno alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dicalumno);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        numeroControl = findViewById(R.id.txtNoControl);
        nombre = findViewById(R.id.txtNombreEstudiante);
        apePat = findViewById(R.id.txtApePat);
        apeMat = findViewById(R.id.txtApeMat);
        domicilioCalle = findViewById(R.id.txtCalle);
        domicilioColonia = findViewById(R.id.txtColonia);
        domicilioCp = findViewById(R.id.txtCodigoPostal);
        ciudad = findViewById(R.id.txtCiudad);
        pais = findViewById(R.id.txtPais);
        numeroSeguroSocial = findViewById(R.id.txtNumeroSeguroSocial);
        tipoSeguro = findViewById(R.id.txtTipoSeguro);
        sexo = findViewById(R.id.txtSexo);
        correoPersonal = findViewById(R.id.txtCorreoPersonal);
        telefonoPersonal = findViewById(R.id.txtTelefonoPersonal);
        telefonoCasa = findViewById(R.id.txtTelefonoCasa);
        correoInstitucional = findViewById(R.id.txtCorreoInstuticional);
        fechaNacimiento = findViewById(R.id.txtNacimientoEstudiante);
        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        if(DictamenSingleton.getInstance().getDictamen() == null) {
            this.alumno = new Alumno();
        }else {
            this.alumno = DictamenSingleton.getInstance().getDictamen().getAlumno();
        }

        AsignarValores(alumno.getNombre(), nombre);
        AsignarValores(alumno.getApePat(), apePat);
        AsignarValores(alumno.getApeMat(), apeMat);
        AsignarValores(alumno.getNumerodecontrol() +"", numeroControl);
        AsignarValores(alumno.getDomicilioCalle(), domicilioCalle);
        AsignarValores(alumno.getDomicilioColonia(), domicilioColonia);
        AsignarValores(alumno.getDomicilioCp() + "", domicilioCp);
        AsignarValores(alumno.getCiudad(), ciudad);
        AsignarValores(alumno.getPais(), pais);
        AsignarValores(alumno.getNss() + "", numeroSeguroSocial);
        AsignarValores(alumno.getTipoSeguro(), tipoSeguro);
        AsignarValores(alumno.getSexo(), sexo);
        AsignarValores(alumno.getCorreoPersonal(), correoPersonal);
        AsignarValores(alumno.getTelefonoPersonal(), telefonoPersonal);
        AsignarValores(alumno.getTelefonoCasa(), telefonoCasa);
        AsignarValores(alumno.getCorreoInstitucional(), correoInstitucional);
        AsignarValores(alumno.getFechaNacimiento(), fechaNacimiento);

        btnTerminar = findViewById(R.id.btnTerminar);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarVacio(nombre);
                validarVacio(apePat);
                validarVacio(apeMat);
                validarVacio(numeroControl);
                validarVacio(domicilioCalle);
                validarVacio(domicilioColonia);
                validarVacio(domicilioCp);
                validarVacio(ciudad);
                validarVacio(pais);
                validarVacio(numeroSeguroSocial);
                validarVacio(tipoSeguro);
                validarVacio(sexo);
                validarVacio(correoPersonal);
                validarVacio(telefonoPersonal);
                validarVacio(telefonoCasa);
                validarVacio(correoInstitucional);
                validarVacio(fechaNacimiento);

                if(count > 0){
                    return;
                }
                GuardarDatos();
                onBackPressed();
            }
        });
    }

    public void GuardarDatos(){
        alumno.setNombre(nombre.getText().toString());
        alumno.setApePat(apePat.getText().toString());
        alumno.setApeMat(apeMat.getText().toString());
        alumno.setNumerodecontrol(Integer.parseInt(numeroControl.getText().toString()));
        alumno.setDomicilioCalle(domicilioCalle.getText().toString());
        alumno.setDomicilioColonia(domicilioColonia.getText().toString());
        alumno.setDomicilioCp(Integer.parseInt(domicilioCp.getText().toString()));
        alumno.setCiudad(ciudad.getText().toString());
        alumno.setPais(pais.getText().toString());
        alumno.setNss(Integer.parseInt(numeroSeguroSocial.getText().toString()));
        alumno.setTipoSeguro(tipoSeguro.getText().toString());
        alumno.setSexo(sexo.getText().toString());
        alumno.setCorreoPersonal(correoPersonal.getText().toString());
        alumno.setTelefonoPersonal(telefonoPersonal.getText().toString());
        alumno.setTelefonoCasa(telefonoCasa.getText().toString());
        alumno.setCorreoInstitucional(correoInstitucional.getText().toString());
        alumno.setFechaNacimiento(fechaNacimiento.getText().toString());

        DictamenSingleton.getInstance().getDictamen().setAlumno(alumno);

    }

    private void showDatePickerDialog(){
        DatePickerFragment newDatePicker = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                //final String selectedDate = year+" - " + (month+1) + " - " + day ;
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                String formatDate = simpleDateFormat.format(calendar.getTime());
                fechaNacimiento.setText(formatDate);
            }
        });
        newDatePicker.show(getSupportFragmentManager(),"datePicker");
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
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

}
