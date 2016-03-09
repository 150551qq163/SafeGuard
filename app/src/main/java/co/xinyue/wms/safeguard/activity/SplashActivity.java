package co.xinyue.wms.safeguard.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.xinyue.wms.safeguard.R;
import co.xinyue.wms.safeguard.util.Constant;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSharedPreferences(Constant.SHARED_PREFERENCE, Context.MODE_PRIVATE).getBoolean(Constant.SHOWSTARTPAGE,true)){
            startActivity(new Intent(this,WelcomeActivity.class));
        }
        setContentView(R.layout.activity_splash);
    }
}
