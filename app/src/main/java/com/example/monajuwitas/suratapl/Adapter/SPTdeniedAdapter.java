package com.example.monajuwitas.suratapl.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.Model.SPTModel;
import com.example.monajuwitas.suratapl.R;

import java.util.ArrayList;
import java.util.List;

public class SPTdeniedAdapter extends RecyclerView.Adapter<SPTdeniedAdapter.Viewholder> {
    private List<SPTModel> mItems;

    public SPTdeniedAdapter(List<SPTModel> SPTModelList) {
        super();
        this.mItems = SPTModelList;
    }

    @NonNull
    @Override
    public SPTdeniedAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_spt, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SPTdeniedAdapter.Viewholder viewholder, int i) {
        SPTModel nature = mItems.get(i);
        viewholder.no.setText(nature.getNo());
        viewholder.tanggalpergi.setText(nature.getTanggal());
        viewholder.perihal.setText(nature.getPerihal());
        viewholder.statusbaca.setText(nature.getStatusbaca());
        viewholder.statusperiksa.setText(nature.getStatusperiksa());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView no, tanggalpergi, perihal, statusbaca, statusperiksa ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            no = (TextView)itemView.findViewById(R.id.no);
            tanggalpergi = (TextView)itemView.findViewById(R.id.tanggal);
            perihal = (TextView)itemView.findViewById(R.id.pengirim);
            statusbaca = (TextView)itemView.findViewById(R.id.perihal);
            statusperiksa = (TextView)itemView.findViewById(R.id.sttsperiksa);
        }
    }
}
