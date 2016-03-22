package com.janaq.myapplication.data;

import android.util.Base64;

import com.janaq.myapplication.AppMyApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DavidM on 18/03/2016.
 */
public class WSData {

    public static String obtenerProductosWS(){

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();

        try {
            URL url = new URL(MyAppConfig.getRuta_ws()+"obtener_productos");
            conn = (HttpURLConnection) url.openConnection();

            String credenciales = AppMyApp.CREDENTIAL_USERNAME + ":" + AppMyApp.CREDENTIAL_PASS;
            String base64EncodedCredentials = Base64.encodeToString(credenciales.getBytes(),
                    Base64.NO_WRAP);

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Basic " + base64EncodedCredentials);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            conn.setRequestProperty("Content-length", "0");
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.connect();

            InputStream _is;
            if (conn.getResponseCode() == 200) {
                _is = conn.getInputStream();
            } else {
                _is = conn.getErrorStream();
            }

            InputStreamReader in = new InputStreamReader(_is);

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(conn != null)
                conn.disconnect();
        }

        return jsonResults.toString();
    }

}
