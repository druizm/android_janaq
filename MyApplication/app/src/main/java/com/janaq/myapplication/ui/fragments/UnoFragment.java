package com.janaq.myapplication.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.janaq.myapplication.R;
import com.janaq.myapplication.ui.ListaActivity;
import com.janaq.myapplication.ui.MainNavActivity;

public class UnoFragment extends Fragment implements View.OnClickListener{

    private Context mContext;

    private TextView txtTitulo;
    private Button btnListar;

    public UnoFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_uno, container, false);

        mContext = getActivity();

        initParams(v);
        setParams();

        return v;
    }


    private void initParams(View v){

        txtTitulo = (TextView) v.findViewById(R.id.textView);
        btnListar = (Button) v.findViewById(R.id.btnListar);

    }

    public  void setParams(){
        btnListar.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnListar:
                listar();
                break;

        }

    }

    public void listar(){
        Intent in = new Intent(mContext, ListaActivity.class);
        startActivity(in);
    }

}
