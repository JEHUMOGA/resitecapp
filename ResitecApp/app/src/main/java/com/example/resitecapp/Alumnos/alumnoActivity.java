package com.example.resitecapp.Alumnos;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.MainActivity;
import com.example.resitecapp.R;
import com.example.resitecapp.administrador.AdministradorActivity;
import com.example.resitecapp.administrador.AgregarGrupos;
import com.example.resitecapp.administrador.AsignarIntegrantes;
import com.google.android.material.navigation.NavigationView;

public class alumnoActivity extends AppCompatActivity {
    NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        navigationView=findViewById(R.id.navigationView);
        drawer=findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(alumnoActivity.this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        dictamenProyecto alumnoDictamen = new dictamenProyecto();
        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        bundle.putString("correo", intent.getStringExtra("correo"));
        alumnoDictamen.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,alumnoDictamen).commit();
        navigationView.setCheckedItem(R.id.nav_item_proyecto);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_item_proyecto:
                        dictamenProyecto alumnoDictamen = new dictamenProyecto();
                        Bundle bundle = new Bundle();
                        Intent intent = getIntent();
                        bundle.putString("correo", intent.getStringExtra("correo"));
                        alumnoDictamen.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,alumnoDictamen).commit();
                        break;
                    case R.id.nav_admin_grupos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AdministradorActivity()).commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            onBackPressed();
        }
    }
}
