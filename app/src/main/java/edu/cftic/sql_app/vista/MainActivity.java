package edu.cftic.sql_app.vista;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.List;

import edu.cftic.sql_app.R;
import edu.cftic.sql_app.dao.BaseDatosCochesPersona;
import edu.cftic.sql_app.dto.Coche;
import edu.cftic.sql_app.dto.Persona;

public class MainActivity extends AppCompatActivity {


    private BaseDatosCochesPersona baseDatosCochesPersona;

    Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrar = findViewById(R.id.btnMostrarId);
        btnMostrar.setEnabled(false);


    }

    public void cargarDatos(View view) {

        //Button btnMostrar = findViewById(R.id.btnMostrarId);


        //creo el objeto de la base de datos
        baseDatosCochesPersona = new BaseDatosCochesPersona(this, "MiDB", null, 1);

        Persona persona1 = new Persona(1, "Juan");
        Persona persona2 = new Persona(2, "Conchi");
        Persona persona3 = new Persona(3, "Manolo");

        //inserto las personas
        baseDatosCochesPersona.insertarPersona(persona1);
        baseDatosCochesPersona.insertarPersona(persona2);
        baseDatosCochesPersona.insertarPersona(persona3);

        Coche coche1 = new Coche("Ferrari", persona2);
        Coche coche2 = new Coche("Renault", persona2);
        Coche coche3 = new Coche("Fiat", persona1);

        //inserto los coches
        baseDatosCochesPersona.insertarCoche(coche1);
        baseDatosCochesPersona.insertarCoche(coche2);
        baseDatosCochesPersona.insertarCoche(coche3);


        btnMostrar.setEnabled(true);


    }

    public void mostrarDatos(View view) {



        Intent intent = new Intent(this, MostrarListaCoches.class);
        startActivity(intent);

        //Log.d(getClass().getCanonicalName(), "Los coches de " + persona2.getNombre() + " son :");



        /*for (int contador=0;contador<listacoches.size();contador++){

            Coche coche = listacoches.get(contador);

        }*/

        // ********** Haciendolo con for each *********
        /*for (Coche coche: listacoches)
        {

            Log.d(getClass().getCanonicalName(), coche.getModelo());
        }*/
    }



}
