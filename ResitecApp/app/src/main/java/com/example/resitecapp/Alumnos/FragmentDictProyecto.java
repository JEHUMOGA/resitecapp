package com.example.resitecapp.Alumnos;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentDictProyecto extends Fragment implements View.OnClickListener {

    TextInputEditText fechaNacimiento;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dictproyecto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fechaNacimiento = view.findViewById(R.id.txtNacimientoEstudiante);
        fechaNacimiento.setOnClickListener(this);
    }


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
        newDatePicker.show(getActivity().getSupportFragmentManager(),"datePicker");
    }
}
