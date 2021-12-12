package com.example.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libros = (HashMap<String, Libro>) getIntent().getSerializableExtra( "libros");
        if (libros == null){
            libros = new HashMap<String, Libro>();
        }
        mandaObjeto();
    }

    public void mandaObjeto(){
        Button botonInserta = (Button) findViewById(R.id.botonInserta);
        botonInserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), InsertarLibro.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
        Button botonVisualiza = (Button) findViewById(R.id.botonVisualiza);
        botonVisualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), VerLibros.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
        Button botonElimina = (Button) findViewById(R.id.botonElimina);
        botonElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), EliminarLibro.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
        Button botonActualiza = (Button) findViewById(R.id.botonActualiza);
        botonActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), ActualizarLibro.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
    }
}