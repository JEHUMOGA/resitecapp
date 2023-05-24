package com.example.resitecapp.Alumnos;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Proyecto;
import com.google.android.material.textfield.TextInputEditText;

public class AlumnoDicProyecto extends AppCompatActivity {

    TextInputEditText titulo, acronimo, tipo, realizacion;
    private Button btnTerminar;
    private Proyecto proyecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dicproyecto);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titulo = findViewById(R.id.txtTitulo);
        acronimo = findViewById(R.id.txtAcronimo);
        tipo = findViewById(R.id.txtTipo);
        realizacion = findViewById(R.id.txtRealizacion);

        btnTerminar = findViewById(R.id.btnTerminar);

        if(DictamenSingleton.getInstance().getDictamen()==null){
            this.proyecto = new Proyecto();
        }
        else {
            this.proyecto= DictamenSingleton.getInstance().getDictamen().getProyecto();
        }

        AsignarValores(proyecto.getTitulo(), titulo);
        AsignarValores(proyecto.getAcronimo(), acronimo);
        AsignarValores(proyecto.getTipo(), tipo);
        AsignarValores(proyecto.getRealizacion(), realizacion);

        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarVacio(titulo);
                validarVacio(acronimo);
                validarVacio(tipo);
                validarVacio(realizacion);

                if(count > 0){
                    return;
                }
                proyecto.setTitulo(titulo.getText().toString());
                proyecto.setAcronimo(acronimo.getText().toString());
                proyecto.setTipo(tipo.getText().toString());
                proyecto.setRealizacion(realizacion.getText().toString());

                DictamenSingleton.getInstance().getDictamen().setProyecto(proyecto);
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
        component.setEnabled(false);
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

}
