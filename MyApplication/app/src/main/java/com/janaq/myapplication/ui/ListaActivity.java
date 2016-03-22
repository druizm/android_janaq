package com.janaq.myapplication.ui;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.janaq.myapplication.R;
import com.janaq.myapplication.beans.Producto;
import com.janaq.myapplication.data.LocalData;
import com.janaq.myapplication.data.WSData;
import com.janaq.myapplication.ui.adapters.ProductoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private List<Producto> listProductos;

    ProductoListAdapter adapter;

    private ListView listViewProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        initparams();

        new asyncDescargaProductos().execute();

    }

    private void initparams(){
        listViewProductos = (ListView) findViewById(R.id.listViewDatos);
    }

    private void setParams(){

        listProductos = LocalData.getInstance(getBaseContext()).obtenerProductos();
        if(listProductos != null){
            adapter = new ProductoListAdapter(this, listProductos);
            listViewProductos.setAdapter(adapter);
        }

        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Producto obj = (Producto) adapter.getItem(position);

                if(obj != null){

                    Intent in = new Intent(ListaActivity.this, ProductoDetalleActivity.class);

                    in.putExtra("nombre",obj.getNombre());
                    in.putExtra("precio",obj.getPrecio());
                    in.putExtra("categoria",obj.getCategoria());
                    in.putExtra("imagen",obj.getImage_path());

                    startActivity(in);

                }
            }
        });

    }

    private void llenadoDatos(){

        listProductos  = new ArrayList<>();

        listProductos.add(new Producto("Manzana", 2.56, "Frutas"));
        listProductos.add(new Producto("Papaya", 5.00, "Frutas"));
        listProductos.add(new Producto("Papa", 1.6, "Vegetales"));
        listProductos.add(new Producto("Naranja", 2.0, "Frutas"));

        listProductos.add(new Producto("Manzana", 2.56, "Frutas"));
        listProductos.add(new Producto("Papaya", 5.00, "Frutas"));
        listProductos.add(new Producto("Papa", 1.6, "Vegetales"));
        listProductos.add(new Producto("Naranja", 2.0, "Frutas"));

        listProductos.add(new Producto("Manzana", 2.56, "Frutas"));
        listProductos.add(new Producto("Papaya", 5.00, "Frutas"));
        listProductos.add(new Producto("Papa", 1.6, "Vegetales"));
        listProductos.add(new Producto("Naranja", 2.0, "Frutas"));
    }



    public class asyncDescargaProductos extends AsyncTask<String, String, String> {

        private ProgressDialog pdialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdialog = new ProgressDialog(ListaActivity.this);
            pdialog.setMessage("Cargando productos");
            pdialog.setIndeterminate(false);
            pdialog.setCancelable(false);
            pdialog.show();

        }

        @Override
        protected String doInBackground(String... params) {
            String data = WSData.obtenerProductosWS();

            if(!data.equals("")){
                return  data;
            }else{
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String s) {

            pdialog.dismiss();

            if(!s.equals("error")){
                LocalData.getInstance(getBaseContext()).guardarProductos(s);
                setParams();
            }else{
                Toast.makeText(getBaseContext(),"Ocurrio un error por culpa de LUCA", Toast.LENGTH_LONG).show();
            }

        }
    }


}
