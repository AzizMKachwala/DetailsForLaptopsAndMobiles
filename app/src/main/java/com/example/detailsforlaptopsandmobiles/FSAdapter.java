package com.example.detailsforlaptopsandmobiles;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FSAdapter extends FragmentStateAdapter {

    public FSAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new MobileFragment();
            case 0:
            default:
                return new LaptopFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
