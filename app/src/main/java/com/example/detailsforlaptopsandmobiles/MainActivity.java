package com.example.detailsforlaptopsandmobiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    LaptopFragment laptopFragment;
    MobileFragment mobileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabMode);
        viewPager2 = findViewById(R.id.viewPager);

        laptopFragment = new LaptopFragment();
        mobileFragment = new MobileFragment();

        viewPager2.setAdapter(new FSAdapter(MainActivity.this));

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                if (position == 0) {
                    tab.setText("LAPTOPS");
                } else {
                    tab.setText("MOBILES");
                }
            }
        }).attach();
    }
}