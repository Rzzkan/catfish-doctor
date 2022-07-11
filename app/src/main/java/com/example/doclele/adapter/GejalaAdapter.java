package com.example.doclele.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doclele.R;
import com.example.doclele.model.gejala.ModelGejala;

import java.util.ArrayList;
import java.util.List;

public class GejalaAdapter extends RecyclerView.Adapter<GejalaAdapter.ViewHolder> {

    private List<ModelGejala.Result> results;
    private OnValueChangeListener valueListener;
    private OnItemClickListener mOnItemClickListener;
    private Context ctx;

    public GejalaAdapter (Context ctx, List<ModelGejala.Result> results){
        this.results = results;
        this.ctx = ctx;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public void setOnVaueChangeListener(final OnValueChangeListener mChangeListener) {
        this.valueListener = mChangeListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_gejala, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull GejalaAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ModelGejala.Result result = results.get(position);
        holder.chk1.setText(result.getCiri_ciri());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(view,results.get(position),position);
                }
            }
        });
        holder.chk1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (valueListener != null){
                            valueListener.onValueChange(results.get(position),position, isChecked);
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox chk1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chk1    = itemView.findViewById(R.id.cb_gejala);
        }
    }
    public void setData(List<ModelGejala.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();

    }

    public interface OnItemClickListener {
        void onItemClick(View view, ModelGejala.Result obj, int position);
    }


    public interface OnValueChangeListener{
        void onValueChange (ModelGejala.Result obj, int position, Boolean checked);
    }
}
