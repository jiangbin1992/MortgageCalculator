package com.codebyte.instantloan.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

import cz.msebera.android.httpclient.protocol.HTTP;

public class BankDetail extends AppCompatActivity {
    TextView balanceNo;
    String bankBalance;
    String bankName;
    LinearLayout btnBank;
    ImageView btnBack;
    ImageView btnBalanceShare;
    CardView btnBankBalance;
    ImageView btnCareShare;
    CardView btnCustomerCare;
    TextView careNo;
    String customerCare;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_detail);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnBankBalance = (CardView) findViewById(R.id.btn_bank_balance);
        this.btnCustomerCare = (CardView) findViewById(R.id.btn_customer_care);
        this.btnBalanceShare = (ImageView) findViewById(R.id.btn_balance_share);
        this.btnCareShare = (ImageView) findViewById(R.id.btn_care_share);
        this.btnBank = (LinearLayout) findViewById(R.id.btn_Bank);
        this.balanceNo = (TextView) findViewById(R.id.balance_no);
        this.careNo = (TextView) findViewById(R.id.care_no);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.bankBalance = getIntent().getStringExtra("bankBalance");
        String stringExtra = getIntent().getStringExtra("bank_customer");
        this.customerCare = stringExtra;
        setNO(this.bankBalance, stringExtra);
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                BankDetail.this.BankDetail1(view);
            }
        });
        this.btnBalanceShare.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                BankDetail.this.BankDetail2(view);
            }
        });
        this.btnCareShare.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                BankDetail.this.BankDetail3(view);
            }
        });
        this.btnBankBalance.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                BankDetail.this.BankDetail4(view);
            }
        });
        this.btnCustomerCare.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                BankDetail.this.BankDetail5(view);
            }
        });
    }

    public void BankDetail1(View view) {
        onBackPressed();
    }

    public void BankDetail2(View view) {
        set_share(this.bankName, this.bankBalance);
    }

    public void BankDetail3(View view) {
        set_share(this.bankName, this.customerCare);
    }

    public void BankDetail4(View view) {
        ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("copy_link", this.balanceNo.getText().toString()));
        Toast.makeText(this, "Link Copy", Toast.LENGTH_SHORT).show();
    }

    public void BankDetail5(View view) {
        ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("copy_link", this.careNo.getText().toString()));
        Toast.makeText(this, "Link Copy", Toast.LENGTH_SHORT).show();
    }

    private void set_share(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str + "Bank Balance Chanking Number is here :" + str2);
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }

    public void setNO(String str, String str2) {
        this.balanceNo.setText(str);
        this.careNo.setText(str2);
    }
}
