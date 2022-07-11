package com.example.doclele.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doclele.R;
import com.example.doclele.model.pakar.ModelPakar;

import java.util.List;

public class PakarAdapter extends RecyclerView.Adapter<PakarAdapter.ViewHolder> {

    private List<ModelPakar.Result> results;
    private OnAdapterListener listener;


    public PakarAdapter(List<ModelPakar.Result> results, OnAdapterListener listener){
        this.results = results;
        this.listener   = listener;
    }


    @NonNull
    @Override
    public PakarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelPakar.Result result = results.get(position);
        holder.tv_name.setText(result.getNama());
        holder.iv_user.setImageResource(R.drawable.user);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(result);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user;
        TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user     = itemView.findViewById(R.id.imageView);
            tv_name     = itemView.findViewById(R.id.textView);

        }
    }
    public void setData(List<ModelPakar.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
    public interface OnAdapterListener{
        void onClick(ModelPakar.Result result);

    }
}
