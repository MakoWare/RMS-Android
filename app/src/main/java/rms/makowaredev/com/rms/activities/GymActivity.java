package rms.makowaredev.com.rms.activities;

import android.content.Intent;
import android.os.Bundle;
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

public class GymActivity extends AppCompatActivity {
    private final static String TAG = "GymActivity";
    private Drawer drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.gym_activity);
        setContentView(R.layout.gym_activity);
        Log.i(TAG, "onCreate");

        // Handle Toolbar
        toolbar = (Toolbar) findViewById(R.id.myToolbar);
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
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .withDisplayBelowStatusBar(false)
                .withToolbar(toolbar)
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