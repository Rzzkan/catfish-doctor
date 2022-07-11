package com.example.doclele;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardHolder> {

    private ArrayList<SetterGetter> listdata;
    private Context context ;




    public DashboardAdapter(Context context,ArrayList<SetterGetter> listdata){
        this.context    = context;
        this.listdata   = listdata;
    }

    @NonNull
    @Override
    public DashboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view               = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        DashboardHolder holder  = new DashboardHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardHolder holder, int position) {
        final SetterGetter getData      = listdata.get(position);
        String titlemenu                = getData.getTitle();
        String logomenu                 = getData.getImg();

                //        Pemisah Lagi Buat Clik Biar Gak Bingung

        holder.titleMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Anda memilih : "+titlemenu,Snackbar.LENGTH_LONG).show();
                if (logomenu.equals("logomenu1")){
                    context.startActivity(new Intent(context, TanyaDokter.class));
                }else if (logomenu.equals("logomenu2")){
                    context.startActivity(new Intent(context, DaftarPakar.class));
                }else if (logomenu.equals("logomenu3")){
                    context.startActivity(new Intent(context, CaraPerawatan.class));
                }else if(logomenu.equals("logomenu4")){
                    context.startActivity(new Intent(context, About_Activity.class));
                }else if (logomenu.equals("logomenu5")) {
                    context.startActivity(new Intent(context, DaftarPenyakit.class));
                }else if (logomenu.equals("logomenu6")){
                    context.startActivity(new Intent(context, Bantuan1.class));
                }
            }
        });
        holder.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Anda memilih : "+titlemenu,Snackbar.LENGTH_LONG).show();
                if (logomenu.equals("logomenu1")){
                    context.startActivity(new Intent(context, TanyaDokter.class));
                }else if (logomenu.equals("logomenu2")){
                    context.startActivity(new Intent(context, DaftarPakar.class));
                }else if(logomenu.equals("logomenu4")){
                    context.startActivity(new Intent(context, About_Activity.class));
                }else if (logomenu.equals("logomenu3")){
                    context.startActivity(new Intent(context, CaraPerawatan.class));
                }else if (logomenu.equals("logomenu5")){
                    context.startActivity(new Intent(context, DaftarPenyakit.class));
                }else if (logomenu.equals("logomenu6")){
                    context.startActivity(new Intent(context, Bantuan1.class));
                }

            }
        });
                //        Pemisah Lagi Buat Gambar Biar Gak Spaneng
        holder.titleMenu.setText(titlemenu);
        if(logomenu.equals("logomenu1")){
            holder.imgMenu.setImageResource(R.drawable.doctor);
        }else if(logomenu.equals("logomenu5")) {
            holder.imgMenu.setImageResource(R.drawable.searchlist);
        }else if(logomenu.equals("logomenu2")){
            holder.imgMenu.setImageResource(R.drawable.jobsearch);
        }else if(logomenu.equals("logomenu3")){
            holder.imgMenu.setImageResource(R.drawable.healthcare);
        }else if(logomenu.equals("logomenu6")){
            holder.imgMenu.setImageResource(R.drawable.bantuan);
        }else if(logomenu.equals("logomenu4")){
            holder.imgMenu.setImageResource(R.drawable.information);
        }

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }



    public class DashboardHolder extends RecyclerView.ViewHolder {
        TextView titleMenu;
        ImageView imgMenu;

        public DashboardHolder(@NonNull View itemView) {
            super(itemView);

            titleMenu   = itemView.findViewById(R.id.tvTanyadokter);
            imgMenu     = itemView.findViewById(R.id.ivlogods1);

        }
    }
}
