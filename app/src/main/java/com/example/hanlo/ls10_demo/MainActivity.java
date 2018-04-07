package com.example.hanlo.ls10_demo;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private com.example.hanlo.ls10_demo.mainFragmentPagerAdapter mainFragmentPagerAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragmentPagerAdapter = new mainFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        //setup view pager
        setupViewPager(mViewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupViewPager(ViewPager viewPager){
        mainFragmentPagerAdapter adapter = new mainFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new mainFragmentActivity(), "Main Fragment");
        adapter.addFragment(new secondary_FragmentActivity(), "Secondary Fragment");
        adapter.addFragment(new settings_FragmentPageAdapter(), "Settings Fragment");
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()){

            case R.id.Home:
                //Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_SHORT).show();
                this.setViewPager(0);
                return true;
            case R.id.nav_manage:
                this.setViewPager(2);
                return true;
            case R.id.nav_share:
                return true;
            case R.id.favorites:

                return true;
            case R.id.viewFavorites:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
