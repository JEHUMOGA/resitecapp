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
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentInicio()).commit();
        navigationView.setCheckedItem(R.id.nav_item_inicio);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_item_inicio:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentInicio()).commit();
                        break;
                    case R.id.nav_item_proyecto:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new dictamenProyecto()).commit();
                        break;
                    case R.id.nav_item_documentos:
                        //Toast.makeText(this, "Documentos", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_admin_grupos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AdministradorActivity()).commit();
                        break;
                    case R.id.nav_admin_alumnos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AsignarIntegrantes()).commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        /*Toolbar toolbar = findViewById(R.id.toolbar_usuario);
        this.setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            onBackPressed();
        }
    }
    /*
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(toogle.onOptionsItemSelected(item)){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }*/
}
