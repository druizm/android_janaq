package com.janaq.myapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.janaq.myapplication.AppMyApp;
import com.janaq.myapplication.R;

public class RegistroActivity extends AppCompatActivity {

    private Context mContext;
    private SharedPreferences mPref;

    private TextView txtNombre, txtApellidos, txtCorreo, txtPassword, txtRePassword;
    private EditText edtNombre, edtApellidos, edtCorreo, edtPassword, edtRePassword;

    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mContext = this;
        mPref = getSharedPreferences(AppMyApp.PREF_FILE, Context.MODE_PRIVATE);

        initParams();
        setParams();
    }

    private void initParams(){

        txtNombre = (TextView) findViewById(R.id.txtNombres);
        txtApellidos = (TextView) findViewById(R.id.txtApellidos);
        txtCorreo = (TextView) findViewById(R.id.txtCorreo);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtRePassword = (TextView) findViewById(R.id.txtRePassword);

        edtNombre = (EditText) findViewById(R.id.edtNombres);
        edtApellidos = (EditText) findViewById(R.id.edtApellidos);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtRePassword = (EditText) findViewById(R.id.edtRePassword);

        btnRegistro = (Button) findViewById(R.id.btnRegistro);

    }

    private void setParams(){

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });

    }

    private void registro(){
        boolean band = true;

        String _nombres = edtNombre.getText().toString();
        String _apellidos = edtApellidos.getText().toString();
        String _correo = edtCorreo.getText().toString();
        String _pass = edtPassword.getText().toString();
        String _repass = edtRePassword.getText().toString();

        if(_nombres.equals("")){
            band = false;
            Toast.makeText(mContext, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
        }else if(_apellidos.equals("")){
            band = false;
            Toast.makeText(mContext, "Ingrese su apellido", Toast.LENGTH_SHORT).show();
        }else if(_correo.equals("")){
            band = false;
            Toast.makeText(mContext, "Ingrese su correo", Toast.LENGTH_SHORT).show();
        }else if(_pass.equals("")){
            band = false;
            Toast.makeText(mContext, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
        }else if(!_pass.equals(_repass)){
            band = false;
            Toast.makeText(mContext, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

        if(band){

            SharedPreferences.Editor edit = mPref.edit();
            edit.putString(AppMyApp.PREF_USER_NOMBRES, _nombres);
            edit.putString(AppMyApp.PREF_USER_APELLIDOS, _apellidos);
            edit.putString(AppMyApp.PREF_USER_CORREO, _correo);
            edit.putString(AppMyApp.PREF_USER_PASSWORD, _pass);
            edit.apply();

            Intent in = new Intent(this, HomeActivity.class);
            startActivity(in);

        }
    }
}
