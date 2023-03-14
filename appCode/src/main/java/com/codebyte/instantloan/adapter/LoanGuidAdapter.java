package com.codebyte.instantloan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.codebyte.instantloan.R;

import java.util.ArrayList;

public class LoanGuidAdapter extends RecyclerView.Adapter<LoanGuidAdapter.ViewHolder> {
    Context context;
    ArrayList<Integer> itemDetails = new ArrayList<>();
    OnItemClickListener onItemClickListener;
    int track;

    public LoanGuidAdapter(Context context2, ArrayList<Integer> arrayList, OnItemClickListener onItemClickListener2, int i) {
        this.context = context2;
        this.itemDetails = arrayList;
        this.onItemClickListener = onItemClickListener2;
        this.track = i;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.text_title.setImageResource(this.itemDetails.get(i).intValue());
    }

    @Override
    public int getItemCount() {
        return this.itemDetails.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int i, int i2);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView text_title;

        public ViewHolder(View view) {
            super(view);
            this.text_title = (ImageView) view.findViewById(R.id.text_title);
            view.setOnClickListener(new View.OnClickListener() {


                public final void onClick(View view) {
                    LoanGuidAdapter.ViewHolder.this.lambda$new$0$LoanGuidAdapter$ViewHolder(view);
                }
            });
        }

        public void lambda$new$0$LoanGuidAdapter$ViewHolder(View view) {
            LoanGuidAdapter.this.onItemClickListener.onItemClick(getAdapterPosition(), LoanGuidAdapter.this.track);
        }
    }
}
