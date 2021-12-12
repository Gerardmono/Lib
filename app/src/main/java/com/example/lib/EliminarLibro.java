package com.example.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class EliminarLibro extends AppCompatActivity {

    private EditText isbnField;
    private TextView resultadoEliminar;
    private HashMap<String, Libro> libros = new HashMap<String, Libro>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_libro);
        libros = (HashMap<String, Libro>) getIntent().getSerializableExtra( "libros");
        initComInterfaz();
        regresaEliminar();
    }

    public void initComInterfaz(){
        isbnField = (EditText) findViewById(R.id.eliminarIsbn);
        resultadoEliminar = (TextView) findViewById(R.id.resultadoEliminar);
    }

    public void eliminaLibro(View view){
        String isbnVal = isbnField.getText().toString();
        if(libros.containsKey(isbnVal)) {
            if(libros.remove(isbnVal) != null ) {
                resultadoEliminar.setText("Libro con ISBN: \n"+isbnVal+" Eliminado");
            } else {
                resultadoEliminar.setText("Libro con ISBN: \n"+isbnVal+" No eliminado");
            }
        } else {
            resultadoEliminar.setText("Libro con ISBN: \n"+isbnVal+" No existe");
        }
    }

    public void regresaEliminar() {
        Button btnRegresaEliminar = (Button) findViewById(R.id.btnRegresaEliminar);
        btnRegresaEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("libros", libros);
                startActivityForResult(intent, 0);
            }
        });
    }
}