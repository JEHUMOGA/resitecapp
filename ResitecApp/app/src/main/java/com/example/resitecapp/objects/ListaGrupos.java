package com.example.resitecapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resitecapp.R;
import com.example.resitecapp.interfaces.RecyclerViewPosition;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class ListaGrupos extends RecyclerView.Adapter<ListaGrupos.ViewHolder> {
    private List<Grupo> grupos;
    private LayoutInflater inflater;
    private Context context;
    private OnItemClickListener listener;
    private final RecyclerViewPosition recyclerViewGrupo;

    public ListaGrupos(List<Grupo> itemList, Context context, RecyclerViewPosition recyclerViewGrupo){
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.grupos = itemList;
        this.recyclerViewGrupo = recyclerViewGrupo;

    }

    @NonNull
    @Override
    public ListaGrupos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grupo_administrador,null);

        return new ListaGrupos.ViewHolder(view, recyclerViewGrupo);
    }

    @Override
    public void onBindViewHolder( ListaGrupos.ViewHolder holder, int position) {
        final Grupo grupo = grupos.get(position);
        holder.bindData(grupos.get(position));
    }

    @Override
    public int getItemCount() {
        return grupos.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView txtTituloProyecto;
        MaterialTextView txtAcronimo;
        MaterialTextView txtAsesor;
        CardView cardView;

        ViewHolder(View itemView, RecyclerViewPosition recyclerViewGrupo){
            super(itemView);
            txtTituloProyecto = itemView.findViewById(R.id.txtTituloProyecto);
            txtAcronimo = itemView.findViewById(R.id.txtAcronimo);
            txtAsesor = itemView.findViewById(R.id.txtAsesor);
            cardView = itemView.findViewById(R.id.cardGrupo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewGrupo != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewGrupo.onItemClick(pos);
                        }
                    }
                }
            });
        }

        void bindData(final Grupo grupo){
            System.out.println("Entro en bindData");
            txtTituloProyecto.setText(grupo.getNomProyecto());
            txtAcronimo.setText(grupo.getAcronimoProyecto());
            txtAsesor.setText(grupo.getAsesor().getNombre());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Grupo grupo);
    }

}
