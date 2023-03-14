package com.codebyte.instantloan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

public class EPFOnline extends AppCompatActivity {
    ImageView btn_RTI;
    ImageView btn_back;
    ImageView btn_check_epf;
    ImageView btn_claim;
    ImageView btn_contact_us;
    ImageView btn_donwloads;
    ImageView btn_donwnload;
    ImageView btn_e_Passbook;
    ImageView btn_member;
    ImageView btn_multi_pf;
    ImageView btn_online;
    ImageView btn_requirement;
    ImageView btn_tender;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_epf_online);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btn_check_epf = (ImageView) findViewById(R.id.btn_check_epf);
        this.btn_claim = (ImageView) findViewById(R.id.btn_claim);
        this.btn_online = (ImageView) findViewById(R.id.btn_online);
        this.btn_member = (ImageView) findViewById(R.id.btn_member);
        this.btn_donwnload = (ImageView) findViewById(R.id.btn_donwnload);
        this.btn_multi_pf = (ImageView) findViewById(R.id.btn_multi_pf);
        this.btn_e_Passbook = (ImageView) findViewById(R.id.btn_e_Passbook);
        this.btn_donwloads = (ImageView) findViewById(R.id.btn_donwloads);
        this.btn_requirement = (ImageView) findViewById(R.id.btn_requirement);
        this.btn_tender = (ImageView) findViewById(R.id.btn_tender);
        this.btn_RTI = (ImageView) findViewById(R.id.btn_RTI);
        this.btn_contact_us = (ImageView) findViewById(R.id.btn_contact_us);
        this.btn_back = (ImageView) findViewById(R.id.btn_back);
        this.btn_check_epf.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$0$EPFOnline(view);
            }
        });
        this.btn_claim.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$1$EPFOnline(view);
            }
        });
        this.btn_online.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$2$EPFOnline(view);
            }
        });
        this.btn_member.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$3$EPFOnline(view);
            }
        });
        this.btn_donwnload.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$4$EPFOnline(view);
            }
        });
        this.btn_multi_pf.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$5$EPFOnline(view);
            }
        });
        this.btn_e_Passbook.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$6$EPFOnline(view);
            }
        });
        this.btn_donwloads.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$7$EPFOnline(view);
            }
        });
        this.btn_requirement.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$8$EPFOnline(view);
            }
        });
        this.btn_tender.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$9$EPFOnline(view);
            }
        });
        this.btn_RTI.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$10$EPFOnline(view);
            }
        });
        this.btn_contact_us.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$11$EPFOnline(view);
            }
        });
        this.btn_back.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFOnline.this.lambda$onCreate$12$EPFOnline(view);
            }
        });
    }

    public void lambda$onCreate$0$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title1_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$1$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title2_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$2$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title3_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$3$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title4_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$4$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title5_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$5$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title6_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$6$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title7_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$7$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title8_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$8$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title9_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$9$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title10_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$10$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title11_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$11$EPFOnline(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "epf_online_title12_detail").putExtra("tracker", 0));
    }

    public void lambda$onCreate$12$EPFOnline(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
