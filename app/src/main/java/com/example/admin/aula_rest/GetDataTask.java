package com.example.admin.aula_rest;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Admin on 23/11/2017.
 */

public class GetDataTask extends AsyncTask<Void, Void, String> {

    private final String TAG = "GetData";

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "No pré-Executesson!");
    }

    @Override
    protected String doInBackground(Void... voids) {
        Log.i(TAG, "Rodando...(sson)");
        //Declarando var url
        URL url = null;
        //Declarando Conn
        HttpURLConnection conn = null;
        String result = "";

        try {
            //Definindo a url onde vai fazer as requisições
            url = new URL("https://jsonplaceholder.typicode.com/posts");
            //Abrindo conexão com a url definida acima
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(conn.getInputStream());
            //Chamando método para converter o Objeto Stream retornado para String
            result = convertInputStreamToString(in);
            Log.i(TAG, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

//
        return result;

    }
    //Conversor de obj Stream para String
    private String convertInputStreamToString(InputStream in) {
        StringBuilder builder = new StringBuilder();
        String line ="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            while ((line = reader.readLine())!=null) builder.append(line);
            in.close();
            return builder.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i(TAG, "No POST Executesson!");
        Gson gson = new Gson();
        Posts[] posts = gson.fromJson(result, Posts[].class);
        Log.i(TAG, posts[0].getTitle());
    }
}
