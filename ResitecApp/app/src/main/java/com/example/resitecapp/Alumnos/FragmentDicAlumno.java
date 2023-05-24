package com.example.resitecapp.Alumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resitecapp.R;
import com.example.resitecapp.objects.Alumno;
import com.example.resitecapp.objects.DictamenSingleton;
import com.example.resitecapp.objects.Empresa;
import com.google.android.material.textview.MaterialTextView;

public class FragmentDicAlumno extends Fragment {
    MaterialTextView txtNombre, txtApePaterno, txtApeMat, txtNumeroControl, txtFechaNacimiento, txtCalle, txtColonia, txtCodigoPostal;
    MaterialTextView txtCiudad, txtPais, txtNss, txtTipoSeguro, txtSexo, txtCorreoPersonal, txtTelefenoPersonal, txtTelefonoCasa, txtCorrioInstitucional;

    MaterialTextView titulo;

    ScrollView info;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dicalumno, container, false);
    }
    private Alumno alumno;
    public FragmentDicAlumno(Alumno alumno){
        this.alumno = alumno;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(DictamenSingleton.getInstance().getDictamen() == null) {
            this.alumno = new Alumno();
        }else {
            this.alumno = DictamenSingleton.getInstance().getDictamen().getAlumno();
        }
        titulo = view.findViewById(R.id.titulo);

        txtNumeroControl = view.findViewById(R.id.txtNumeroControl);
        txtNombre = view.findViewById(R.id.txtNombre);
        txtApePaterno = view.findViewById(R.id.txtApePat);
        txtApeMat = view.findViewById(R.id.txtApeMat);
        txtFechaNacimiento = view.findViewById(R.id.txtFechaNacimineto);
        txtCalle = view.findViewById(R.id.txtCalle);
        txtColonia = view.findViewById(R.id.txtColonia);
        txtCodigoPostal = view.findViewById(R.id.txtCodigoPostal);
        txtCiudad = view.findViewById(R.id.txtCiudad);
        txtPais = view.findViewById(R.id.txtPais);
        txtNss = view.findViewById(R.id.txtNSS);
        txtTipoSeguro = view.findViewById(R.id.txtTipoSeguro);
        txtSexo = view.findViewById(R.id.txtSexo);
        txtCorreoPersonal = view.findViewById(R.id.txtCorreoPersonal);
        txtTelefenoPersonal = view.findViewById(R.id.txtTelefonoPersonal);
        txtTelefonoCasa = view.findViewById(R.id.txtTelefonoCasa);
        txtCorrioInstitucional = view.findViewById(R.id.txtCorreoInstitucional);
        info = view.findViewById(R.id.info);
        MostrarDatos();
    }

    private String mensajeVacio;

    public void MostrarDatos(){

        if(this.alumno == null){
            titulo.setText("Sin datos de alumno");
            return;
        }
        info.setVisibility(View.VISIBLE);
        mensajeVacio = "Falta agregar";
        String contenido = null;

        contenido = "Número de control: ";
        contenido += (alumno.getNumerodecontrol() == null || alumno.getNumerodecontrol().equals(""))?  mensajeVacio:  alumno.getNumerodecontrol();
        txtNumeroControl.setText(contenido);

        contenido = "Nombre: ";
        contenido += (alumno.getNombre() == null || alumno.getNombre().equals(""))?  mensajeVacio:  alumno.getNombre();
        txtNombre.setText(contenido);
        contenido = "Apellido Paterno: ";
        contenido += (alumno.getApePat() == null || alumno.getApePat().equals(""))? mensajeVacio: alumno.getApePat();
        txtApePaterno.setText(contenido);
        contenido = "Apellido Materno: ";
        contenido += (alumno.getApeMat() == null || alumno.getApeMat().equals(""))? mensajeVacio:  alumno.getApeMat();
        txtApeMat.setText(contenido);
        contenido = "Fecha de Nacimiento: ";
        contenido += (alumno.getFechaNacimiento() == null || alumno.getFechaNacimiento().equals(""))? mensajeVacio:  alumno.getFechaNacimiento();
        txtFechaNacimiento.setText(contenido);
        contenido = "Domicilio: ";
        contenido += (alumno.getDomicilioCalle() == null || alumno.getDomicilioCalle().equals(""))? mensajeVacio:  alumno.getDomicilioCalle();
        txtCalle.setText(contenido);
        contenido = "Colonia: ";
        contenido += (alumno.getDomicilioColonia() == null || alumno.getDomicilioColonia().equals(""))? mensajeVacio:  alumno.getDomicilioColonia();
        txtColonia.setText(contenido);
        contenido = "Codigo Postal: ";
        contenido += (alumno.getDomicilioCp() == null || alumno.getDomicilioCp().equals(""))? mensajeVacio:  alumno.getDomicilioCp();
        txtCodigoPostal.setText(contenido);
        contenido = "Ciudad: ";
        contenido += (alumno.getCiudad() == null || alumno.getCiudad().equals(""))? mensajeVacio:  alumno.getCiudad();
        txtCiudad.setText(contenido);
        contenido = "País: ";
        contenido += (alumno.getPais() == null || alumno.getPais().equals(""))? mensajeVacio:  alumno.getPais();
        txtPais.setText(contenido);
        contenido = "País: ";
        contenido += (alumno.getPais() == null || alumno.getPais().equals(""))? mensajeVacio:  alumno.getPais();
        txtPais.setText(contenido);
        contenido = "Número de seguro social: ";
        contenido += (alumno.getNss() == null || alumno.getNss().equals(""))? mensajeVacio:  alumno.getNss();
        txtNss.setText(contenido);
        contenido = "Tipo de Seguro: ";
        contenido += (alumno.getTipoSeguro() == null || alumno.getTipoSeguro().equals(""))? mensajeVacio:  alumno.getTipoSeguro();
        txtTipoSeguro.setText(contenido);
        contenido = "Sexo: ";
        contenido += (alumno.getSexo() == null || alumno.getSexo().equals(""))? mensajeVacio:  alumno.getSexo();
        txtSexo.setText(contenido);
        contenido = "Correo Personal: ";
        contenido += (alumno.getCorreoPersonal() == null || alumno.getCorreoPersonal().equals(""))? mensajeVacio:  alumno.getCorreoPersonal();
        txtCorreoPersonal.setText(contenido);
        contenido = "Telefono Personal: ";
        contenido += (alumno.getTelefonoPersonal() == null || alumno.getTelefonoPersonal().equals(""))? mensajeVacio:  alumno.getTelefonoPersonal();
        txtTelefenoPersonal.setText(contenido);
        contenido = "Telefono de Casa: ";
        contenido += (alumno.getTelefonoCasa() == null || alumno.getTelefonoCasa().equals(""))? mensajeVacio:  alumno.getTelefonoCasa();
        txtTelefonoCasa.setText(contenido);

        contenido = "Correo Institucional: ";
        contenido += (alumno.getCorreoInstitucional() == null || alumno.getCorreoInstitucional().equals(""))? mensajeVacio:  alumno.getCorreoInstitucional();
        txtCorrioInstitucional.setText(contenido);

    }

    @Override
    public void onResume() {
        super.onResume();
        actualizarAlumno();
    }

    public void actualizarAlumno() {
        if(DictamenSingleton.getInstance().getDictamen() == null)
            return;
        this.alumno = DictamenSingleton.getInstance().getDictamen().getAlumno();
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Fecha de Nacimiento" + alumno.getFechaNacimiento());
        MostrarDatos();
    }

}
