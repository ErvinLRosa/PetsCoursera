package com.example.erosa.puppy;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.erosa.puppy.adapters.TabLayoutAdapter;
import com.example.erosa.puppy.fragments.PetListFragment;
import com.example.erosa.puppy.fragments.PetProfileFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabs;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabs = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.view_pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupTabs();
    }
    private void setupTabs(){
        tabs.setupWithViewPager(pager);
        pager.setAdapter(new TabLayoutAdapter(getSupportFragmentManager(), setupFragments()));
        tabs.getTabAt(0).setIcon(R.drawable.ic_home);
        tabs.getTabAt(1).setIcon(R.drawable.ic_pets);

    }

    private ArrayList<Fragment> setupFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetListFragment());
        fragments.add(new PetProfileFragment());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_favorite:
                startActivity(new Intent(this, FavoriteListActivity.class));
                break;
            case R.id.item_contact:
                startActivity(new Intent(this, ContactActivity.class));
                break;
            case R.id.item_acercade:
                startActivity(new Intent(this, AcercaDeActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
