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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static  AppCompatActivity LoginActivity;
    private Context mContext;
    private SharedPreferences mPref;

    private TextView txtUser, txtPassword;
    private EditText edtUser, edtPassword;
    private Button btnLogin, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginActivity = this;
        mContext = this;
        mPref = getSharedPreferences(AppMyApp.PREF_FILE, Context.MODE_PRIVATE);

        initParams();
        setParams();
    }

    private void initParams(){
        txtUser = (TextView) findViewById(R.id.txtUser);
        txtPassword = (TextView) findViewById(R.id.txtPassword);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistro= (Button) findViewById(R.id.btnRegistro);
    }

    private void setParams(){

        btnLogin.setOnClickListener(this);
        btnLogin.setText("LOGUEO");

        btnRegistro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;

            case R.id.btnRegistro:
                Intent in = new Intent(this, RegistroActivity.class);
                startActivity(in);
                break;

            default:
                break;
        }

    }

    private void login(){

        String _correo = edtUser.getText().toString();
        String _pass = edtPassword.getText().toString();

        if(!_correo.equals("") && ! _pass.equals("")){

            String pref_user = mPref.getString(AppMyApp.PREF_USER_CORREO, "");
            String pref_pass = mPref.getString(AppMyApp.PREF_USER_PASSWORD, "");

            if(_correo.equals(pref_user) && _pass.equals(pref_pass)){

                Intent in = new Intent(this, MainNavActivity.class);
                startActivity(in);
                finish();

            }else{
                edtUser.setText("");
                edtPassword.setText("");

                Toast.makeText(getBaseContext(), "Usuario y/o contraseña incorrectas.",
                        Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getBaseContext(), "Usuario y/o contraseña incorrectas.",
                    Toast.LENGTH_LONG).show();
        }

    }
}
