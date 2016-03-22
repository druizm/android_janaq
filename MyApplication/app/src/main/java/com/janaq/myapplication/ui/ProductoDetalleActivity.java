package com.janaq.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.janaq.myapplication.R;

public class ProductoDetalleActivity extends AppCompatActivity {

    private TextView txtNombre, txtPrecio;

    String nombre, imagen, categoria;
    Double precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detalle);

        initBundle();
        initParams();
        setParams();
    }

    private void initBundle(){
        Bundle extras = getIntent().getExtras();

        if( extras != null ){
            nombre = extras.getString("nombre");
            imagen = extras.getString("imagen");
            categoria = extras.getString("categoria");
            precio = extras.getDouble("precio");
        }

    }

    private void initParams(){
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtPrecio = (TextView) findViewById(R.id.txtPrecio);
    }

    private void setParams(){
        txtNombre.setText(nombre);
        txtPrecio.setText(Double.toString(precio));
    }

}
