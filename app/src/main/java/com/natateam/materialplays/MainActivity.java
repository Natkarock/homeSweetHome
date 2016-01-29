package com.natateam.materialplays;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    ThingListFragment fragmentScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        FragmentManager fragmentManager= getSupportFragmentManager();
        final FragmentTransaction ft = fragmentManager.beginTransaction();
        fragmentScroll= new ThingListFragment();
        ft.add(R.id.fragmentScroll,fragmentScroll,"FragmentScroll");
        ft.show(fragmentScroll);
        ft.commitAllowingStateLoss();
    }


    public void toSecondFragment(View view){
        DescFragment descFragment= new DescFragment();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Inflate transitions to apply
            Transition changeTransform = TransitionInflater.from(this).
                    inflateTransition(R.transition.change_image_transition);
            Transition explodeTransform = TransitionInflater.from(this).
                    inflateTransition(android.R.transition.fade);

            // Setup exit transition on first fragment
            fragmentScroll.setSharedElementReturnTransition(explodeTransform);
            fragmentScroll.setExitTransition(explodeTransform);

            // Setup enter transition on second fragment
            descFragment.setSharedElementEnterTransition(explodeTransform);
            descFragment.setEnterTransition(explodeTransform);
            // Find the shared element (in Fragment A)
            ImageView ivProfile = (ImageView) findViewById(R.id.ivProfile);

            // Add second fragment by replacing first
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentScroll,descFragment)
                    .addToBackStack("transaction")
                    .addSharedElement(view.findViewById(R.id.ivProfile), "profile");
            // Apply the transaction
            ft.commit();
        }
        else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentScroll, descFragment)
                    .addToBackStack("transaction");
            // Apply the transaction
            ft.commit();
            // Code to run on older devices
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
