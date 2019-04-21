package com.wor.tarealistas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wor.tarealistas.model.Produ;

public class ProductActivity extends AppCompatActivity {

    private Context mContext;

    private ImageView image;

    private TextView productId;
    private TextView productName;
    private TextView productPrice;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        mContext = this;
        initViews();
        receiveData();
    }

    private void initViews() {
        image = findViewById(R.id.image);
        productId = findViewById(R.id.productId);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
    }

    private void receiveData() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(Constants.KEY_PRODUCT);
        Produ produ = new Gson().fromJson(json, Produ.class);
        image.setImageResource(produ.getImage());
        productName.setText(produ.getName());
        productPrice.setText(String.valueOf(produ.getPrice()));
    }
}

