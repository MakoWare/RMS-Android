package rms.makowaredev.com.rms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import rms.makowaredev.com.rms.R;
import rms.makowaredev.com.rms.frags.NavigationDrawerFragment;

public class RouteActivity extends AppCompatActivity {

    private final static String TAG = "RouteActivity";
    private Drawer drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_activity);
        Log.i(TAG, "onCreate()");

        toolbar = (Toolbar) findViewById(R.id.myToolbar);
        drawer = createDrawer(savedInstanceState);

    }

    public Drawer createDrawer(Bundle savedInstanceState) {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        return new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .withDisplayBelowStatusBar(false)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                //.withDrawerLayout(R.layout.material_drawer_fits_not)
                .addDrawerItems(
                        new SecondaryDrawerItem().withName("Gym").withIdentifier(0),
                        new SecondaryDrawerItem().withName("Walls").withIdentifier(1),
                        new PrimaryDrawerItem().withName("Routes").withIdentifier(2),
                        new SecondaryDrawerItem().withName("User").withIdentifier(3)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Intent intent = null;
                        Log.i(TAG, "" + drawerItem.getIdentifier());
                        if (drawerItem.getIdentifier() == 0) {
                            intent = new Intent(RouteActivity.this, GymActivity.class);
                        } else if (drawerItem.getIdentifier() == 1) {
                            intent = new Intent(RouteActivity.this, WallActivity.class);
                        } else if (drawerItem.getIdentifier() == 3) {
                            intent = new Intent(RouteActivity.this, UserActivity.class);
                        }

                        if (intent != null) {
                            RouteActivity.this.startActivity(intent);
                        }
                        return false;
                    }
                }).build();
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