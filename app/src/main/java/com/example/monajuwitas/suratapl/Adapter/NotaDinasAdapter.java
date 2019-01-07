package com.example.monajuwitas.suratapl.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.Model.NDModel;
import com.example.monajuwitas.suratapl.R;

import java.util.ArrayList;
import java.util.List;

public class NotaDinasAdapter extends RecyclerView.Adapter<NotaDinasAdapter.Viewholder> {
    private List<NDModel> mItems;
    public NotaDinasAdapter(List<NDModel> NDModelList) {
        super();
        this.mItems = NDModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_notadinas, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        NDModel ndModel = mItems.get(i);
        viewholder.nosurat.setText(ndModel.getNosurat());
        viewholder.tanggalpergi.setText(ndModel.getTanggal());
        viewholder.tanggalpulang.setText(ndModel.getTglkwmbali());
        viewholder.perihal.setText(ndModel.getPerihal());
        viewholder.statusperiksa.setText(ndModel.getStatusperiksa());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView nosurat, tanggalpergi, tanggalpulang, perihal, statusperiksa;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nosurat = (TextView)itemView.findViewById(R.id.no);
            tanggalpergi = (TextView)itemView.findViewById(R.id.tanggal);
            tanggalpulang = (TextView)itemView.findViewById(R.id.pengirim);
            perihal = (TextView)itemView.findViewById(R.id.perihal);
            statusperiksa = (TextView)itemView.findViewById(R.id.statusperiksand);
        }
    }
}
