package com.codebyte.instantloan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adapter.LoanGuidAdapter;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

import java.util.ArrayList;

public class LoanGuide extends AppCompatActivity implements LoanGuidAdapter.OnItemClickListener {
    ImageView btnBack;
    ArrayList<Integer> itemDetails = new ArrayList<>();
    RecyclerView recycler;
    TextView textTitle;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_loan_guide);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.textTitle = (TextView) findViewById(R.id.text_title);
        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                LoanGuide.this.LoanGuide(view);
            }
        });
        this.textTitle.setText("Loan Guide");
        this.itemDetails.add(Integer.valueOf((int) R.drawable.home_loan));
        this.itemDetails.add(Integer.valueOf((int) R.drawable.car_loan));
        this.itemDetails.add(Integer.valueOf((int) R.drawable.education_loan));
        this.itemDetails.add(Integer.valueOf((int) R.drawable.personal_loan));
        this.itemDetails.add(Integer.valueOf((int) R.drawable.business_loan));
        this.itemDetails.add(Integer.valueOf((int) R.drawable.gold_loan));
        LoanGuidAdapter loanGuidAdapter = new LoanGuidAdapter(this, this.itemDetails, this, 1);
        this.recycler.setLayoutManager(new LinearLayoutManager(this));
        this.recycler.setAdapter(loanGuidAdapter);
    }

    public void LoanGuide(View view) {
        onBackPressed();
    }

    @Override
    public void onItemClick(int i, int i2) {
        switch (i) {
            case 0:
                opentrack("1", i2);
                return;
            case 1:
                opentrack("2", i2);
                return;
            case 2:
                opentrack("3", i2);
                return;
            case 3:
                opentrack("4", i2);
                return;
            case 4:
                opentrack("5", i2);
                return;
            case 5:
                opentrack("6", i2);
                return;
            case 6:
                opentrack("7", i2);
                return;
            case 7:
                opentrack("8", i2);
                return;
            case 8:
                opentrack("9", i2);
                return;
            case 9:
                opentrack("10", i2);
                return;
            case 10:
                opentrack("11", i2);
                return;
            case 11:
                opentrack("12", i2);
                return;
            default:
                return;
        }
    }

    public void opentrack(String str, int i) {
        new AdMobLoaderClass().showInterstitialAds(this, new Intent(this, DetailActivity.class).putExtra("tag", str).putExtra("tracker", i));
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
