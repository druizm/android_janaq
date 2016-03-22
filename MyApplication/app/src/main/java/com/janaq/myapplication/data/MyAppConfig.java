package com.janaq.myapplication.data;

import android.content.Context;

/**
 * Created by DavidM on 18/03/2016.
 */
public class MyAppConfig {

    public static MyAppConfig instance = null;
    private Context mContext;

    private static String DB_NAME = "myapp_db";
    private static int DB_VERSION = 1;

    private static String ruta_base = "http://apiqd.jnqlabs.com";

    private static String ruta_ws = ruta_base + "/api-empresa/v1/";


    public static String getDbName() {
        return DB_NAME;
    }

    public static int getDbVersion() {
        return DB_VERSION;
    }

    public static String getRuta_ws() {
        return ruta_ws;
    }
}
