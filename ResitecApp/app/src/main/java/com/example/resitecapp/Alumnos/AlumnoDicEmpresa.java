package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.resitecapp.R;

public class AlumnoDicEmpresa extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_dicempresa);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

        // Verificar si hay fragmentos en la pila de retroceso
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // Si hay fragmentos en la pila, retroceder al fragmento anterior
            fragmentManager.popBackStack();
        } else {
            // Si no hay fragmentos en la pila, realizar el comportamiento de retroceso predeterminado
            super.onBackPressed();
        }
    }
}
