package com.music.app.music.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.music.app.R;
import com.music.app.music.fragment.FavoriteFragment;
import com.music.app.music.fragment.HistoryFragment;
import com.music.app.music.fragment.HomeFragment;

public class MusicSearchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private TextView mTitleView;

    /**
     *
     * @param savedInstanceState bundle object to repopulate contents when activity re-created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_search_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null)
            mTitleView = (TextView) toolbar.findViewById(R.id.title_toolbar_view);

        mTitleView.setText(R.string.label_home);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null)
            drawer.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            mTitleView.setText(R.string.label_home);
        } else if (id == R.id.nav_history) {
            fragment = new HistoryFragment();
            mTitleView.setText(R.string.label_history);
        } else if (id == R.id.nav_favorites) {
            fragment = new FavoriteFragment();
            mTitleView.setText(R.string.label_favorites);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_sign_out) {

        }

        if(fragment != null)
            setFragment(fragment, false, null);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null)
            drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Set the given fragment to be visible.
     *
     * @param fragment Fragment to be shown
     */
    private void setFragment(Fragment fragment, boolean isAddToBackStack, String tag) {
        /*Create a Fragment Manager Object*/
        FragmentManager fragmentManager;
        /*Create a Fragment Transaction Object*/
        FragmentTransaction fragmentTransaction;
        /*Assign the fragment manager to the support fragment manager of the android.support.v4 package */
        fragmentManager = getSupportFragmentManager();
        /*Begin the Transaction.*/
        fragmentTransaction = fragmentManager.beginTransaction();
        /*Add the parametrised fragment to the fragment transaction. */
        fragmentTransaction.replace(
                R.id.fragment_container, fragment, tag);
        /*Add the fragment to the back stack*/
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        /*Commit the transaction.*/
        fragmentTransaction.commit();
        //fragmentManager.executePendingTransactions();
    }

    @Override
    public void onClick(View view) {

    }
}
