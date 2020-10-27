package com.example.medicell.controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicell.R;
import com.example.medicell.modelo.Diagnostico;

import java.util.List;

public class AdapterLocal extends RecyclerView.Adapter<AdapterLocal.servidorViewHolder> {

    Context context;
    List<Diagnostico> listaLocal;

    public AdapterLocal(Context context, List<Diagnostico> listaLocal) {
        this.context = context;
        this.listaLocal = listaLocal;
    }

    @NonNull
    @Override
    public servidorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_diagnostico, null , false);
        return new AdapterLocal.servidorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull servidorViewHolder holder, int position) {
        holder.tvDiagnostico.setText(listaLocal.get(position).getDiagnostico());
        holder.tvSintomas.setText(listaLocal.get(position).getSintomas_presentados());
        holder.sintoma1.setText(listaLocal.get(position).getSintomas_presentados());
        holder.sintoma2.setText(listaLocal.get(position).getSintomas_presentados());
        holder.sintoma3.setText(listaLocal.get(position).getSintomas_presentados());
        holder.sintoma4.setText(listaLocal.get(position).getSintomas_presentados());
        holder.sintoma5.setText(listaLocal.get(position).getSintomas_presentados());

    }

    @Override
    public int getItemCount() {
        return listaLocal.size();
    }

    public class servidorViewHolder extends RecyclerView.ViewHolder {

        TextView tvSintomas, tvSync, tvDiagnostico, sintoma1, sintoma2, sintoma3, sintoma4, sintoma5;

        public servidorViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDiagnostico = itemView.findViewById(R.id.tvDiagnostico);
            tvSintomas = itemView.findViewById(R.id.tvSintomas);
            tvSync = itemView.findViewById(R.id.tvSync);
            sintoma1 = itemView.findViewById(R.id.sintoma1);
            sintoma2 = itemView.findViewById(R.id.sintoma2);
            sintoma3 = itemView.findViewById(R.id.sintoma3);
            sintoma4 = itemView.findViewById(R.id.sintoma4);
            sintoma5 = itemView.findViewById(R.id.sintoma5);
        }
    }
}
