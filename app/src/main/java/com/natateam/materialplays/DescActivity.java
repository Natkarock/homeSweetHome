package com.natateam.materialplays;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by macbook on 29/01/ 15.
 */
public class DescActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_description);
        ((ImageView) findViewById(R.id.ivProfile)).setImageDrawable(
                getResources().getDrawable(R.drawable.manul1));
    }
}
