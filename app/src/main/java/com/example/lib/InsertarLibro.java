package com.example.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class InsertarLibro extends AppCompatActivity {

    private EditText isbnField, tituloField, autorField, precioField;
    private HashMap<String, Libro> libros = new HashMap<String, Libro>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_libro);
        libros = (HashMap<String, Libro>) getIntent().getSerializableExtra( "libros");
        initComInterfaz();
        regresaInsertar();
    }

    public void initComInterfaz(){
        isbnField = (EditText) findViewById(R.id.nuevoIsbn);
        tituloField = (EditText) findViewById(R.id.nuevoTitulo);
        autorField = (EditText) findViewById(R.id.nuevoAutor);
        precioField = (EditText) findViewById(R.id.nuevoPrecio);
    }

    public void insertaLibro(View view){
        String valIsbn = isbnField.getText().toString();
        String valTitulo = tituloField.getText().toString();
        String valAutor = autorField.getText().toString();
        Double valPrecio = Double.parseDouble(this.precioField.getText().toString());
        Libro libro = new Libro(valIsbn, valTitulo, valAutor, valPrecio);
        libros.put(valIsbn, libro);
        System.out.println("Cree el libro");
        isbnField.setText("");
        tituloField.setText("");
        autorField.setText("");
        precioField.setText("");
    }

    public void regresaInsertar() {
        Button btnRegresaInsertar = (Button) findViewById(R.id.btnRegresaInsertar);
        btnRegresaInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
    }
}