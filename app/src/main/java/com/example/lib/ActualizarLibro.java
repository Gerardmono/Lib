package com.example.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class ActualizarLibro extends AppCompatActivity {

    private HashMap<String, Libro> libros = new HashMap<String, Libro>();
    private EditText actIsbn, actTitulo, actAutor, actPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_libro);
        libros = (HashMap<String, Libro>) getIntent().getSerializableExtra( "libros");
        initComInterfaz();
        regresaActualizar();
    }

    public void initComInterfaz(){
        actIsbn = (EditText) findViewById(R.id.actualizarIsbn);
        actTitulo = (EditText) findViewById(R.id.actualizarTitulo);
        actAutor = (EditText) findViewById(R.id.actualizarAutor);
        actPrecio = (EditText) findViewById(R.id.actualizarPrecio);
    }

    public void actualizaLibro(View view){
        String valIsbn = actIsbn.getText().toString();
        String valTitulo = actTitulo.getText().toString();
        String valAutor = actAutor.getText().toString();
        Double valPrecio = Double.parseDouble(this.actPrecio.getText().toString());
        if(libros.containsKey(valIsbn)) {
            Libro libro = new Libro(valIsbn, valTitulo, valAutor, valPrecio);
            libros.put(valIsbn, libro);
            Toast.makeText(this, "Libro actualizado", Toast.LENGTH_SHORT).show();
            actIsbn.setText("");
            actTitulo.setText("");
            actAutor.setText("");
            actPrecio.setText("");
        } else {
            Toast.makeText(this, "El libro no existe", Toast.LENGTH_SHORT).show();
        }
    }

    public void regresaActualizar() {
        Button btnRegresaActualizar = (Button) findViewById(R.id.btnRegresaActualizar);
        btnRegresaActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
    }
}