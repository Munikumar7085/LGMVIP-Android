package com.example.covid_19tracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19tracker.R;
import com.example.covid_19tracker.models.Model;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StateAdapter  extends RecyclerView.Adapter<StateAdapter.stateViewHolder>{
    Context context;
    ArrayList<Model> list;
    OnCardClickListener mOnCardClickListener;
    public StateAdapter(Context context, ArrayList<Model> list, OnCardClickListener mOnCardClickListener)
    {
        this.context=context;
        this.list=list;
        this.mOnCardClickListener=mOnCardClickListener;
    }

    @NonNull
    @Override
    public stateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.testing,parent,false);
        return new stateViewHolder(view,mOnCardClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull stateViewHolder holder, int position) {
      Model m= list.get(position);
      holder.title.setText(m.location);
      holder.active.setText(String.valueOf(m.active));
      holder.confirmed.setText(String.valueOf(m.confirmed));
      holder.deceased.setText(String.valueOf(m.deceased));
      holder.recovered.setText(String.valueOf(m.recovered));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class stateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView active;
        TextView confirmed;
        TextView deceased;
        TextView recovered;
        OnCardClickListener mOnCardClickListener;
        public stateViewHolder(@NonNull View itemView,OnCardClickListener mOnCardClickListener) {
            super(itemView);
            title=itemView.findViewById(R.id.title_txt);
            active=itemView.findViewById(R.id.active_test);
            confirmed=itemView.findViewById(R.id.confirmed_test);
            deceased=itemView.findViewById(R.id.deceased_test);
            recovered=itemView.findViewById(R.id.recovered_test);
            this.mOnCardClickListener=mOnCardClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnCardClickListener.onCardClick(getAdapterPosition());
        }
    }
    public interface OnCardClickListener{
        public void onCardClick(int position);

    }
}
