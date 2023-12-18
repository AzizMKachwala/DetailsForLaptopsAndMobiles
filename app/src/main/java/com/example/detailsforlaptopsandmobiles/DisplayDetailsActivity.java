package com.example.detailsforlaptopsandmobiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DisplayDetailsActivity extends AppCompatActivity {

    TextView txtBrand, txtPrice, txtPurchaseYear, txtLocation, txtUploadedDate, txtCategory;
    ImageView imgDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        txtBrand = findViewById(R.id.txtBrand);
        txtPrice = findViewById(R.id.txtPrice);
        txtPurchaseYear = findViewById(R.id.txtPurchaseYear);
        txtLocation = findViewById(R.id.txtLocation);
        txtUploadedDate = findViewById(R.id.txtUploadedDate);
        txtCategory = findViewById(R.id.txtCategory);
        imgDevice = findViewById(R.id.imgDevice);

        String Brand = getIntent().getStringExtra("Brand");
        String Photo = getIntent().getStringExtra("Photo");
        String Price = getIntent().getStringExtra("Price");
        String PurchaseYear = getIntent().getStringExtra("PurchaseYear");
        String Location = getIntent().getStringExtra("Location");
        String UploadedDate = getIntent().getStringExtra("UploadedDate");
        String Category = getIntent().getStringExtra("Category");

        Glide.with(DisplayDetailsActivity.this).load(Photo).into(imgDevice);

        txtBrand.setText(Brand);
        txtPrice.setText(Price);
        txtPurchaseYear.setText(PurchaseYear);
        txtLocation.setText(Location);
        txtUploadedDate.setText(UploadedDate);
        txtCategory.setText(Category);
    }
}