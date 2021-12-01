package com.example.productslist;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductDetail extends AppCompatActivity {

    private String name,description,image,price;
    private TextView productName,productDescription,productPrice;
    private ImageView productImage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        name = getIntent().getStringExtra("ProductName");
        description = getIntent().getStringExtra("ProductDescription");
        image = getIntent().getStringExtra("ProductImage");
        price = getIntent().getStringExtra("ProductPrice");
        //setting appbar and title
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.product_description);
        productImage = findViewById(R.id.product_image);
        backButton = findViewById(R.id.backButton);
        productName.setText(name);
        productPrice.setText(price);
        productDescription.setText(description);
        Glide.with(getApplicationContext()).load("file:///android_asset/" + image).into(productImage);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}