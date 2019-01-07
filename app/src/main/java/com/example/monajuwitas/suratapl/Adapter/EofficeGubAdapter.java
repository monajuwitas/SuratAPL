package com.example.monajuwitas.suratapl.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.Model.EofficeModel;
import com.example.monajuwitas.suratapl.R;

import java.util.ArrayList;
import java.util.List;

public class EofficeGubAdapter extends RecyclerView.Adapter<EofficeGubAdapter.Viewholder> {
    List<EofficeModel> mItems;

    public EofficeGubAdapter() {
        super();
        mItems = new ArrayList<EofficeModel>();
        EofficeModel nama = new EofficeModel();
//        nama.setNo("1");
//        nama.setPengirim("aaaaa");
//        mItems.add(nama);
//
//        nama = new EofficeModel();
//        nama.setNo("5");
//        nama.setPengirim("eeeee");
//        mItems.add(nama);
//
//        nama = new EofficeModel();
//        nama.setNo("5");
//        nama.setPengirim("eeeee");
//        mItems.add(nama);
//
//        nama = new EofficeModel();
//        nama.setNo("5");
//        nama.setPengirim("eeeee");
//        mItems.add(nama);
//
//        nama = new EofficeModel();
//        nama.setNo("5");
//        nama.setPengirim("eeeee");
//        mItems.add(nama);
    }

    @NonNull
    @Override
    public EofficeGubAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_eoffice, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EofficeGubAdapter.Viewholder viewholder, int i) {
        EofficeModel nature = mItems.get(i);
//        viewholder.tvspecies.setText(nature.getNo());
        viewholder.imgThumbnail.setText(nature.getPengirim());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView tvspecies,imgThumbnail;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgThumbnail = (TextView)itemView.findViewById(R.id.no);
            tvspecies = (TextView)itemView.findViewById(R.id.tanggal);
        }
    }
}
