package com.codebyte.instantloan.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

import cz.msebera.android.httpclient.protocol.HTTP;

public class MainActivity extends AppCompatActivity {
    ImageView btnEpfService;
    ImageView btnLoanGuide;
    ImageView btnNearByMe;
    LinearLayout btnPrivacyPolicy;
    LinearLayout btnShareApp;
    ImageView btnAllBankBalance;
    ImageView btnEmiCalculator;
    ImageView btnEpfOnline;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnLoanGuide = (ImageView) findViewById(R.id.btn_Loan_Guide);
        this.btnEpfService = (ImageView) findViewById(R.id.btn_EPF_Service);
        this.btnAllBankBalance = (ImageView) findViewById(R.id.btn_all_bank_balance);
        this.btnEmiCalculator = (ImageView) findViewById(R.id.btn_emi_Calculator);
        this.btnNearByMe = (ImageView) findViewById(R.id.btn_Near_By_Me);
        this.btnEpfOnline = (ImageView) findViewById(R.id.btn_epf_online);
        this.btnPrivacyPolicy = (LinearLayout) findViewById(R.id.btn_Privacy_policy);
        this.btnShareApp = (LinearLayout) findViewById(R.id.btn_Share_App);
        this.btnLoanGuide.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.MainActivity(view);
            }
        });
        this.btnEpfService.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam1(view);
            }
        });
        this.btnEpfOnline.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam2(view);
            }
        });
        this.btnAllBankBalance.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam3(view);
            }
        });
        this.btnEmiCalculator.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam4(view);
            }
        });
        this.btnNearByMe.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam5(view);
            }
        });
        this.btnPrivacyPolicy.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam6(view);
            }
        });
        this.btnShareApp.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                MainActivity.this.Cliam7(view);
            }
        });
    }

    public void MainActivity(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, LoanGuide.class).putExtra("position", "loan_guide"));
    }

    public void Cliam1(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, EPFService.class));
    }

    public void Cliam2(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, EPFOnline.class).putExtra("position", "EPF_service"));
    }

    public void Cliam3(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, AllBankBalance.class));
    }

    public void Cliam4(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, CalculatorActivity.class));
    }

    public void Cliam5(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, NearByMe.class));
    }

    public void Cliam6(View view) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.white));
        CustomTabsIntent build = builder.build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://kinfollc.blogspot.com/"));
    }

    public void Cliam7(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "Check out the App at: https://play.google.com/store/apps/details?id=" + getPackageName());
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
