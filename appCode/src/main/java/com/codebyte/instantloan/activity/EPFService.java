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

public class EPFService extends AppCompatActivity {
    ImageView btnLocateOffice;
    ImageView btnActivityUna;
    ImageView btnBack;
    ImageView btnBalanceCall;
    ImageView btnBalanceOnline;
    ImageView btnBalanceSms;
    ImageView btnClaim;
    ImageView btnFaq;
    ImageView btnHelpline;
    ImageView btnPensioners;
    ImageView btnTrrnStatus;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_e_p_f__service);
        this.btnActivityUna = (ImageView) findViewById(R.id.btn_activity_una);
        this.btnBalanceOnline = (ImageView) findViewById(R.id.btn_balance_online);
        this.btnPensioners = (ImageView) findViewById(R.id.btn_pensioners);
        this.btnTrrnStatus = (ImageView) findViewById(R.id.btn_trrn_status);
        this.btnClaim = (ImageView) findViewById(R.id.btn_claim);
        this.btnBalanceCall = (ImageView) findViewById(R.id.btn_balance_call);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.btnBalanceSms = (ImageView) findViewById(R.id.btn_balance_sms);
        this.btnFaq = (ImageView) findViewById(R.id.btn_faq);
        this.btnLocateOffice = (ImageView) findViewById(R.id.btn_Locate_Office);
        this.btnHelpline = (ImageView) findViewById(R.id.btn_helpline);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnActivityUna.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService1(view);
            }
        });
        this.btnBalanceOnline.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService2(view);
            }
        });
        this.btnPensioners.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService3(view);
            }
        });
        this.btnTrrnStatus.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService4(view);
            }
        });
        this.btnClaim.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService5(view);
            }
        });
        this.btnBalanceCall.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService6(view);
            }
        });
        this.btnBalanceSms.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService7(view);
            }
        });
        this.btnFaq.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService8(view);
            }
        });
        this.btnLocateOffice.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService9(view);
            }
        });
        this.btnHelpline.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService10(view);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                EPFService.this.EPFService11(view);
            }
        });
    }

    public void EPFService1(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "Activate_UNA").putExtra("tracker", 0));
    }

    public void EPFService2(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "balanceonline").putExtra("tracker", 0));
    }

    public void EPFService3(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "Pensioners").putExtra("tracker", 0));
    }

    public void EPFService4(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "TRRN_Status").putExtra("tracker", 0));
    }

    public void EPFService5(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, ClaimActivity.class));
    }

    public void EPFService6(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity2.class).putExtra("Detail_Activty2", "balance_online_2"));
    }

    public void EPFService7(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity2.class).putExtra("Detail_Activty2", "balance_online"));
    }

    public void EPFService8(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "FAQ").putExtra("tracker", 0));
    }

    public void EPFService9(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "locate_office").putExtra("tracker", 0));
    }

    public void EPFService10(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity2.class).putExtra("Detail_Activty2", "helpline"));
    }

    public void EPFService11(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
