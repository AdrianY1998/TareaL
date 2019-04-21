package com.wor.tarealistas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wor.tarealistas.Adapter.ProductAdapter;
import com.wor.tarealistas.model.Produ;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Context mContext;

    private ListView productos;

    private List<Produ> productosArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        productosArray.add(new Produ(1, "Manzana", 5, R.drawable.apple));
        productosArray.add(new Produ(2, "Cerezas", 3, R.drawable.cerezas));
        productosArray.add(new Produ(3, "Uvas", 2, R.drawable.uvas));


        initViews();
        addEvents();
    }

    private void initViews(){
        productos = findViewById(R.id.productos);

        ProductAdapter  productosAdapter = new ProductAdapter(mContext, productosArray);
        productos.setAdapter(productosAdapter);
    }

    private void addEvents(){
        productos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produ produ = productosArray.get(position);
                Intent intent = new Intent(mContext, ProductActivity.class);
                intent.putExtra(Constants.KEY_PRODUCT, new Gson().toJson(produ));
                startActivity(intent);
            }
        });
    }
}
