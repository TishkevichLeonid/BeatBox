package com.example.android.beatbox;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by leonidtiskevic on 09.07.17.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_fragment;
    }

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
