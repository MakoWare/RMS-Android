package rms.makowaredev.com.rms.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import rms.makowaredev.com.rms.R;

public class GymActivity extends AppCompatActivity {
    private final static String TAG = "GymActivity";
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.gym_activity);
        setContentView(R.layout.gym_activity);
        Log.i(TAG, "onCreate");

        // Handle Toolbar
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawer = createDrawer(savedInstanceState);
    }

    public Drawer createDrawer(Bundle savedInstanceState) {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        return new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .withDisplayBelowStatusBar(false)
                .withTranslucentStatusBar(false)
                //.withDrawerLayout(R.layout.material_drawer_fits_not)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Gym").withIdentifier(0),
                        new SecondaryDrawerItem().withName("Walls").withIdentifier(1),
                        new SecondaryDrawerItem().withName("Routes").withIdentifier(2),
                        new SecondaryDrawerItem().withName("User").withIdentifier(3)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Intent intent = null;
                        Log.i(TAG, "" + drawerItem.getIdentifier());
                        if (drawerItem.getIdentifier() == 1) {
                            intent = new Intent(GymActivity.this, WallActivity.class);
                        } else if (drawerItem.getIdentifier() == 2) {
                            intent = new Intent(GymActivity.this, WallActivity.class);
                        } else if (drawerItem.getIdentifier() == 3) {
                            intent = new Intent(GymActivity.this, WallActivity.class);
                        }

                        if (intent != null) {
                            GymActivity.this.startActivity(intent);
                        }
                        return false;
                    }
                }).build();
    }


    //On Fragments Attached
    public void onSectionAttached(int number) {
        Log.i(TAG, "onSectionAttached");

    }

    /*
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
    }
    */

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