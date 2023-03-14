package com.codebyte.instantloan.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codebyte.instantloan.R;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;
import com.codebyte.instantloan.adutills.AdUtils;

public class CalculatorActivity extends AppCompatActivity {
    ImageView btnCalculate;
    ImageView btnReset;
    ImageView btnBack;
    EditText editInterestRate;
    EditText editLoanAmount;
    EditText editLoanPeriod;
    TextView textMonthlyEMI;
    TextView textTotalIntrest;
    TextView textTotalPayment;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_calculator);
        AdUtils.bannerAd(this, (FrameLayout) findViewById(R.id.frame_banner), "native11111111111", true);
        AdUtils.nativeAd(this, (FrameLayout) findViewById(R.id.native_ad_PE_pkms), true, false);
        this.btnCalculate = (ImageView) findViewById(R.id.btn_Calculate);
        this.btnReset = (ImageView) findViewById(R.id.btn_Reset);
        this.editLoanAmount = (EditText) findViewById(R.id.edit_Loan_Amount);
        this.editInterestRate = (EditText) findViewById(R.id.edit_Interest_Rate);
        this.editLoanPeriod = (EditText) findViewById(R.id.edit_Loan_Period_M);
        this.textMonthlyEMI = (TextView) findViewById(R.id.text_Monthly_EMI);
        this.textTotalIntrest = (TextView) findViewById(R.id.text_Total_Intrest);
        this.textTotalPayment = (TextView) findViewById(R.id.text_Total_Payment);
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.btnCalculate.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                CalculatorActivity.this.CalculatorActivity1(view);
            }
        });
        this.btnReset.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                CalculatorActivity.this.CalculatorActivity2(view);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                CalculatorActivity.this.CalculatorActivity3(view);
            }
        });
    }

    public void CalculatorActivity1(View view) {
        String obj = this.editLoanAmount.getText().toString();
        String obj2 = this.editInterestRate.getText().toString();
        String obj3 = this.editLoanPeriod.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            Toast.makeText(this, "Enter Loan Amount", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(obj2)) {
            Toast.makeText(this, "Enter Interest Rate", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(obj3)) {
            Toast.makeText(this, "Enter Loan Period", Toast.LENGTH_SHORT).show();
        } else {
            Double valueOf = Double.valueOf(Double.parseDouble(obj));
            Double valueOf2 = Double.valueOf(Double.parseDouble(obj2));
            Double valueOf3 = Double.valueOf(Double.parseDouble(obj3));
            Double valueOf4 = Double.valueOf(((valueOf.doubleValue() * valueOf2.doubleValue()) / 100.0d) * valueOf3.doubleValue());
            Double valueOf5 = Double.valueOf(valueOf.doubleValue() + valueOf4.doubleValue());
            Double valueOf6 = Double.valueOf(valueOf5.doubleValue() / valueOf3.doubleValue());
            long round = Math.round(valueOf4.doubleValue());
            long round2 = Math.round(valueOf5.doubleValue());
            long round3 = Math.round(valueOf6.doubleValue());
            TextView textView = this.textMonthlyEMI;
            textView.setText(String.valueOf(round3) + " ₹");
            TextView textView2 = this.textTotalIntrest;
            textView2.setText(String.valueOf(round) + " ₹");
            TextView textView3 = this.textTotalPayment;
            textView3.setText("" + round2 + " ₹");
        }
    }

    public void CalculatorActivity2(View view) {
        this.editLoanAmount.setText("");
        this.editInterestRate.setText("");
        this.editLoanPeriod.setText("");
        this.textMonthlyEMI.setText("0 ₹");
        this.textTotalIntrest.setText("0 ₹");
        this.textTotalPayment.setText("0 ₹");
    }

    public void CalculatorActivity3(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        new AdMobLoaderClass().showInterstitialOnBackAds(this);
        super.onBackPressed();
    }
}
