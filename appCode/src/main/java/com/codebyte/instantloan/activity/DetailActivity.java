package com.codebyte.instantloan.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

public class DetailActivity extends AppCompatActivity {
    ImageView btnBack;
    ImageView btnCopyLink;
    ConstraintLayout imgBg;
    String tag;
    TextView textAnsware;
    TextView textQuestion;
    TextView textTitle;
    TextView textWarning;
    int track;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detail);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.imgBg = (ConstraintLayout) findViewById(R.id.img_bg);
        this.btnCopyLink = (ImageView) findViewById(R.id.btn_copy_link);
        this.textQuestion = (TextView) findViewById(R.id.text_Question);
        this.textAnsware = (TextView) findViewById(R.id.text_Answare);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.textTitle = (TextView) findViewById(R.id.text_title);
        this.textWarning = (TextView) findViewById(R.id.text_warning);
        this.tag = getIntent().getStringExtra("tag");
        int intExtra = getIntent().getIntExtra("tracker", 0);
        this.track = intExtra;
        if (intExtra == 1) {
            this.textTitle.setText("Detail");
            this.btnCopyLink.setVisibility(View.GONE);
            this.textWarning.setVisibility(View.GONE);
            this.btnCopyLink.setImageResource(R.drawable.copy_link);
        } else if (intExtra == 2) {
            this.textTitle.setText("Loan Tips");
            this.btnCopyLink.setVisibility(View.VISIBLE);
            this.textWarning.setVisibility(View.VISIBLE);
            this.btnCopyLink.setImageResource(R.drawable.copy_link);
        } else if (intExtra == 0) {
            this.textTitle.setText("Detail");
            this.btnCopyLink.setVisibility(View.VISIBLE);
            this.textWarning.setVisibility(View.VISIBLE);
            this.btnCopyLink.setImageResource(R.drawable.copy_link);
        }
        this.btnCopyLink.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                DetailActivity.this.DetailActivity1(view);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                DetailActivity.this.DetailActivity2(view);
            }
        });
        int i = this.track;
        if (i == 1) {
            if (this.tag.equals("1")) {
                this.textQuestion.setText("Home Loan");
                this.textAnsware.setText(R.string.InstantLoanGuide1);
            } else if (this.tag.equals("2")) {
                this.textQuestion.setText("Car Loan");
                this.textAnsware.setText(R.string.InstantLoanGuide2);
            } else if (this.tag.equals("3")) {
                this.textQuestion.setText("Education Loan");
                this.textAnsware.setText(R.string.InstantLoanGuide3);
            } else if (this.tag.equals("4")) {
                this.textQuestion.setText("Personal Loan");
                this.textAnsware.setText(R.string.InstantLoanGuide4);
            } else if (this.tag.equals("5")) {
                this.textQuestion.setText("Buisness Loan");
                this.textAnsware.setText(R.string.InstantLoanGuide5);
            } else if (this.tag.equals("6")) {
                this.textQuestion.setText("Gold Loan");
                this.textAnsware.setText(R.string.InstantLoanGuide6);
            }
        } else if (i == 2) {
            if (this.tag.equals("1")) {
                this.textQuestion.setText("Establishment Registration");
                this.textAnsware.setText(R.string.EPFService1);
            } else if (this.tag.equals("2")) {
                this.textQuestion.setText("KYC Updation");
                this.textAnsware.setText(R.string.EPFService2);
            } else if (this.tag.equals("3")) {
                this.textQuestion.setText("UMANG");
                this.textAnsware.setText(R.string.EPFService3);
            } else if (this.tag.equals("4")) {
                this.textQuestion.setText("ECR/Return and Payments");
                this.textAnsware.setText(R.string.EPFService4);
            } else if (this.tag.equals("5")) {
                this.textQuestion.setText("Online Claims Account Transfer");
                this.textAnsware.setText(R.string.EPFService5);
            } else if (this.tag.equals("6")) {
                this.textQuestion.setText("E-Passbook");
                this.textAnsware.setText(R.string.EPFService6);
            } else if (this.tag.equals("7")) {
                this.textQuestion.setText("Sharam Suvidha Common ECR");
                this.textAnsware.setText(R.string.EPFService7);
            } else if (this.tag.equals("8")) {
                this.textQuestion.setText("Pensioners Portal");
                this.textAnsware.setText(R.string.EPFService8);
            } else if (this.tag.equals("9")) {
                this.textQuestion.setText("International Workers Portal");
                this.textAnsware.setText(R.string.EPFService9);
            } else if (this.tag.equals("your_Claim")) {
                this.textTitle.setText("Apply");
                this.textQuestion.setText("Your Claim Status");
                this.textAnsware.setText(R.string.EPFOnline23);
            } else if (this.tag.equals("member_claim")) {
                this.textTitle.setText("Apply");
                this.textQuestion.setText("Member Claim Status");
                this.textAnsware.setText(R.string.EPFOnline23);
            } else if (this.tag.equals("apply_claim")) {
                this.textTitle.setText("Apply");
                this.textQuestion.setText("Apply for Status");
                this.textAnsware.setText(R.string.EPFOnline23);
            }
        }
        if (this.tag.equals("buisness_loan")) {
            this.textQuestion.setText("Business Loan");
            this.textAnsware.setText(R.string.LoanType1);
        } else if (this.tag.equals("personal_loan")) {
            this.textQuestion.setText("Personal Loan");
            this.textAnsware.setText(R.string.balance_online);
        } else if (this.tag.equals("home_loan")) {
            this.textQuestion.setText("Home Loan");
            this.textAnsware.setText(R.string.LoanType3);
        } else if (this.tag.equals("education_loan")) {
            this.textQuestion.setText("Education Loan");
            this.textAnsware.setText(R.string.LoanType4);
        } else if (this.tag.equals("car_loan")) {
            this.textQuestion.setText("Car Loan");
            this.textAnsware.setText(R.string.LoanType5);
        } else if (this.tag.equals("gold_loan")) {
            this.textQuestion.setText("Gold Loan");
            this.textAnsware.setText(R.string.LoanType6);
        } else if (this.tag.equals("Activate_UNA")) {
            this.textQuestion.setText("Activate UNA");
            this.textAnsware.setText(R.string.EPFOnline11);
        } else if (this.tag.equals("Pensioners")) {
            this.textQuestion.setText("Pensioners");
            this.textAnsware.setText(R.string.EPFOnline13);
        } else if (this.tag.equals("TRRN_Status")) {
            this.textQuestion.setText("TRRN Status");
            this.textAnsware.setText(R.string.EPFOnline14);
        } else if (this.tag.equals("FAQ")) {
            this.textQuestion.setText("FAQ");
            this.textAnsware.setText(R.string.EPFOnline19);
        } else if (this.tag.equals("News")) {
            this.textQuestion.setText("News");
            this.textAnsware.setText(R.string.news);
        } else if (this.tag.equals("EPF_service")) {
            this.textQuestion.setText("EPF Service");
            this.textAnsware.setText(R.string.EPFOnline21);
        } else if (this.tag.equals("locate_office")) {
            this.textQuestion.setText("Locate Office");
            this.textAnsware.setText(R.string.locate_office);
        } else if (this.tag.equals("balanceonline")) {
            this.textQuestion.setText("Balance (Online)");
            this.textAnsware.setText(R.string.balance_online);
        } else if (this.tag.equals("epf_online_title1_detail")) {
            this.textQuestion.setText("Check Your EPF");
            this.textAnsware.setText(R.string.epf_online_title1_detail);
        } else if (this.tag.equals("epf_online_title2_detail")) {
            this.textQuestion.setText("Claim");
            this.textAnsware.setText(R.string.epf_online_title2_detail);
        } else if (this.tag.equals("epf_online_title3_detail")) {
            this.textQuestion.setText("Online");
            this.textAnsware.setText(R.string.epf_online_title3_detail);
        } else if (this.tag.equals("epf_online_title4_detail")) {
            this.textQuestion.setText("Member-Card");
            this.textAnsware.setText(R.string.epf_online_title4_detail);
        } else if (this.tag.equals("epf_online_title5_detail")) {
            this.textQuestion.setText("Download");
            this.textAnsware.setText(R.string.epf_online_title5_detail);
        } else if (this.tag.equals("epf_online_title6_detail")) {
            this.textQuestion.setText("Multi PF");
            this.textAnsware.setText(R.string.epf_online_title6_detail);
        } else if (this.tag.equals("epf_online_title7_detail")) {
            this.textQuestion.setText("E-Passbood");
            this.textAnsware.setText(R.string.epf_online_title7_detail);
        } else if (this.tag.equals("epf_online_title8_detail")) {
            this.textQuestion.setText("Downloads");
            this.textAnsware.setText(R.string.epf_online_title8_detail);
        } else if (this.tag.equals("epf_online_title9_detail")) {
            this.textQuestion.setText("Recurirement");
            this.textAnsware.setText(R.string.epf_online_title9_detail);
        } else if (this.tag.equals("epf_online_title10_detail")) {
            this.textQuestion.setText("Tender");
            this.textAnsware.setText(R.string.epf_online_title10_detail);
        } else if (this.tag.equals("epf_online_title11_detail")) {
            this.textQuestion.setText("R.T.I");
            this.textAnsware.setText(R.string.epf_online_title11_detail);
        } else if (this.tag.equals("epf_online_title12_detail")) {
            this.textQuestion.setText("Contact Us");
            this.textAnsware.setText(R.string.epf_online_title12_detail);
        }
    }

    public void DetailActivity1(View view) {
        set_copy_link(this.tag);
    }

    public void DetailActivity2(View view) {
        onBackPressed();
    }

    private void set_copy_link(String str) {
        ClipData clipData;
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if (this.tag.equals("1")) {
            clipData = ClipData.newPlainText("copy_link", "https://registration.shramsuvidha.gov.in/user/login");
        } else if (this.tag.equals("2")) {
            clipData = ClipData.newPlainText("copy_link", "https://unifiedportal-mem.epfindia.gov.in/memberinterface/");
        } else if (this.tag.equals("3")) {
            clipData = ClipData.newPlainText("copy_link", "https://unifiedportal-mem.epfindia.gov.in/memberinterface/");
        } else if (this.tag.equals("4")) {
            clipData = ClipData.newPlainText("copy_link", "https://unifiedportal-emp.epfindia.gov.in/epfo/");
        } else if (this.tag.equals("5")) {
            clipData = ClipData.newPlainText("copy_link", "https://epfindia.gov.in/site_en/index.php");
        } else if (this.tag.equals("6")) {
            clipData = ClipData.newPlainText("copy_link", "https://passbook.epfindia.gov.in/MemberPassBook/Login.jsp");
        } else if (this.tag.equals("7")) {
            clipData = ClipData.newPlainText("copy_link", "https://return.shramsuvidha.gov.in/user/login");
        } else if (this.tag.equals("8")) {
            clipData = ClipData.newPlainText("copy_link", "https://mis.epfindia.gov.in/PensionPaymentEnquiry/enquiry.jsp");
        } else if (this.tag.equals("9")) {
            clipData = ClipData.newPlainText("copy_link", "https://iwu.epfindia.gov.in/iwu/");
        } else if (this.tag.equals("10")) {
            clipData = ClipData.newPlainText("copy_link", "https://iwu.epfindia.gov.in/eKYC/");
        } else if (this.tag.equals("your_Claim")) {
            clipData = ClipData.newPlainText("copy_link", "https://www.epfindia.gov.in/site_en/Downloads.php?id=sm8_index");
        } else if (this.tag.equals("member_claim")) {
            clipData = ClipData.newPlainText("copy_link", "https://www.epfindia.gov.in/site_en/Downloads.php?id=sm8_index");
        } else if (this.tag.equals("apply_claim")) {
            clipData = ClipData.newPlainText("copy_link", "https://www.epfindia.gov.in/site_en/Downloads.php?id=sm8_index");
        } else if (this.tag.equals("Activate_UNA")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Activate_UAN));
        } else if (this.tag.equals("Pensioners")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Pensioners));
        } else if (this.tag.equals("TRRN_Status")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_TRRN_status));
        } else if (this.tag.equals("FAQ")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_FAQs));
        } else if (this.tag.equals("News")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_News));
        } else if (this.tag.equals("locate_office")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Locate_Office));
        } else if (this.tag.equals("balanceonline")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_BalanceOnline));
        } else if (this.tag.equals("epf_online_title1_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Check_Your_EPF));
        } else if (this.tag.equals("epf_online_title2_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.cliam_link));
        } else if (this.tag.equals("epf_online_title3_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Online_Transfer_Claims_Portal_OTCP));
        } else if (this.tag.equals("epf_online_title4_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Member_Passbook));
        } else if (this.tag.equals("epf_online_title5_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Download_Claim_Form));
        } else if (this.tag.equals("epf_online_title6_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Multiple_PF_Accounts_of_an_Employee));
        } else if (this.tag.equals("epf_online_title7_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_E_Passbook));
        } else if (this.tag.equals("epf_online_title8_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Downloads));
        } else if (this.tag.equals("epf_online_title9_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_Recruitments));
        } else if (this.tag.equals("epf_online_title10_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.linnk_Tenders));
        } else if (this.tag.equals("epf_online_title11_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_RTI));
        } else if (this.tag.equals("epf_online_title12_detail")) {
            clipData = ClipData.newPlainText("copy_link", getResources().getString(R.string.link_contact_US));
        } else {
            clipData = ClipData.newPlainText("copy_link", "https://registration.shramsuvidha.gov.in/user/login");
        }
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this, "Link Copy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
