package com.example.hanlo.ls10_demo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Switch;

/**
 * Created by hanlo on 4/6/2018.
 */

public class settingsFragmentActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting);
    }

    public void changeBackground(View view){

        Switch(view.getId()){
            case R.id.changeBackground:

        }
    }
}
