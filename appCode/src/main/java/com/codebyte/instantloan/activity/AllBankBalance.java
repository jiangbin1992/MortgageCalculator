package com.codebyte.instantloan.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codebyte.instantloan.BankData;
import com.codebyte.instantloan.BankListModel;
import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adapter.BankAdapter;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

import java.util.ArrayList;

public class AllBankBalance extends AppCompatActivity {
    BankData bankData = new BankData();
    ImageView btnBack;
    RecyclerView recyclerview;
    ArrayList<BankListModel> titleName = new ArrayList<>();


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_all_bank_balance);
        this.recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        ArrayList<BankListModel> bankList = this.bankData.getBankList();
        this.titleName = bankList;
        BankAdapter bankAdapter = new BankAdapter(this, bankList, this);
        this.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerview.setAdapter(bankAdapter);
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                AllBankBalance.this.AllBankBalance(view);
            }
        });
    }

    public void AllBankBalance(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
