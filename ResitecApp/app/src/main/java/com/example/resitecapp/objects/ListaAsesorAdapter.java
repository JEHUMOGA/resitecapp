package com.example.resitecapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resitecapp.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class ListaAsesorAdapter extends  RecyclerView.Adapter<ListaAsesorAdapter.ListaAsesorHolder>{

    private List<Asesor> asesores;
    private LayoutInflater inflater;
    private Context context;
    private OnItemClickListener listener;

    public ListaAsesorAdapter(List<Asesor> asesores, Context context){
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.asesores = asesores;
    }

    public interface OnItemClickListener {
        void onItemClick(Asesor asesor);
    }
    @NonNull
    @Override
    public ListaAsesorAdapter.ListaAsesorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.admin_cardasignarasesor,null);
        return new ListaAsesorAdapter.ListaAsesorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAsesorHolder holder, int position) {
        Asesor asesor = asesores.get(position);
        holder.bind(asesores.get(position));
    }

    @Override
    public int getItemCount() {
        return asesores.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public class ListaAsesorHolder extends RecyclerView.ViewHolder{
        MaterialTextView txtNombreAsesor, txtCorreo;
        public ListaAsesorHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreAsesor = itemView.findViewById(R.id.txtNombreAsesor);
            txtCorreo = itemView.findViewById(R.id.txtCorreo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position == RecyclerView.NO_POSITION){
                            return;
                        }
                        Asesor asesor = asesores.get(position);
                        //btnAdd.setBackgroundResource(R.drawable.ic_add1);
                        listener.onItemClick(asesor);

                    }
                }
            });
        }
        void bind(Asesor asesor){
            System.out.println("Entro en bindData");
            txtNombreAsesor.setText(asesor.getNombre());
            txtCorreo.setText(asesor.getCorreo());
        }
    }
}
