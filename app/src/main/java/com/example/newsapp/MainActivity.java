package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome , mscience , mhealth, mtechnology , mentertainment ,msport;
    PagerAdapter  pagerAdapter;
    Toolbar mtoolbar;

    String api = "17df344bb5344e7ea54bb3ddcf6e53de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar= findViewById(R.id.toolBar); // we cn set the default toolbar
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.Home);
        mscience = findViewById(R.id.Science);
        mhealth = findViewById(R.id.Health);
        mtechnology = findViewById(R.id.Technology);
        mentertainment= findViewById(R.id.Entertainment);
        msport = findViewById(R.id.Sports);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.include);


        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

     tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {  // we call the items selected listener
         @Override
         public void onTabSelected(TabLayout.Tab tab) {
             viewPager.setCurrentItem(tab.getPosition());
             if     (tab.getPosition()==0 || // we can set the fragment according user need
                     tab.getPosition()==1 ||
                     tab.getPosition()==2 ||
                     tab.getPosition()==3 ||
                     tab.getPosition()==4 ||
                     tab.getPosition()==5 ){
                 pagerAdapter.notifyDataSetChanged();
             }
         }

         @Override
         public void onTabUnselected(TabLayout.Tab tab) {

         }

         @Override
         public void onTabReselected(TabLayout.Tab tab) {

         }
     });

     viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}

