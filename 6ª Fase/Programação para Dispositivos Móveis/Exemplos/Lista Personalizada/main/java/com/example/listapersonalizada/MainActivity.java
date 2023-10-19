package com.example.listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.listapersonalizada.adapter.ProductAdapter;
import com.example.listapersonalizada.adapter.ProductModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView productList;

    private ProductAdapter adapter;

    private Button btnAdd;

    ArrayList<ProductModel> arl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = findViewById(R.id.productList);
        adapter = new ProductAdapter(MainActivity.this);

        arl = new ArrayList<ProductModel>();
        for(int i = 0; i < 4; i++) {
            ProductModel p = new ProductModel();
            p.setProductName("Produto " + i);
            p.setProductCode("789123456-" + i);
            p.setProductValue(50.0);
            arl.add(p);
        }

        adapter.setProductList(arl);
        productList.setAdapter(adapter);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductModel p = new ProductModel();
                p.setProductName("Produto Adicionado");
                p.setProductCode("7892");
                p.setProductValue(25.0);
                arl.add(p);
                adapter.notifyDataSetChanged();
            }
        });
    }
}