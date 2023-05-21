package com.example.resitecapp.Alumnos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.resitecapp.administrador.AsignarIntegrantes;
import com.google.android.material.button.MaterialButton;

import com.example.resitecapp.R;
import com.example.resitecapp.tabAdapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class dictamenProyecto extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabAdapter adapter;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager2 = view.findViewById(R.id.viewpager);
        FragmentManager fragmentManager = getChildFragmentManager();
        adapter = new TabAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Empresa"));
        tabLayout.addTab(tabLayout.newTab().setText("Titulares"));
        tabLayout.addTab(tabLayout.newTab().setText("Proyecto"));

        btnAction = view.findViewById(R.id.btnAction);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlumnoDictamen alumnoDictamen = new AlumnoDictamen();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, alumnoDictamen)
                        .addToBackStack(null)
                        .commit();*/
                Context context = getContext();
                Intent intent = new Intent(context, AlumnoDictamen.class);
                startActivity(intent);
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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