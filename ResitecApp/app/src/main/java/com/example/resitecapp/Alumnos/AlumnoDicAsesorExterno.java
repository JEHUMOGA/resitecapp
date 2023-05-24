package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.DictamenSingleton;
import com.google.android.material.textfield.TextInputEditText;


public class AlumnoDicAsesorExterno extends AppCompatActivity {
    private TextInputEditText nombre, puesto, area, email, telefono;
    private Button btnTerminar;

    private AsesorExterno asesorExterno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dicasesorexterno);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = findViewById(R.id.txtNombreAsesorExt);
        puesto = findViewById(R.id.txtPuestoExterno);
        area = findViewById(R.id.txtArea);
        email = findViewById(R.id.txtCorreoAsesorExt);
        telefono = findViewById(R.id.txtTelefono);

        if(DictamenSingleton.getInstance().getDictamen() == null) {
            this.asesorExterno = new AsesorExterno();
        }else {
            this.asesorExterno = DictamenSingleton.getInstance().getDictamen().getAsesorExterno();
        }
        AsignarValores(asesorExterno.getNombre(), nombre);
        AsignarValores(asesorExterno.getPuesto(), puesto);
        AsignarValores(asesorExterno.getArea(), area);
        AsignarValores(asesorExterno.getEmail(), email);
        AsignarValores(asesorExterno.getTelefono(), telefono);

        btnTerminar = findViewById(R.id.btnTerminar);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarVacio(nombre);
                validarVacio(puesto);
                validarVacio(area);
                validarVacio(email);
                validarVacio(telefono);

                if(count > 0){
                    return;
                }

                asesorExterno.setNombre(nombre.getText().toString());
                asesorExterno.setPuesto(puesto.getText().toString());
                asesorExterno.setArea(area.getText().toString());
                asesorExterno.setEmail(email.getText().toString());
                asesorExterno.setTelefono(telefono.getText().toString());

                DictamenSingleton.getInstance().getDictamen().setAsesorExterno(asesorExterno);
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
