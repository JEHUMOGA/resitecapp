package com.example.resitecapp.Alumnos;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.resitecapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class AlumnoDicProyecto extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dicproyecto);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //fechaNacimiento = findViewById(R.id.txtNacimientoEstudiante);
        //fechaNacimiento.setOnClickListener(this);
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

    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fechaNacimiento = view.findViewById(R.id.txtNacimientoEstudiante);
        fechaNacimiento.setOnClickListener(this);
    }*/


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
        newDatePicker.show(getSupportFragmentManager(),"datePicker");
    }

}
