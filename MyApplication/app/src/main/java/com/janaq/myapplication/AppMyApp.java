package com.janaq.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DavidM on 16/03/2016.
 */
public class AppMyApp extends Application {

    public static SharedPreferences PREF_MY_APP;

    @Override
    public void onCreate() {
        super.onCreate();

        PREF_MY_APP = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);

    }

    /** CREDENCIALES **/

    public static final String CREDENTIAL_USERNAME = "admin00@clase.com";
    public static final String CREDENTIAL_PASS = "test00";

    /** VARIABLES PREFERENCIAS **/

    public static final String PREF_FILE = "MYAPP_PREF";
    public static final String PREF_LOGGED = "PREF_LOGGED";

    public static final String PREF_USER_ID = "PREF_USER_ID";
    public static final String PREF_USER_NOMBRES = "PREF_USER_NOMBRES";
    public static final String PREF_USER_APELLIDOS = "PREF_USER_APELLIDOS";
    public static final String PREF_USER_CORREO = "PREF_USER_CORREO";
    public static final String PREF_USER_PASSWORD = "PREF_USER_PASSWORD";


    /*      FUNCIONES       */

    public static boolean isLoged(){
        return PREF_MY_APP.getBoolean(PREF_LOGGED, false);
    }

}
