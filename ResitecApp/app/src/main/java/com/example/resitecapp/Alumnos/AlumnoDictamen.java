package com.example.resitecapp.Alumnos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.resitecapp.R;
import com.example.resitecapp.controller.DictamenController;
import com.example.resitecapp.interfaces.CallbackSimple;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.Dictamen;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Empresa;
import com.example.resitecapp.objects.Proyecto;

public class AlumnoDictamen extends AppCompatActivity {
    private Dictamen dictamen;

    private Alumno alumno;
    private Empresa empresa;
    private Proyecto proyecto;
    private AsesorExterno asesorExterno;

    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dictamen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cardEmpresa, cardProyecto, cardAsesores, cardAlumno;
        cardEmpresa = findViewById(R.id.cardEmpresa);
        cardProyecto = findViewById(R.id.cardProyecto);
        cardAsesores = findViewById(R.id.cardAsesores);
        cardAlumno = findViewById(R.id.cardAlumno);

        dictamen = DictamenSingleton.getInstance().getDictamen();
        btnGuardar = findViewById(R.id.btnGuardar);


        cardEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AlumnoDicEmpresa.class);
                startActivity(intent);
            }
        });
        cardProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AlumnoDicProyecto.class);
                startActivity(intent);
            }
        });

        cardAsesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AlumnoDicAsesorExterno.class);
                startActivity(intent);
            }
        });
        cardAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AlumnoDicAlumno.class);
                startActivity(intent);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dictamen = DictamenSingleton.getInstance().getDictamen();

                DictamenController dictamenController = new DictamenController();

                dictamenController.sendDictamen(dictamen, new CallbackSimple<Dictamen>() {
                    @Override
                    public void onSuccess(Dictamen callback) {
                        Toast.makeText(AlumnoDictamen.this, "Informacion guardada correctamente", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String mensaje) {
                        Toast.makeText(AlumnoDictamen.this, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });

                onBackPressed();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            DictamenSingleton.getInstance().setDictamen(dictamen);
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
