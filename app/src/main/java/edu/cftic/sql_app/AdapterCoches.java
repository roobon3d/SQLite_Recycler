package edu.cftic.sql_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.cftic.sql_app.dto.Coche;


// esta clase provee los datos al reciclerView

public class AdapterCoches extends RecyclerView.Adapter<CochesViewHolder> {


    private ArrayList<Coche> datos;


    //Creo la vista, con el Holder dentro
    //Aqui se crea cada elemento de la lista

    //  onCreateViewHolder crea la caja donde iran los datos
    @Override
    public CochesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CochesViewHolder cocheViewHolder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.layout_coche_item, parent, false);

        cocheViewHolder = new CochesViewHolder(itemView);

        return cocheViewHolder;
    }

    //Al holder, le meto la info de libro que toca
    //  onBindViewHolder rellena con los datos

    @Override
    public void onBindViewHolder(CochesViewHolder holder, int position) {

        Coche coche = datos.get(position);
        holder.cargarCocheEnHolder(coche);

    }


    //para saber cuantos coches tenemos
    @Override
    public int getItemCount() {
        return datos.size();
    }


    // para guardar la lista de libros
    public AdapterCoches(ArrayList<Coche> coches)
    {
        this.datos = coches;
    }
}
