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

public class SPTGubAdapter extends RecyclerView.Adapter<SPTGubAdapter.Viewholder> {
    List<SPTModel> mItems;
    public SPTGubAdapter() {
        super();
        mItems = new ArrayList<SPTModel>();
        SPTModel nama = new SPTModel();
        nama.setNo("1");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);

        nama = new SPTModel();
        nama.setNo("2");
        nama.setPerihal("Denied");
        mItems.add(nama);
    }

    @NonNull
    @Override
    public SPTGubAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_spt, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SPTGubAdapter.Viewholder viewholder, int i) {
        SPTModel nature = mItems.get(i);
        viewholder.tvspecies.setText(nature.getNo());
        viewholder.imgThumbnail.setText(nature.getPerihal());
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
            tvspecies = (TextView)itemView.findViewById(R.id.perihal);
        }
    }
}
