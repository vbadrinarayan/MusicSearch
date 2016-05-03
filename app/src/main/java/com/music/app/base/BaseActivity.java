package com.music.app.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.music.app.R;

/**
 * Have the basic methods and toolbar set up which can be used at all activities
 * by extending this base activity.
 */
public class BaseActivity extends AppCompatActivity {

    private TextView mTitleView = null;

    /**
     *
     * @param savedInstanceState bundle object to repopulate contents when activity re-created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_layout);
        //Create a Toolbar Object, assign it to the view in xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        if (toolbar != null)
            mTitleView = (TextView) toolbar.findViewById(R.id.title_toolbar_view);
        setSupportActionBar(toolbar);
    }

    /**
     * Set Title of the Activity.
     *
     * @param title Value that has to be set as title of the activity.
     */
    @Override
    public void setTitle(CharSequence title) {
        mTitleView.setText(title);
    }

    /**
     * Set Title of the Activity.
     *
     * @param titleResId Resource id of string that has to be set as title of the activity.
     */
    @Override
    public void setTitle(int titleResId) {
        mTitleView.setText(titleResId);
    }

    /**
     * Set the given fragment to be visible.
     *
     * @param fragment Fragment to be shown
     */
    protected void setFragment(Fragment fragment, boolean isAddToBackStack, String tag) {
        /*Create a Fragment Manager Object*/
        FragmentManager fragmentManager;
        /*Create a Fragment Transaction Object*/
        FragmentTransaction fragmentTransaction;
        /*Assign the fragment manager to the support fragment manager of the android.support.v4 package */
        fragmentManager = getSupportFragmentManager();
        /*Begin the Transaction.*/
        fragmentTransaction = fragmentManager.beginTransaction();
        /*Add the parametrised fragment to the fragment transaction. */
        fragmentTransaction.add(
                R.id.fragment_container, fragment, tag);
        /*Add the fragment to the back stack*/
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        /*Commit the transaction.*/
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }
}
