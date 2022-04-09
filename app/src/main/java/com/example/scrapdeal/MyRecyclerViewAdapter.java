package com.example.scrapdeal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{
    private List<String> mData;
    private List<Buyer_details> dataset;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data,List<Buyer_details> dataset) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.dataset=dataset;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview__row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        String n = (dataset.get(position)).Name();
        String r = dataset.get(position).Rate();
        String w = dataset.get(position).Waste();
        String d = dataset.get(position).Description();

        holder.waste.setText(w);
        holder.industryname.setText(n);
        holder.description.setText(w);
        holder.rate.setText(d);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView industryname;
        TextView waste;
        TextView description;
        TextView rate;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.industryname);
            waste = itemView.findViewById(R.id.waste);
            description = itemView.findViewById(R.id.description);
            rate = itemView.findViewById(R.id.rate);
            industryname= itemView.findViewById(R.id.industryname);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
