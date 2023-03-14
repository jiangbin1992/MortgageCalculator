package com.codebyte.instantloan.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

public class DetailActivity2 extends AppCompatActivity {
    ImageView btnBack;
    ImageView btnCopy;
    ImageView btnSend;
    int i = 0;
    ImageView imgTitleLogo;
    TextView phoneNo;
    String tag;
    TextView textBody;
    LinearLayout viewBalanceOnline;
    LinearLayout viewBalanceOnline2;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail2);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.viewBalanceOnline = (LinearLayout) findViewById(R.id.view_balance_online);
        this.viewBalanceOnline2 = (LinearLayout) findViewById(R.id.view_balance_online2);
        this.btnSend = (ImageView) findViewById(R.id.btn_send);
        this.btnCopy = (ImageView) findViewById(R.id.btn_copy);
        this.phoneNo = (TextView) findViewById(R.id.phone_no);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.textBody = (TextView) findViewById(R.id.text_body);
        this.imgTitleLogo = (ImageView) findViewById(R.id.img_title_logo);
        String stringExtra = getIntent().getStringExtra("Detail_Activty2");
        this.tag = stringExtra;
        if (stringExtra.equals("balance_online")) {
            this.viewBalanceOnline2.setVisibility(View.VISIBLE);
            this.viewBalanceOnline.setVisibility(View.GONE);
            this.btnSend.setImageResource(R.drawable.send);
            this.btnCopy.setImageResource(R.drawable.detail_copy);
            this.textBody.setText("Check Your PF Balance Without Internet Through");
            this.imgTitleLogo.setImageResource(R.drawable.detail2_message);
            this.i = 1;
        } else if (this.tag.equals("balance_online_2")) {
            this.viewBalanceOnline2.setVisibility(View.GONE);
            this.viewBalanceOnline.setVisibility(View.VISIBLE);
            this.btnSend.setImageResource(R.drawable.detail_call);
            this.btnCopy.setImageResource(R.drawable.detail_copy);
            this.textBody.setText("Check Your PF Balance Without Internet Through");
            this.imgTitleLogo.setImageResource(R.drawable.pf_balance);
            this.i = 2;
        } else if (this.tag.equals("helpline")) {
            this.viewBalanceOnline2.setVisibility(View.GONE);
            this.viewBalanceOnline.setVisibility(View.VISIBLE);
            this.btnSend.setImageResource(R.drawable.detail_call);
            this.btnCopy.setImageResource(R.drawable.detail_copy);
            this.textBody.setText("Helpline Nubmer Solve Your Query Related EPF by just Giving a Call on Toll Free Number");
            this.imgTitleLogo.setImageResource(R.drawable.detail2_helpline);
            this.phoneNo.setText("1800118005");
            this.i = 3;
        }
        this.btnSend.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                DetailActivity2.this.DetailActivity1(view);
            }
        });
        this.btnCopy.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                DetailActivity2.this.DetailActivity2(view);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                DetailActivity2.this.DetailActivity3(view);
            }
        });
    }

    public void DetailActivity1(View view) {
        int i2 = this.i;
        if (i2 == 1) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("smsto:7738299899"));
            intent.setType("vnd.android-dir/mms-sms");
            intent.putExtra("address", new String("7738299899"));
            intent.putExtra("sms_body", "EPFOHO UAN ENG to 7738299899 ");
            startActivity(intent);
        } else if (i2 == 2) {
            Intent intent2 = new Intent("android.intent.action.DIAL");
            intent2.setData(Uri.parse("tel:1800118005"));
            startActivity(intent2);
        } else if (i2 == 3) {
            Intent intent3 = new Intent("android.intent.action.DIAL");
            intent3.setData(Uri.parse("tel:1800118005"));
            startActivity(intent3);
        }
    }

    public void DetailActivity2(View view) {
        ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("copy_link", this.phoneNo.getText().toString()));
        Toast.makeText(this, "Link Copy", Toast.LENGTH_SHORT).show();
    }

    public void DetailActivity3(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
