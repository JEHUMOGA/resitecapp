package com.example.resitecapp.tabAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.resitecapp.Alumnos.FragmentDicTitular;
import com.example.resitecapp.Alumnos.FragmentDictEmpresa;
import com.example.resitecapp.Alumnos.FragmentDictProyecto;

public class TabAdapter extends FragmentStateAdapter {
    public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: {
                return new FragmentDicTitular();
            }
            case 2: {
                return new FragmentDictProyecto();
            }
        }
        return new FragmentDictEmpresa();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
