package com.example.detailsforlaptopsandmobiles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MobileFragment extends Fragment {

    RecyclerView mobileRecyclerView;
    List<MobileDataModel> mobileDataModels;
    MobileAdapter mobileAdapter;
    EditText etvSearch;
    ImageView imgClose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mobile, container, false);

        mobileRecyclerView = view.findViewById(R.id.mobileRecyclerView);
        etvSearch = view.findViewById(R.id.etvSearch);
        imgClose = view.findViewById(R.id.imgClose);

        mobileDataModels = new ArrayList<>();
        mobileDataModels.add(new MobileDataModel(1,"https://imgs.search.brave.com/dTsuc4AE9ZULqv7YHClaAO5dv-iM52nstt6wglRt66o/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9waXNj/ZXMuYmJ5c3RhdGlj/LmNvbS9pbWFnZTIv/QmVzdEJ1eV9VUy9p/bWFnZXMvcHJvZHVj/dHMvNjU0MC82NTQw/MjY4X3NkLmpwZztt/YXhIZWlnaHQ9MjUw/O21heFdpZHRoPTM4/MA","Nokia",5000.0,"2018","Vadodara","21/8/20","Mobiles And Tablets"));
        mobileDataModels.add(new MobileDataModel(2, "https://imgs.search.brave.com/5J9G0asw7uRa9s35ivUGIkFWF0K23HWwpwdBAAq90iM/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9mZG4y/LmdzbWFyZW5hLmNv/bS92di9iaWdwaWMv/c2Ftc3VuZy1nYWxh/eHktczgtLmpwZw", "Samsung", 10000.0, "2019", "Ahmedabad", "21/8/21", "Laptops And Computers"));
        mobileDataModels.add(new MobileDataModel(3, "https://imgs.search.brave.com/TToymYIdpq7p-j790fV2WD6zk4y_73qx5gffWrq4Hn0/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS53aXJlZC5jb20v/cGhvdG9zLzY0NTQy/NTE5ZjJkZTg2MTgz/Y2Y1YjI4Ni9tYXN0/ZXIvd18xNjAwLGNf/bGltaXQvTW90b3Jv/bGEtTW90by1HLVBv/d2VyLTVHLXJldmll/dy1GZWF0dXJlZC1H/ZWFyLmpwZw", " Motorola", 15000.0, "2020", "Surat", "21/8/22", "Laptops And Computers"));
        mobileDataModels.add(new MobileDataModel(4, "https://imgs.search.brave.com/HaAGmDELxQuuNYOt6ntI1OhbjtwAeGkBijOEWuZRX-s/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9waXNj/ZXMuYmJ5c3RhdGlj/LmNvbS9pbWFnZTIv/QmVzdEJ1eV9VUy9k/YW0vcG9sLU1NVC03/MDc3OTEtMS0yMzA3/MjRfREVSLWUxZTAy/NTRiLWJlMjYtNDdl/My04OGI2LTUxMWVl/YmMwODBjNy5qcGc7/bWF4SGVpZ2h0PTQx/NjttYXhXaWR0aD02/MTI", "Apple", 20000.0, "2020", "Mumbai", "21/8/20", "Laptops And Computers"));
        mobileDataModels.add(new MobileDataModel(5, "https://imgs.search.brave.com/NWb_-39iQ7cj_prGcJdZK4Jozqs740Xr6CQIUDU2aoo/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9pNS53/YWxtYXJ0aW1hZ2Vz/LmNvbS9hc3IvYzFi/NTJkNWEtNTMyYy00/ZDA0LTk2ODAtZTk4/MGFhMjdkMzNlLmRl/MDA1MTAzNmIyZjE5/NmRjMGFlZGZkZjY4/NzlkYjk4LnBuZz9v/ZG5IZWlnaHQ9NTgw/Jm9kbldpZHRoPTU4/MCZvZG5CZz1GRkZG/RkY", "Xiaomi", 25000.0, "2021", "Pune", "21/8/21", "Laptops And Computers"));
        mobileDataModels.add(new MobileDataModel(6, "https://imgs.search.brave.com/Se9XPc30J3_qSjmnaWiQi0fYTaZPJgTQzfMdYfSjB7g/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9mZG4y/LmdzbWFyZW5hLmNv/bS92di9iaWdwaWMv/b3Bwby1hMTIuanBn", "Oppo", 30000.0, "2022", "Chennai", "21/8/22", "Laptops And Computers"));

        mobileAdapter = new MobileAdapter(this, mobileDataModels);
        mobileRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mobileRecyclerView.setAdapter(mobileAdapter);

        etvSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mobileAdapter != null) {
                    imgClose.setVisibility(View.VISIBLE);
                    mobileAdapter.search(charSequence, mobileRecyclerView);
                }
                if (i2 < 1) {
                    imgClose.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }
}