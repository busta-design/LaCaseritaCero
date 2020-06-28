package com.andresbustamante.lacaseritacero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListItemClick{

    private RecyclerView mainRecyclerView;
    ArrayList<Pojo> listaDatos;
    private Toast toast;

    FloatingActionButton floatingActionButton;
    private boolean noVolverAMostrar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); //cambio del splashscreen

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRecyclerView = findViewById(R.id.mainrecyclerview);
        mainRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //es la linea de division
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));// uno de los tres Linear, Grid, StaggeredGrid
        //mainRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listaDatos = new ArrayList<Pojo>();
        llenarListaDatos();


        //llamamos al adaptador
        RecyclerAdapter adapter = new RecyclerAdapter(listaDatos, this);
        mainRecyclerView.setAdapter(adapter);

        //El boton flotante
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noVolverAMostrar == false) {

                    //Agregamos una alerta para comprobar si quiere agregar un elemento a su lista
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    //En las alertas se pueden agregar Drawables en lugar de palabras
                    alerta//.setMessage("¿Desea agregar alimentos a su lista?")
                            .setCancelable(true)
                            .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    //poner el intent
                                }
                            })
                            .setNeutralButton("Si, no volver a preguntar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    noVolverAMostrar = true;
                                    dialog.cancel();
                                    //poner el intent y cambiar "noVolverAMostrar" = true
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();

                                }
                            });
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("¿Desea agregar alimentos a su lista?");
                    titulo.show();
                }else{
                    //poner el intent
                }

            }
        });




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
        listaDatos.add(new Pojo (getString(R.string.res), "1/4 libra", R.mipmap.carne_de_res));//
        listaDatos.add(new Pojo (getString(R.string.cerdo), "1/4 arroba", R.mipmap.carne_de_cerdo));
        listaDatos.add(new Pojo (getString(R.string.pollo), "1/2 kilo", R.mipmap.pollo));
        listaDatos.add(new Pojo (getString(R.string.pepino), "1/3 libra", R.mipmap.pepino));
        listaDatos.add(new Pojo (getString(R.string.salchicha), "1/4 arroba", R.mipmap.salchicha));
        listaDatos.add(new Pojo (getString(R.string.arroz), "1/4 arroba", R.mipmap.arroz));
        listaDatos.add(new Pojo (getString(R.string.azucar), "1 libra", R.mipmap.azucar));
        listaDatos.add(new Pojo (getString(R.string.chuleta_de_res), "1/4 kg", R.mipmap.chuleta_de_res));
        listaDatos.add(new Pojo (getString(R.string.frijol), "1/4 kg", R.mipmap.frijol));
        listaDatos.add(new Pojo (getString(R.string.papa), "1/4 arroba", R.mipmap.papa));
        listaDatos.add(new Pojo (getString(R.string.lechuga), "3 arroba", R.mipmap.lechuga));
        listaDatos.add(new Pojo (getString(R.string.tomate), "4 libra", R.mipmap.tomate));
        listaDatos.add(new Pojo (getString(R.string.cebolla), "3/5 kg", R.mipmap.cebolla));
        listaDatos.add(new Pojo (getString(R.string.manzana), "1/4 kg", R.mipmap.manzana));





    }

}
