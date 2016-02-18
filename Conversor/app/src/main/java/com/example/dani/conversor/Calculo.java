package com.example.dani.conversor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.content.Intent;

public class Calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        String origen;
        String destino;
        Double numero;
        Double solucion;

        TextView result = (TextView) findViewById(R.id.result);
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            origen = extras.getString("o");
            destino = extras.getString("d");
            solucion = extras.getDouble("s");
            numero = extras.getDouble("v");
            solucion = extras.getDouble("s");
            result.setText(numero + " " + origen + " son " + solucion + " " + destino);
        }
    }
}


