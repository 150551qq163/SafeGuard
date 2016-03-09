package co.xinyue.wms.safeguard.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.xinyue.wms.safeguard.R;
import co.xinyue.wms.safeguard.adapter.WelcomePageAdapter;
import co.xinyue.wms.safeguard.listener.ViewPageChangeListener;

public class WelcomeActivity extends AppCompatActivity {
    private static final String tag="WelcomeActivity";
    private ViewPager viewPager;
    private LinearLayout points;
    private TextView tv_pagerstate;
    private WelcomePageAdapter welcomePageAdapter;
    private ViewPageChangeListener viewPageChangeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        points= (LinearLayout) findViewById(R.id.points);
        tv_pagerstate= (TextView) findViewById(R.id.pagerstate);
        welcomePageAdapter=new WelcomePageAdapter(this ,points);
        viewPager.setAdapter(welcomePageAdapter);
        viewPageChangeListener =new ViewPageChangeListener(this,tv_pagerstate,points);
        viewPager.setOnPageChangeListener(viewPageChangeListener);
    }
}
