package com.wor.tarealistas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wor.tarealistas.R;
import com.wor.tarealistas.model.Produ;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private List<Produ> items;

    public ProductAdapter(Context context, List<Produ> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Produ getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if(vista==null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.layout_lista, null);

            viewHolder.image = vista.findViewById(R.id.image);
            viewHolder.productId = vista.findViewById(R.id.productId);
            viewHolder.productName = vista.findViewById(R.id.productName);
            viewHolder.productPrice = vista.findViewById(R.id.productPrice);
            vista.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vista.getTag();
        }

        Produ productoActual = items.get(position);
        viewHolder.image.setImageResource(productoActual.getImage());
        viewHolder.productId.setText(String.valueOf(productoActual.getId()));
        viewHolder.productName.setText(productoActual.getName());
        viewHolder.productPrice.setText(String.valueOf(productoActual.getPrice()));
        return vista;
    }

    static class ViewHolder{
        ImageView image;
        TextView productId;
        TextView productName;
        TextView productPrice;

    }
}
