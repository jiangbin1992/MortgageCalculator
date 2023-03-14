package com.codebyte.instantloan.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

public class NearByMe extends AppCompatActivity {
    ImageView btnAtm;
    ImageView btnBack;
    ImageView btnBank;
    ImageView btnZerox;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_near_by_me);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.btnZerox = (ImageView) findViewById(R.id.btn_zerox);
        this.btnAtm = (ImageView) findViewById(R.id.btn_atm);
        this.btnBank = (ImageView) findViewById(R.id.btn_bank);
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                NearByMe.this.NearByMe(view);
            }
        });
        this.btnZerox.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                NearByMe.this.NearByMe1(view);
            }
        });
        this.btnAtm.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                NearByMe.this.NearByMe2(view);
            }
        });
        this.btnBank.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                NearByMe.this.NearByMe3(view);
            }
        });
    }

    public void NearByMe(View view) {
        onBackPressed();
    }

    public void NearByMe1(View view) {
        setgGoogleMap("Zerox");
    }

    public void NearByMe2(View view) {
        setgGoogleMap("ATM");
    }

    public void NearByMe3(View view) {
        setgGoogleMap("Bank");
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }

    public void setgGoogleMap(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.co.in/maps?q=" + str)));
    }
}
