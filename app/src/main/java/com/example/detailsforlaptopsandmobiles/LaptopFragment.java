package com.example.detailsforlaptopsandmobiles;

import android.content.Intent;
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
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LaptopFragment extends Fragment {

    RecyclerView laptopRecyclerView;
    List<LaptopDataModel> laptopDataModels;
    LaptopAdapter laptopAdapter;
    EditText etvSearch;
    ImageView imgClose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_laptop, container, false);

        laptopRecyclerView = view.findViewById(R.id.laptopRecyclerView);
        etvSearch = view.findViewById(R.id.etvSearch);
        imgClose = view.findViewById(R.id.imgClose);

        laptopDataModels = new ArrayList<>();
        laptopDataModels.add(new LaptopDataModel(1, "https://imgs.search.brave.com/6ly0FXYwG1YANJoUfxGzbaY-3Ehx4LBrvK93LZ77ee4/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTYz/OTQzNTU1L3Bob3Rv/L2EtbGVub3ZvLWlk/ZWFwYWQtdTQxMC1s/YXB0b3AtcGMtcGhv/dG9ncmFwaGVkLW9u/LXdoaXRlLXRha2Vu/LW9uLWp1bHktMTEt/MjAxMi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9eURiZ2pu/c1NRaHE1dGFxa2Jn/TkdCTEpoU0RBV083/eElHU3ByMGZfdldO/OD0", "Lenovo", 5000.0, "2018", "Vadodara", "21/8/20", "Laptops And Computers"));
        laptopDataModels.add(new LaptopDataModel(2, "https://imgs.search.brave.com/zduenEDci8vSRtfSgPPMtvzrmZmS4mAm72_Y7537QTc/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTM4/MjAyNjcyL3Bob3Rv/L2RlbGwtaW5zcGly/b24tbTUwMzAtbGFw/dG9wLWJhdGgtZmVi/cnVhcnktMy0yMDEx/LmpwZz9zPTYxMng2/MTImdz0wJms9MjAm/Yz1CRnpjaXpLTEpW/WktHeGFybnl2SUYw/Ql9zaU5GMlp5ZjZO/UGdIbThIWHc4PQ", "Dell", 10000.0, "2019", "Ahmedabad", "21/8/21", "Laptops And Computers"));
        laptopDataModels.add(new LaptopDataModel(3, "https://imgs.search.brave.com/UBi5UeUzypTcX61WnyYKDODjfgQuYBG6y_cW_0qazqc/rs:fit:500:0:0/g:ce/aHR0cHM6Ly81Lmlt/aW1nLmNvbS9kYXRh/NS9KTS9QQy9NWS0y/NjU0MTA0NC9ocC1w/YXZpbGlvbi14MzYw/LTE0bS1iYTAxM2R4/LTUwMHg1MDAuanBn", "HP", 15000.0, "2020", "Surat", "21/8/22", "Laptops And Computers"));
        laptopDataModels.add(new LaptopDataModel(4, "https://imgs.search.brave.com/xlmUONUpzw84SJFS3OB40NxpkIMM_ImbhLPCAYcFghw/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvNTM5/Njg3OTAwL3Bob3Rv/L2FzdXMtbGFwdG9w/LmpwZz9zPTYxMng2/MTImdz0wJms9MjAm/Yz1Lb256U2pJMElB/Y0hhWkRxTk5CdzJ1/bVVxTGNtSHpaU2ZO/WUo2ZzJYLWljPQ", "Asus", 20000.0, "2020", "Mumbai", "21/8/20", "Laptops And Computers"));
        laptopDataModels.add(new LaptopDataModel(5, "https://imgs.search.brave.com/2kG5hfjsYTtQfovrEVfB8NZ1k5m5rIXRJTbZPkuIlC8/rs:fit:500:0:0/g:ce/aHR0cHM6Ly93d3cu/YW5kcm9pZGF1dGhv/cml0eS5jb20vd3At/Y29udGVudC91cGxv/YWRzLzIwMjEvMTEv/QWNlci1Td2lmdC1Y/LTE2LmpwZw", "Acer", 25000.0, "2021", "Pune", "21/8/21", "Laptops And Computers"));
        laptopDataModels.add(new LaptopDataModel(6, "https://imgs.search.brave.com/Ua-cZ1IOsIkss0-XUaCRQLFupHdZvk0KZ_Wv0uoP3Do/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTIz/NTUzNTA0Ny9waG90/by9hbi1hcHBsZS1t/YWNib29rLWFpci1s/YXB0b3AtY29tcHV0/ZXItdGFrZW4tb24t/bm92ZW1iZXItMjQt/MjAyMC5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9UTd1a2pi/ZEpZQ3pJUWRaNnpf/REpHazRMSGROR2o4/X0ZfeXltNTR6UzNt/bz0", "Apple", 30000.0, "2022", "Chennai", "21/8/22", "Laptops And Computers"));

        laptopAdapter = new LaptopAdapter(this, laptopDataModels);
        laptopRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        laptopRecyclerView.setAdapter(laptopAdapter);

        etvSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (laptopAdapter != null) {
                        imgClose.setVisibility(View.VISIBLE);
                        laptopAdapter.search(charSequence, laptopRecyclerView);
                    }
                    if (i2 < 1) {
                        imgClose.setVisibility(View.GONE);
                    }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), DetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("LaptopDataModel", (Serializable) laptopDataModels.get(laptopRecyclerView.getId()));
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });

        return view;
    }
}