package com.example.productslist.Adapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.productslist.Model.Product;
import com.example.productslist.ProductDetail;
import com.example.productslist.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> arrayList;
    private TextView productName,productBrand,productPrice;
    private ImageView productImage;
    private Button moreButton;

    public CustomAdapter(Context context, ArrayList<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Product getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.product_layout, viewGroup, false);
        productName = view.findViewById(R.id.product_name);
        productBrand = view.findViewById(R.id.product_brand);
        productPrice = view.findViewById(R.id.product_price);
        productImage = view.findViewById(R.id.product_image);
        moreButton = view.findViewById(R.id.product_detail_btn);

        productName.setText(arrayList.get(i).getName());
        productBrand.setText(arrayList.get(i).getBrand());
        productPrice.setText("$"+String.valueOf(arrayList.get(i).getPrice()));
        Glide.with(view).load("file:///android_asset/" + arrayList.get(i).getImageUrl()).into(productImage);

        return view;
    }
}
