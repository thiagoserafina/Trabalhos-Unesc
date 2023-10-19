package com.example.listasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView nameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameList = findViewById(R.id.nameList);

        String[] data = new String[] {
                "Thiago",
                "Murillo",
                "Mateus",
                "Marcio",
                "Daniel",
                "Claudia",
                "Lucas",
                "Thiago",
                "Murillo",
                "Mateus",
                "Marcio",
                "Daniel",
                "Claudia",
                "Lucas",
                "Thiago",
                "Murillo",
                "Mateus",
                "Marcio",
                "Daniel",
                "Claudia",
                "Lucas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                data
                );

        nameList.setAdapter(adapter);
     }
}