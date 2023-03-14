package com.codebyte.instantloan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

public class ClaimActivity extends AppCompatActivity {
    LinearLayout btnApplyForClaim;
    LinearLayout btnMemberClaimStatus;
    LinearLayout btnYourClaimStatus;
    ImageView btnBack;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_claim);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnYourClaimStatus = (LinearLayout) findViewById(R.id.btn_Your_Claim_Status);
        this.btnMemberClaimStatus = (LinearLayout) findViewById(R.id.btn_Member_Claim_Status);
        this.btnApplyForClaim = (LinearLayout) findViewById(R.id.btn_Apply_for_Claim);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.btnYourClaimStatus.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                ClaimActivity.this.ClaimActivity1(view);
            }
        });
        this.btnMemberClaimStatus.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                ClaimActivity.this.ClaimActivity2(view);
            }
        });
        this.btnApplyForClaim.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                ClaimActivity.this.ClaimActivity3(view);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                ClaimActivity.this.ClaimActivity4(view);
            }
        });
    }

    public void ClaimActivity1(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "your_Claim").putExtra("tracker", 2));
    }

    public void ClaimActivity2(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "member_claim").putExtra("tracker", 2));
    }

    public void ClaimActivity3(View view) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", "apply_claim").putExtra("tracker", 2));
    }

    public void ClaimActivity4(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
