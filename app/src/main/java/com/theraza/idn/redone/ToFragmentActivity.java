package com.theraza.idn.redone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.theraza.idn.redone.Fragment.ContactFragment;
import com.theraza.idn.redone.Fragment.HelpFragment;
import com.theraza.idn.redone.Fragment.HistoryFragment;
import com.theraza.idn.redone.Fragment.LogoutFragment;
import com.theraza.idn.redone.Fragment.SearchFragment;
import com.theraza.idn.redone.Fragment.SettingFragment;

public class ToFragmentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ImageView img_notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_fragment);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        img_notif = findViewById(R.id.img_notif);
        img_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotificationActivity.class);
                startActivity(intent);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SearchFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_search);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_search:
                SearchFragment searchFragment = new SearchFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, searchFragment, SearchFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case R.id.nav_contact:
                ContactFragment contactFragment = new ContactFragment();
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                if (fragmentManager1 != null) {
                    fragmentManager1.beginTransaction()
                            .replace(R.id.fragment_container, contactFragment, ContactFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case R.id.nav_history:
                HistoryFragment historyFragment = new HistoryFragment();
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                if (fragmentManager2 != null) {
                    fragmentManager2.beginTransaction()
                            .replace(R.id.fragment_container, historyFragment, HistoryFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case R.id.nav_setting:
                SettingFragment settingFragment = new SettingFragment();
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                if (fragmentManager3 != null) {
                    fragmentManager3.beginTransaction()
                            .replace(R.id.fragment_container, settingFragment, SettingFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case R.id.nav_help:
                HelpFragment helpFragment = new HelpFragment();
                FragmentManager fragmentManager4 = getSupportFragmentManager();
                if (fragmentManager4 != null) {
                    fragmentManager4.beginTransaction()
                            .replace(R.id.fragment_container, helpFragment, HelpFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
