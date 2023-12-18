package com.example.detailsforlaptopsandmobiles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopDataViewHolder> {

    List<LaptopDataModel> laptopDataModels, searchModels;
    LaptopFragment context;

    public LaptopAdapter(LaptopFragment context, List<LaptopDataModel> laptopDataModels) {
        this.laptopDataModels = laptopDataModels;
        this.searchModels = laptopDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public LaptopDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_data, parent, false);
        return new LaptopDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopDataViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LaptopDataModel laptopDataModel = searchModels.get(position);

        try {
            Glide
                    .with(context)
                    .load(laptopDataModel.getImage())
                    .apply(new RequestOptions().placeholder(R.drawable.baseline_downloading_24))
                    .error(R.drawable.nodata)
                    .into(holder.imgLaptop);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.txtLaptopBrand.setText(laptopDataModel.getBrand());
        holder.txtLaptopPrice.setText("₹" + String.valueOf(laptopDataModel.getPrice()));
        holder.txtLaptopPurchaseYear.setText(laptopDataModel.getPurchaseYear());
        holder.txtLaptopLocation.setText(laptopDataModel.getLocation());
        holder.txtLaptopUploadedDate.setText(laptopDataModel.getUploadedDate());
        holder.txtLaptopCategory.setText(laptopDataModel.getCategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Item Clicked "+ position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), DisplayDetailsActivity.class);
                intent.putExtra("Brand",laptopDataModel.brand);
                intent.putExtra("Photo",laptopDataModel.image);
                intent.putExtra("Price",holder.txtLaptopPrice.getText().toString());
                intent.putExtra("PurchaseYear",laptopDataModel.purchaseYear);
                intent.putExtra("Location",laptopDataModel.location);
                intent.putExtra("UploadedDate",laptopDataModel.uploadedDate);
                intent.putExtra("Category",laptopDataModel.category);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }

    public void search(CharSequence charSequence, RecyclerView laptopRecyclerView) {

        try {
            String charString = charSequence.toString().trim();
            if (charString.isEmpty()) {
                searchModels = laptopDataModels;
                laptopRecyclerView.setVisibility(View.VISIBLE);
            } else {
                int flag = 0;
                List<LaptopDataModel> filteredList = new ArrayList<>();
                for (LaptopDataModel row : laptopDataModels) {
                    if (row.getBrand().toLowerCase().contains(charString.toLowerCase())) {
                        filteredList.add(row);
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    searchModels = filteredList;
                    laptopRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    laptopRecyclerView.setVisibility(View.GONE);
                }
                notifyDataSetChanged();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class LaptopDataViewHolder extends RecyclerView.ViewHolder {

        ImageView imgLaptop;
        TextView txtLaptopBrand, txtLaptopPrice, txtLaptopPurchaseYear, txtLaptopLocation, txtLaptopUploadedDate, txtLaptopCategory;

        public LaptopDataViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLaptop = itemView.findViewById(R.id.img);
            txtLaptopBrand = itemView.findViewById(R.id.txtBrand);
            txtLaptopPrice = itemView.findViewById(R.id.txtPrice);
            txtLaptopPurchaseYear = itemView.findViewById(R.id.txtPurchaseYear);
            txtLaptopLocation = itemView.findViewById(R.id.txtLocation);
            txtLaptopUploadedDate = itemView.findViewById(R.id.txtUploadedDate);
            txtLaptopCategory = itemView.findViewById(R.id.txtCategory);
        }
    }
}
