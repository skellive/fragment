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

public class AdapterServidor extends RecyclerView.Adapter<AdapterServidor.servidorViewHolder> {

    Context context;
    List<Diagnostico> listaServidor;

    public AdapterServidor(Context context, List<Diagnostico> listaServidor) {
        this.context = context;
        this.listaServidor = listaServidor;
    }

    @NonNull
    @Override
    public servidorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_diagnostico, null, false);
        return new AdapterServidor.servidorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull servidorViewHolder holder, int position) {
        holder.tvProducto.setText(listaServidor.get(position).getDiagnostico());
        holder.tvPrecio.setText(listaServidor.get(position).getSintomas_presentados());

    }

    @Override
    public int getItemCount() {
        return listaServidor.size();
    }

    public class servidorViewHolder extends RecyclerView.ViewHolder {

        TextView tvProducto, tvPrecio;

        public servidorViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProducto = itemView.findViewById(R.id.tvDiagnostico);
            tvPrecio = itemView.findViewById(R.id.tvSintomas);
        }
    }
}
