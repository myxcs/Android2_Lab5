package com.example.android2_lab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterTab extends FragmentStateAdapter {

    public AdapterTab(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new Home();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putString("title", "Home");
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
