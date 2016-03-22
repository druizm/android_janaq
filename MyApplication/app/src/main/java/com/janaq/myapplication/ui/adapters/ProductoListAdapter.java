package com.janaq.myapplication.ui.adapters;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.janaq.myapplication.R;
import com.janaq.myapplication.beans.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoListAdapter extends BaseAdapter{

    protected Activity activity;
    protected List<Producto> items = new ArrayList<>();

    public ProductoListAdapter(Activity activity, List<Producto> items){
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View vi = convertView;

        if(convertView == null){
            LayoutInflater inflator = activity.getLayoutInflater();
            vi = inflator.inflate(R.layout.producto_item_list, null);
            holder = new ViewHolder(vi);
            vi.setTag(holder);
        }else{
            holder = (ViewHolder) vi.getTag();
        }

        final Producto itm = items.get(position);

        if(itm != null){
            holder.txtProductoNombre.setText(itm.getNombre());
            holder.txtProductoPrecio.setText(Double.toString(itm.getPrecio()));
            holder.txtProductoCategoria.setText(itm.getCategoria());
            holder.imgViewProducto.setImageDrawable(
                    ContextCompat.getDrawable(activity,R.drawable.manzana));

        }

        return vi;
    }

    public static class ViewHolder {

        private TextView txtProductoNombre;
        private TextView txtProductoPrecio;
        private TextView txtProductoCategoria;

        private ImageView imgViewProducto;

        private ViewHolder(View v){

            this.txtProductoNombre = (TextView) v.findViewById(R.id.txtProductoNombre);
            this.txtProductoPrecio = (TextView) v.findViewById(R.id.txtProductoPrecio);
            this.txtProductoCategoria = (TextView) v.findViewById(R.id.txtProductoCat);

            this.imgViewProducto = (ImageView) v.findViewById(R.id.imgViewProducto);

        }

    }
}
