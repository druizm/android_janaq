package com.janaq.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.janaq.myapplication.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initParams();
        setParams();

    }

    public  void initParams(){

        btnListar = (Button) findViewById(R.id.btnListar);

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
        Intent in = new Intent(this, MainNavActivity.class);
        startActivity(in);
    }

}
