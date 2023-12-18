package com.example.detailsforlaptopsandmobiles;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileDataViewHolder> {

    List<MobileDataModel> mobileDataModels, searchModels;
    MobileFragment context;

    public MobileAdapter(MobileFragment context, List<MobileDataModel> mobileDataModels) {
        this.mobileDataModels = mobileDataModels;
        this.searchModels = mobileDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MobileDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_data, parent, false);
        return new MobileDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobileDataViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MobileDataModel mobileDataModel = searchModels.get(position);

        try {
            Glide
                    .with(context)
                    .load(mobileDataModel.getImage())
                    .apply(new RequestOptions().placeholder(R.drawable.baseline_downloading_24))
                    .error(R.drawable.nodata)
                    .into(holder.imgMobile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.txtMobileBrand.setText(mobileDataModel.getBrand());
        holder.txtMobilePrice.setText("₹" + String.valueOf(mobileDataModel.getPrice()));
        holder.txtMobilePurchaseYear.setText(mobileDataModel.getPurchaseYear());
        holder.txtMobileLocation.setText(mobileDataModel.getLocation());
        holder.txtMobileUploadedDate.setText(mobileDataModel.getUploadedDate());
        holder.txtMobileCategory.setText(mobileDataModel.getCategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getContext(), "Item Clicked " + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), DisplayDetailsActivity.class);
                intent.putExtra("Brand", mobileDataModel.brand);
                intent.putExtra("Photo", mobileDataModel.image);
                intent.putExtra("Price", holder.txtMobilePrice.getText().toString());
                intent.putExtra("PurchaseYear", mobileDataModel.purchaseYear);
                intent.putExtra("Location", mobileDataModel.location);
                intent.putExtra("UploadedDate", mobileDataModel.uploadedDate);
                intent.putExtra("Category", mobileDataModel.category);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }

    public void search(CharSequence charSequence, RecyclerView mobileRecyclerView) {

        try {
            String charString = charSequence.toString().trim();
            if (charString.isEmpty()) {
                searchModels = mobileDataModels;
                mobileRecyclerView.setVisibility(View.VISIBLE);
            } else {
                int flag = 0;
                List<MobileDataModel> filteredList = new ArrayList<>();
                for (MobileDataModel row : mobileDataModels) {
                    if (row.getBrand().toLowerCase().contains(charString.toLowerCase())) {
                        filteredList.add(row);
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    searchModels = filteredList;
                    mobileRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    mobileRecyclerView.setVisibility(View.GONE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MobileDataViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMobile;
        TextView txtMobileBrand, txtMobilePrice, txtMobilePurchaseYear, txtMobileLocation, txtMobileUploadedDate, txtMobileCategory;

        public MobileDataViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMobile = itemView.findViewById(R.id.img);
            txtMobileBrand = itemView.findViewById(R.id.txtBrand);
            txtMobilePrice = itemView.findViewById(R.id.txtPrice);
            txtMobilePurchaseYear = itemView.findViewById(R.id.txtPurchaseYear);
            txtMobileLocation = itemView.findViewById(R.id.txtLocation);
            txtMobileUploadedDate = itemView.findViewById(R.id.txtUploadedDate);
            txtMobileCategory = itemView.findViewById(R.id.txtCategory);

        }
    }
}
