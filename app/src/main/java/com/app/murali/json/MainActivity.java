package com.app.murali.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button onclick1;
    public static TextView getjson1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onclick1 = findViewById(R.id.button);
        getjson1 = findViewById(R.id.displayjson);


        onclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           jsondata process = new jsondata();
           process.execute();
            }
        });
    }
}
