package com.example.productslist;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.productslist.Adapter.CustomAdapter;
import com.example.productslist.Model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CustomAdapter customAdapter;
    private ListView listView;
    private TextView productPrice,prevProductPrice;
    private ImageView productImage,prevProductImage;
    private Button moreButton,prevMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> products =  initialiseProducts();

        customAdapter = new CustomAdapter(this,products);
        listView = findViewById(R.id.products_list);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                productPrice = view.findViewById(R.id.product_price);
                productImage = view.findViewById(R.id.product_image);
                moreButton = view.findViewById(R.id.product_detail_btn);
                Product product = customAdapter.getItem(i);
                if(prevMoreButton != null){
                    prevProductPrice.setVisibility(View.GONE);
                    prevProductImage.setVisibility(View.GONE);
                    prevMoreButton.setVisibility(View.GONE);
                }
                productPrice.setVisibility(View.VISIBLE);
                moreButton.setVisibility(View.VISIBLE);
                productImage.setVisibility(View.VISIBLE);
                moreButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                        intent.putExtra("ProductName",product.getName());
                        intent.putExtra("ProductPrice","$"+String.valueOf(product.getPrice()));
                        intent.putExtra("ProductImage",product.getImageUrl());
                        intent.putExtra("ProductDescription",product.getDescription());
                        startActivity(intent);
                    }
                });
                prevMoreButton = moreButton;
                prevProductPrice = productPrice;
                prevProductImage = productImage;
            }
        });
    }

    private ArrayList<Product> initialiseProducts() {
        ArrayList<Product> productsList = new ArrayList<Product>(
                Arrays.asList(
                        new Product("Iphone 13 Pro","Apple",1099,"The 5.4-inch iPhone 13 mini is the successor to the iPhone 12 mini, while the 6.1-inch iPhone 13 is the replacement for the iPhone 12. Both of the new iPhone 13 models are nearly identical in design to the iPhone 12 models, featuring flat edges, an aerospace-grade aluminum enclosure, a glass back, and a slight increase in thickness (7.65mm)","iphone13.jpg"),
                        new Product("Mi 11 X","Mi",595,"The Mi 11X from Xiaomi is the most affordable of three new models in the Mi 11 family. It's priced a bit lower than the Mi 10T but offers plenty of updated features, most notably its Qualcomm Snapdragon 870 SoC which is only one step below the current flagship level.","mi11x.jpg"),
                        new Product("Vivo V21 5G","Vivo",387,"Vivo V21 5G mobile was launched on 27th April 2021. The phone comes with a 6.44-inch touchscreen display with a resolution of 1080x2404 pixels and an aspect ratio of 20:9. Vivo V21 5G is powered by an octa-core MediaTek Dimensity 800U processor. It comes with 8GB of RAM. The Vivo V21 5G runs Android 11 and is powered by a 4000mAh battery.","vivov21.jpg"),
                        new Product("Reno 6 Pro","Oppo",824,"Oppo's premium Reno line of smartphones has been updated with the newly launched Oppo Reno 6 Pro and the Oppo Reno 6, both 5G smartphones that succeed the previous Reno 5 series. Once again, the focus for these phones continues to be slimness and lightness, but they also have more powerful SoCs and new camera features to boast.","reno6pro.jpg"),
                        new Product("Galaxy Z Fold 3","Samsung",2409,"This is everything you'd want in a premium, durable, 5G smartphone.1 Then we made it unfold — revealing a massive screen so you can watch, work and play like never before.","galaxyzfold.jpg"),
                        new Product("Poco F3 GT","Poco",270,"Accurately priced Xiaomi Poco F3 GT promises seamless operations throughout. The brand has incorporated a 6GB RAM, robust processor setup, powerful battery capacity and impressive camera numbers on the front and the backside. It also gets IP53 Splashproof coverage and Corning Gorilla Glass v5 protected front screen. ","pocof3.jpg"),
                        new Product("Realme GT Neo 2","Realme",330,"With GT NEO 2, We believe that a great flagship should have a refined, all rounder performance Hence, we created this dialogue between technology and new life that shows realme's determination empowering new life with technology.","realmegt.jpg"),
                        new Product("LG Velvet Dual Screen","LG",450,"The LG Velvet Released in 2020 July 5G Network, 6GB RAM and 128GB ROM, 6.8 inches P-OLED capacitive touchscreen Display, android 10.0 Os, Triple 48MP (wide) + 8MP (ultrawide) + 5MP (micro) Rear & 16MP (wide) Front Camera, Qualcomm SDM845 Snapdragon 845 (10 nm) Chipset, Octa-core CPU, Non-removable Li-Po 4300 mAh battery battery.","lgvelvet.jpg"),
                        new Product("Iphone 12 Mini","Apple",820,"Apple prides itself on setting trends and not following them, and the iPhone 12 mini is a prime example of that. In a world where nearly all smartphones have 6-inch or larger screens, this new 5.4-inch model does stand out.","iphone12.jpg")
                ));
        return productsList;
    }
}