package com.example.admin.aula_rest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btGet = (Button) findViewById(R.id.button2);
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetDataTask().execute();
            }
        });
    }
}
