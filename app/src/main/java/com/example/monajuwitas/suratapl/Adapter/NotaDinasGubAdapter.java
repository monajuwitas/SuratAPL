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

public class NotaDinasGubAdapter extends RecyclerView.Adapter<NotaDinasGubAdapter.Viewholder>{
    List<NDModel> mItems;

    public NotaDinasGubAdapter() {
        super();
        mItems = new ArrayList<NDModel>();
        NDModel nama = new NDModel();

    }

    @NonNull
    @Override
    public NotaDinasGubAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_notadinas, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotaDinasGubAdapter.Viewholder viewholder, int i) {
        NDModel nature = mItems.get(i);
//        viewholder.tvspecies.setText(nature.getNo());
        viewholder.imgThumbnail.setText(nature.getStatusbaca());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView imgThumbnail, tvspecies;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgThumbnail = (TextView)itemView.findViewById(R.id.no);
            tvspecies = (TextView)itemView.findViewById(R.id.tanggal);
        }
    }
}
