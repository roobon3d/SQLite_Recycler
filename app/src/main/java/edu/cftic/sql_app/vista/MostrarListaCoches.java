package edu.cftic.sql_app.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.cftic.sql_app.AdapterCoches;
import edu.cftic.sql_app.R;
import edu.cftic.sql_app.dao.BaseDatosCochesPersona;
import edu.cftic.sql_app.dto.Coche;

public class MostrarListaCoches extends AppCompatActivity {

    private BaseDatosCochesPersona baseDatosCochesPersona;


    private RecyclerView recView;
    private ArrayList<Coche> datos;
    private AdapterCoches adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista_coches);

        //creo el objeto de la base de datos
        baseDatosCochesPersona = new BaseDatosCochesPersona(this, "MiDB", null, 1);



        ArrayList<Coche> datos = (ArrayList<Coche>) baseDatosCochesPersona.buscarCoches();
//TODO seguir con el problema

        this.recView = (RecyclerView) findViewById(R.id.RecView);

        adaptador = new AdapterCoches(datos);

        // el adaptador provee los datos
        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));
        //StaggeredGridLayoutManager para celdas de tamaño variable
        //recView.setLayoutManager(new StaggeredGridLayoutManager());

    }
}
