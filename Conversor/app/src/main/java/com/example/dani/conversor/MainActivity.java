package com.example.dani.conversor;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RadioButton obytes = (RadioButton) findViewById((R.id.obytes));
        final RadioButton okilobytes = (RadioButton) findViewById((R.id.okilobytes));
        final RadioButton omegabytes = (RadioButton) findViewById((R.id.omegabytes));
        final  RadioButton dbytes = (RadioButton) findViewById((R.id.dbytes));
        final RadioButton dkilobytes = (RadioButton) findViewById((R.id.dkilobytes));
        final RadioButton dmegabytes = (RadioButton) findViewById((R.id.dmegabytes));
       final EditText valor = (EditText) findViewById((R.id.cantidad));



        findViewById(R.id.calcular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double numero = Double.parseDouble(valor.getText().toString());

                double solucion = 0;
                String o = "";
                String d = "";

                Intent i = new Intent(getApplicationContext(), Calculo.class);

                if (obytes.isChecked() &&  dkilobytes.isChecked()) {
                        o = "bytes";
                        d = "kilobytes";
                        solucion = numero  / 1024;

                    }else if (obytes.isChecked() && dmegabytes.isChecked()) {
                        o = "bytes";
                        d = "megabytes";
                        solucion = numero / 1024 / 1024;

                    }else if (okilobytes.isChecked() && dbytes.isChecked()) {
                        o = "kilobytes";
                        d = "bytes";
                        solucion = numero * 1024;

                    }else if (okilobytes.isChecked() && dmegabytes.isChecked()) {
                        o = "bytes";
                        d = "megabytes";
                        solucion = numero / 1024 / 1024;

                    }else if (omegabytes.isChecked() && dbytes.isChecked()) {
                        o = "megabytes";
                        d = "bytes";
                        solucion = numero * 1024 * 1024;

                    }else if (omegabytes.isChecked() && dkilobytes.isChecked()) {
                        o = "megabytes";
                        d = "kilobytes";
                        solucion = numero * 1024;
                    }else {

                    o = "";
                            d = "";
                                    solucion = 0;

                    }


                i.putExtra("o", o);
                i.putExtra("d", d);
                i.putExtra("s", solucion);
                i.putExtra("v", numero);

                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
