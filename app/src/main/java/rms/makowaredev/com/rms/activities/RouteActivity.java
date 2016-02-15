package rms.makowaredev.com.rms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import rms.makowaredev.com.rms.R;
import rms.makowaredev.com.rms.frags.NavigationDrawerFragment;

public class RouteActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private final static String TAG = "RouteActivity";
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym_activity);
        Log.i(TAG, "onCreate()");

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Log.i(TAG, "onNavigationDrawerItemSelected() : " + position);
        switch (position) {
            case 0:
                startActivity(new Intent(this, GymActivity.class));
            case 1:
                startActivity(new Intent(this, WallActivity.class));
                break;
            case 2:
                //Already on Routes
                break;
            case 3:
                startActivity(new Intent(this, UserActivity.class));
                break;
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                break;
            case 2:

                break;
            case 3:
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

}