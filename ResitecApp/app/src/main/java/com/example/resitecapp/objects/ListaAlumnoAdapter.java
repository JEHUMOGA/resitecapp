package com.example.resitecapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resitecapp.R;
import com.example.resitecapp.interfaces.RecyclerViewPosition;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class ListaAlumnoAdapter extends RecyclerView.Adapter<ListaAlumnoAdapter.ListaAlumnoHolder> {
    private List<Alumno> listaAlumno;
    private OnItemClickListener listener;
    private LayoutInflater inflater;
    RecyclerViewPosition recyclerViewAlumno;
    public ListaAlumnoAdapter(List<Alumno> listaAlumno, Context context){
        this.inflater = LayoutInflater.from(context);
        this.listaAlumno = listaAlumno;
    }

    @NonNull
    @Override
    public ListaAlumnoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.admin_cardasignaralumno, null);
        return new ListaAlumnoAdapter.ListaAlumnoHolder(itemView,recyclerViewAlumno);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAlumnoHolder holder, int position) {
        Alumno alumno = listaAlumno.get(position);
        holder.bind(alumno);

    }
    @Override
    public int getItemCount() {
        return listaAlumno.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(Alumno alumno);
    }

    public class ListaAlumnoHolder extends RecyclerView.ViewHolder{
        private MaterialTextView txtNombreAlumno;
        private MaterialTextView txtCorreoAlumno;
        private Button btnAdd, btnDrop;
        public ListaAlumnoHolder(@NonNull View itemView, RecyclerViewPosition recyclerViewAlumno) {
            super(itemView);
            txtNombreAlumno = itemView.findViewById(R.id.txtNombreAlumno);
            txtCorreoAlumno = itemView.findViewById(R.id.txtCorreo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position == RecyclerView.NO_POSITION){
                            return;
                        }
                        Alumno alumno = listaAlumno.get(position);
                        listener.onItemClick(alumno);

                    }
                }
            });
        }
        public void bind(Alumno alumno){
            txtNombreAlumno.setText(alumno.getNombre());
            txtCorreoAlumno.setText(alumno.getCorreoInstitucional());

        }
    }
}
