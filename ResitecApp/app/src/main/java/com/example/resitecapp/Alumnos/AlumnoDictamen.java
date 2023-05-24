package com.example.resitecapp.Alumnos;

import android.content.Context;
import android.content.Intent;
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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.Dictamen;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Empresa;
import com.example.resitecapp.objects.Proyecto;

public class AlumnoDictamen extends AppCompatActivity {
    /*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alumno_dictamen, container, false);
        return view;
    }
*/
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

                System.out.println("Correo Insitucional: " + dictamen.getAlumno().getCorreoInstitucional());
                System.out.println("Nombre: " + dictamen.getAlumno().getNombre());
                dictamen = DictamenSingleton.getInstance().getDictamen();

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
