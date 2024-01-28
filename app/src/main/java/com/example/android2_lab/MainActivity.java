package com.example.android2_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.android2_lab.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);

        AdapterTab adapterTab = new AdapterTab(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterTab);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Home");
                    break;
                case 1:
                    tab.setText("Display");
                    break;
                default:
                    tab.setText("Home");
                    break;
            }
        }).attach();
    }
}