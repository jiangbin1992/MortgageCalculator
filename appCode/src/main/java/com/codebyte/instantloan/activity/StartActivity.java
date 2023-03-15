package com.codebyte.instantloan.activity;

import static com.best.now.myad.utils.Constant.URL_PRIVACY_POLICY;
import static com.best.now.myad.utils.PublicHelperKt.loadAd;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.best.now.myad.WebActivity;
import com.best.now.myad.utils.PublicHelperKt;
import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;
import com.codebyte.instantloan.notification.AlarmReceiver;

import java.util.Calendar;

import cz.msebera.android.httpclient.protocol.HTTP;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class StartActivity extends AppCompatActivity {
    LinearLayout btnPrivacyPolicy;
    LinearLayout btnRateUs;
    LinearLayout btnShareApp;
    ImageView btnLetsStart;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_start);

        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnLetsStart = (ImageView) findViewById(R.id.btn_lets_start);
        this.btnShareApp = (LinearLayout) findViewById(R.id.btn_Share_App);
        this.btnPrivacyPolicy = (LinearLayout) findViewById(R.id.btn_Privacy_policy);
        this.btnRateUs = (LinearLayout) findViewById(R.id.btn_Rate_Us);
        LinearLayout advBanner = (LinearLayout) findViewById(R.id.advBanner);
        loadAd(advBanner);
        this.btnLetsStart.setOnClickListener(new View.OnClickListener() {

            public final void onClick(View view) {
                if (PublicHelperKt.isRewarded(StartActivity.this)) {
                    PublicHelperKt.showInterstitialAd(StartActivity.this, new Function0<Unit>() {
                        @Override
                        public Unit invoke() {

                            StartActivity.this.StartActivity(view);
                            return null;
                        }
                    });
                }

            }
        });
        this.btnShareApp.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                StartActivity.this.StartActivity2(view);
            }
        });
        this.btnPrivacyPolicy.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {

                if (PublicHelperKt.isRewarded(StartActivity.this)) {
                    PublicHelperKt.showInterstitialAd(StartActivity.this, new Function0<Unit>() {
                        @Override
                        public Unit invoke() {
                            WebActivity.Companion.startActivity(StartActivity.this, "Privacy Policy", URL_PRIVACY_POLICY);
                            return null;
                        }
                    });
                }
            }
        });
        this.btnRateUs.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                if (PublicHelperKt.isRewarded(StartActivity.this)) {
                    PublicHelperKt.showInterstitialAd(StartActivity.this, new Function0<Unit>() {
                        @Override
                        public Unit invoke() {
                            StartActivity.this.StartActivity4(view);
                            return null;
                        }
                    });
                }

            }
        });
        setNotification();
    }

    public void StartActivity(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, MainActivity.class));
    }

    public void StartActivity2(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "Check out the App at: https://play.google.com/store/apps/details?id=" + getPackageName());
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        startActivity(intent);
    }

    public void StartActivity3(View view) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.white));
        CustomTabsIntent build = builder.build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://kinfollc.blogspot.com/"));
    }

    public void StartActivity4(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
    }

    @Override
    public void onBackPressed() {
//        final Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.exit_layout);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.getWindow().setLayout(-1, -2);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
//        dialog.getWindow().getAttributes().windowAnimations = 16973826;
//        AdUtils.nativeAd(this, (FrameLayout) dialog.findViewById(R.id.native_ad_PE_pkms), true, false);
//        ((TextView) dialog.findViewById(R.id.positiveAction)).setOnClickListener(new View.OnClickListener() {
//
//
//            public void onClick(View view) {
//                dialog.dismiss();
//                StartActivity.this.finishAffinity();
//            }
//        });
//        ((TextView) dialog.findViewById(R.id.neutralAction)).setOnClickListener(new View.OnClickListener() {
//
//
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
    }

    public void setNotification() {
        int flags;
        if (Build.VERSION.SDK_INT >= 31) {
            flags = PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT;
        } else {
            flags = PendingIntent.FLAG_UPDATE_CURRENT;
        }
        ((AlarmManager) getSystemService(Context.ALARM_SERVICE)).setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis(), 10800000, PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmReceiver.class), flags));
    }
}
