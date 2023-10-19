package com.example.listapersonalizada.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listapersonalizada.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<ProductModel> productList;
    private final Activity activity;

    public ProductAdapter(final Activity activity) {
        this.activity = activity;
    }

    public void setProductList(final ArrayList<ProductModel> products) {
        productList = products;
    }

    @Override
    public int getCount() {
        return productList != null ? productList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return productList != null ? productList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.list_item, viewGroup, false);
        }

        ProductModel product = productList.get(i);

        TextView productName = view.findViewById(R.id.productName);
        productName.setText(product.getProductName());

        TextView productCode = view.findViewById(R.id.productCode);
        productCode.setText(product.getProductCode());

        TextView productValue = view.findViewById(R.id.productValue);
        productValue.setText("R$ " + product.getProductValue());

        Button btnDetails = view.findViewById(R.id.btnDetails);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,
                        "Clicou no produto: " + productList.get(i).getProductName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        return view;
    }
}
