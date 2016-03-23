package com.janaq.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.janaq.myapplication.beans.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DavidM on 18/03/2016.
 */
public class LocalData {

    public static LocalData instance = null;
    public Context mContext;
    private MyAppDB dbcn;
    private SQLiteDatabase db;

    public static LocalData getInstance(Context context){
        if(instance == null){
            instance = new LocalData(context);
        }
        return instance;
    }

    public LocalData(Context context){
        mContext = context;
        dbcn = new MyAppDB(mContext,
                MyAppConfig.getDbName(),
                null,
                MyAppConfig.getDbVersion());
    }

    public void removerData(){
        db =  dbcn.getWritableDatabase();

        if(db != null){
            db.delete("productos", null, null);
        }
    }


    public List<Producto> obtenerProductos(){
        List<Producto> list = null;

        db = dbcn.getReadableDatabase();

        String[] productos_columnas = {"id", "nombre", "descripcion",
                "precio", "imagen", "categoria"};

        Cursor c = db.query("productos", productos_columnas, null, null, null, null, null);

        if( c != null ){
            if(c.moveToFirst()){
                list = new ArrayList<>();
                do{
                    list.add(new Producto(c.getString(1), c.getDouble(3), c.getString(5)));
                }while(c.moveToNext());
            }
            c.close();
        }

        return list;
    }

    public void guardarProductos(String datos){

        db = dbcn.getWritableDatabase();
        if(db != null){

            String[] productos_columnas = {"id", "nombre", "descripcion",
                    "precio", "imagen", "categoria"};
            Cursor c = db.query("productos", productos_columnas, null, null, null, null, null);

            if( c.moveToFirst() ){
                db.delete("productos", null, null);
            }

            JSONArray jarray;

            try {
                jarray = new JSONArray(datos);

                if(jarray.length() > 0){

                    ContentValues val_p = new ContentValues();

                    for(int i = 0; i < jarray.length(); i++){

                        JSONObject json = jarray.getJSONObject(i);

                        int p_id = json.getInt("producto_id");

                        String p_nombre = json.getString("nombre");

                        String p_descripcion = json.getString("descripcion");

                        double p_precio = json.getDouble("precio");

                        String p_image = "";

                        if(json.getString("imagen") != null && !json.getString("imagen").equals("")){
                            p_image = MyAppConfig.getRuta_ws() + json.getString("imagen");
                        }

                        val_p.put("id", p_id);
                        val_p.put("nombre", p_nombre);
                        val_p.put("descripcion", p_descripcion);
                        val_p.put("precio", p_precio);
                        val_p.put("imagen", p_image);

                        db.insert("productos", null, val_p);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

}
