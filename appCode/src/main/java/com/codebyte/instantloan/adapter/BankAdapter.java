package com.codebyte.instantloan.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.codebyte.instantloan.BankListModel;
import com.codebyte.instantloan.R;
import com.codebyte.instantloan.activity.BankDetail;
import com.codebyte.instantloan.adutills.AdMobLoaderClass;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.ViewHolder> {
    Activity activity;
    Context context;
    ArrayList<BankListModel> titleName;

    public BankAdapter(Context context2, ArrayList<BankListModel> arrayList, Activity activity2) {
        this.context = context2;
        this.titleName = arrayList;
        this.activity = activity2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.bank_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        viewHolder.text_first_title.setText(this.titleName.get(i).getBankName().substring(0, 1));
        viewHolder.text_title.setText(this.titleName.get(i).getBankName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {


            public final void onClick(View view) {
                BankAdapter.this.BankAdapter(i, view);
            }
        });
    }

    public void BankAdapter(int i, View view) {
        new AdMobLoaderClass().showInterstitialAds(this.activity, new Intent(this.context, BankDetail.class).putExtra("banktag", this.titleName.get(i).getBankName()).putExtra("bank_balance", this.titleName.get(i).getBalance()).putExtra("bank_mini", this.titleName.get(i).getMini()).putExtra("bank_customer", this.titleName.get(i).getCustomer()));
    }

    @Override
    public int getItemCount() {
        return this.titleName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_Text;
        TextView text_first_title;
        TextView text_title;

        public ViewHolder(View view) {
            super(view);
            this.first_Text = (TextView) view.findViewById(R.id.text_first_title);
            this.text_title = (TextView) view.findViewById(R.id.text_title);
            this.text_first_title = (TextView) view.findViewById(R.id.text_first_title);
        }
    }
}
