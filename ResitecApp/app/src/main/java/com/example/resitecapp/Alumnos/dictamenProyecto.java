package com.example.resitecapp.Alumnos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.resitecapp.administrador.AsignarIntegrantes;
import com.example.resitecapp.controller.DictamenController;
import com.example.resitecapp.interfaces.CallbackSimple;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.AsesorExterno;
import com.example.resitecapp.objects.CorreoInstitucional;
import com.example.resitecapp.objects.Dictamen;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Empresa;
import com.example.resitecapp.objects.Proyecto;
import com.google.android.material.button.MaterialButton;

import com.example.resitecapp.R;
import com.example.resitecapp.tabAdapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class dictamenProyecto extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabAdapter adapter;

    private Dictamen dictamen;
    private Button btnAction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dictamen_proyecto, container, false);
    }

    public void obtenerDictamen(){
        DictamenController dictamenController = new DictamenController();
        CorreoInstitucional correoInstitucional = new CorreoInstitucional("17171436@itculiacan.edu.mx");

        dictamenController.getDictamen(correoInstitucional, new CallbackSimple<Dictamen>() {
            @Override
            public void onSuccess(Dictamen callback) {
                //dictamen = callback;
                //asignaDictamen(callback);
                FragmentManager fragmentManager = getChildFragmentManager();
                DictamenSingleton.getInstance().setDictamen(callback);
                adapter = new TabAdapter(fragmentManager, getLifecycle(), callback);
                viewPager2.setAdapter(adapter);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = getContext();
                        Intent intent = new Intent(context, AlumnoDictamen.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(String mensaje) {
                Toast.makeText(dictamenProyecto.this.getContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager2 = view.findViewById(R.id.viewpager);

        btnAction = view.findViewById(R.id.btnAction);

        obtenerDictamen();
        dictamen = DictamenSingleton.getInstance().getDictamen();
        if(dictamen == null){
            System.out.println("Dictamen nulo");
        }


        tabLayout.addTab(tabLayout.newTab().setText("Empresa"));
        tabLayout.addTab(tabLayout.newTab().setText("Asesor"));
        tabLayout.addTab(tabLayout.newTab().setText("Proyecto"));
        tabLayout.addTab(tabLayout.newTab().setText("Alumno"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.println("Selecciona tab");

                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}