package com.example.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class VerLibros extends AppCompatActivity {

    private TextView listaLibros;
    private HashMap<String, Libro> libros = new HashMap<String, Libro>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_libros);
        libros = (HashMap<String, Libro>) getIntent().getSerializableExtra( "libros");
        initComInterfaz();
        regresaVer();
    }

    public void initComInterfaz(){
        listaLibros = (TextView) findViewById(R.id.listaLibros);
        listaLibros.setText("");
    }

    public void muestraLibros(View view){
        String cadena = "";
        if(libros != null){
            int cont = 1;
            for (Libro libro : libros.values()) {
                cadena+= cont + " ." + libro.toString() + '\n';
                cont++;
            }
        } else {
            cadena = "No se han registrado libros";
        }
        listaLibros.setText(cadena);
    }

    public void regresaVer() {
        Button btnRegresaVer = (Button) findViewById(R.id.btnRegresaVer);
        btnRegresaVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
    }
}