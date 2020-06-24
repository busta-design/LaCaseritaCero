package com.andresbustamante.lacaseritacero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListItemClick{

    private RecyclerView mainRecyclerView;
    ArrayList<String> listaDatos;
    //private static final int LISTA_NUMEROS = 100;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); //cambio del splashscreen

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRecyclerView = findViewById(R.id.mainrecyclerview);
        mainRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //es la linea de division
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));// uno de los tres Linear, Grid, StaggeredGrid
        //mainRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listaDatos = new ArrayList<String>();
        llenarListaDatos();


        //llamamos al adaptador
        RecyclerAdapter adapter = new RecyclerAdapter(listaDatos, this);
        mainRecyclerView.setAdapter(adapter);

        //debemos agregar la imagen a medias



    }

    @Override
    public void onListItemClick(int clickedItem) {
        if (toast != null) {
            toast.cancel();
        }
        String mensajeToast = "item #"+ clickedItem + " clickado";
        toast = Toast.makeText(this, mensajeToast, Toast.LENGTH_SHORT);
        toast.show();


    }

    public void llenarListaDatos() {
        listaDatos.add("Carne");
        listaDatos.add("Pollo");
        listaDatos.add("Tomate");
        listaDatos.add("Lechuga");
        listaDatos.add("Apio");
        listaDatos.add("Chorizo");
        listaDatos.add("Veterraga");
        listaDatos.add("Fideo");
        listaDatos.add("Cerdo");
        listaDatos.add("Papa");
        listaDatos.add("Arberja");
        listaDatos.add("Salchicha");
        listaDatos.add("Hamburguesa");
        listaDatos.add("Chuleta");
        listaDatos.add("Costilla");
        listaDatos.add("Morron");
        listaDatos.add("Frijol ");


    }

}
