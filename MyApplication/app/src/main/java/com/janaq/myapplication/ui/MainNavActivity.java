package com.janaq.myapplication.ui;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.janaq.myapplication.R;
import com.janaq.myapplication.ui.fragments.UnoFragment;

public class MainNavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Context mContext;

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);

        mContext = this;

        initParams();
        setParams();


    }

    private void initParams(){

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

    }

    private void setParams(){

        // Esta linea nos faltaba para que se realice la selección de cada item
        navigationView.setNavigationItemSelectedListener(this);


        // Con esta linea hacemos que se muestre el primer item del menu,
        // como si hubieramos hecho click
        navigationView.getMenu().performIdentifierAction(R.id.nav_item_uno, 0);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        if(item.isChecked())item.setChecked(false);
        else item.setChecked(true);

        drawerLayout.closeDrawers();

        Fragment fragment;

        switch (item.getItemId()){

            case R.id.nav_item_uno:
                fragment = new UnoFragment();
                break;

            case R.id.nav_item_dos:
                fragment = new UnoFragment();
                break;
            case R.id.nav_item_tres:
                fragment = new UnoFragment();
                break;
            default:
                fragment = new UnoFragment();
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

        return true;
    }
}
