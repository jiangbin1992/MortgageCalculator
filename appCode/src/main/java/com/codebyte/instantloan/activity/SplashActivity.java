package com.codebyte.instantloan.activity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;

public class SplashActivity extends AppCompatActivity {
    public static Integer counterBann = 0;
    public static Integer counterInter = 0;
    public static Integer counterNative = 0;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(1024, 1024);
        loadAd();
    }


    private void loadAd() {
        new Handler().postDelayed(new Runnable() {


            public void run() {
                Log.e("dsfdsfdsfdsf", "111111111111");
                new AdMobLoaderClass().showInterstitialAds(SplashActivity.this, new Intent(SplashActivity.this, StartActivity.class));
            }
        }, 4000);
    }

    public void showOpenAd() {
        new Handler().postDelayed(new Runnable() {


            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, StartActivity.class));
            }
        }, 4000);
    }

    public boolean isConnected() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
            return false;
        }
    }
}
