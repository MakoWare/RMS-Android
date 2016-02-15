package rms.makowaredev.com.rms.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.support.v4.widget.DrawerLayout;
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
import rms.makowaredev.com.rms.frags.WallListFragment;
import rms.makowaredev.com.rms.frags.dummy.DummyContent;

public class WallActivity extends Activity implements WallListFragment.OnListFragmentInteractionListener {

    private static  final String TAG = "WallActivity";
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wall_activity);
        Log.i(TAG, "onCreate");

        drawer = createDrawer(savedInstanceState);
    }

    public void onSectionAttached(int number) {

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
                            intent = new Intent(WallActivity.this, WallActivity.class);
                        } else if (drawerItem.getIdentifier() == 2) {
                            intent = new Intent(WallActivity.this, WallActivity.class);
                        } else if (drawerItem.getIdentifier() == 3) {
                            intent = new Intent(WallActivity.this, WallActivity.class);
                        }

                        if (intent != null) {
                            WallActivity.this.startActivity(intent);
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

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
