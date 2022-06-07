package com.management.alscare;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;

import com.management.alscare.ui.login.LoginActivity;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      /*  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); */
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean isLoginVerified = false;
                /*if(getSharedPreferences("LoginInfo", 0).getBoolean("loginVerified", true))
                    isLoginVerified = true;*/

                if(!isLoginVerified) {
                    //Intent is used to switch from one activity to another.
                    Intent i = new Intent(MainActivity.this,
                            com.management.alscare.ui.login.LoginActivity.class);
                    startActivity(i);
              }else {
                    //Intent is used to switch from one activity to another.
                    Intent i = new Intent(MainActivity.this,
                            Main3Activity.class);
                    startActivity(i);
                }
                //Intent is used to switch from one activity to another.
                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }

}
