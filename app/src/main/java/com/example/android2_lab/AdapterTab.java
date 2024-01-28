package com.example.android2_lab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android2_lab.fragment.Display;
import com.example.android2_lab.fragment.Home;

public class AdapterTab extends FragmentStateAdapter {


    public AdapterTab(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                Home home = new Home();
                return home;
            case 1:
                Display display = new Display();
                return display;
            default:
                return new Home();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
