package com.example.emilia.busqueda;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private RecyclerView myrecyclerView;
    private List<Contact> lstContact;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myrecyclerView = findViewById(R.id.list_search);

        lstContact = new ArrayList<>();

        lstContact.add(new Contact("Ytalo","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Pedro","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Loreso","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Pablo","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Juancho","999123456",R.drawable.cpu));
        lstContact.add(new Contact("Franco","999123456",R.drawable.cpu));

         recyclerViewAdapter = new RecyclerViewAdapter(this,lstContact);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerView.setAdapter(recyclerViewAdapter);



        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpaper_id);


        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentHome(),"");
        adapter.addFragment(new FragmentBell(),"");
        adapter.addFragment(new FragmentSettings(),"");
        //adapter.addFragment(new FragmentSearch(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_ac);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_light);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);
        //tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);


        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

                    @Override
                    public void onPageSelected(int position) {
                        switch (position) {
                            case 0:
                                tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_ac);
                                tabLayout.getTabAt(1).setIcon(R.drawable.ic_light);
                                tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);
                                break;
                            case 1:
                                tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
                                tabLayout.getTabAt(1).setIcon(R.drawable.ic_light_ac);
                                tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);
                                break;
                            case 2:
                                tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
                                tabLayout.getTabAt(1).setIcon(R.drawable.ic_light);
                                tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings_ac);
                                break;
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                }
        );
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        //MenuItem searchReturn = menu.findItem(R.id.);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapter.getFilter().filter(newText);
                return false;
            }
        });


        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //

                tabLayout.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                return false;
            }
        });



        return true;
    }


//    public void fragment(){
//
//
//        viewPager.setCurrentItem(3);
//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.setVisibility(View.GONE);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_light);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);
//
//
//        //  tabLayout.getTabAt(3).setIcon(R.drawable.ic_search);
//
//
//    }


}
