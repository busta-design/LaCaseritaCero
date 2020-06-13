package com.andresbustamante.lacaseritacero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme); //cambio del splashscreen

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo IMPLEMENTAR UN RECYCLERVIEW DONDE MUESTRE UNA LISTA INFINITA
    }
}
