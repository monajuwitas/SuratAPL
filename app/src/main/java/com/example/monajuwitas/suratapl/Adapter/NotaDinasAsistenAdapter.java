package com.example.monajuwitas.suratapl.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.Model.NDModel;
import com.example.monajuwitas.suratapl.R;

import java.util.List;

public class NotaDinasAsistenAdapter extends RecyclerView.Adapter<NotaDinasAsistenAdapter.Viewholder> {
    private List<NDModel> mItems;
    public NotaDinasAsistenAdapter(List<NDModel> NDModelList) {
        super();
        this.mItems = NDModelList;
    }

    @NonNull
    @Override
    public NotaDinasAsistenAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_notadinas_asisten, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull NotaDinasAsistenAdapter.Viewholder viewholder, int i) {
        NDModel ndModel = mItems.get(i);
        viewholder.perihal.setText(ndModel.getPerihal());
        viewholder.no_notadinas.setText(ndModel.getNosurat());
        viewholder.tanggalnd.setText(ndModel.getTanggal());
        viewholder.statusbacand.setText(ndModel.getStatusperiksa());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView perihal, no_notadinas, tanggalnd, statusbacand;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            perihal= (TextView)itemView.findViewById(R.id.perihal);
            no_notadinas = (TextView)itemView.findViewById(R.id.no_notadinas);
            tanggalnd = (TextView)itemView.findViewById(R.id.tanggalnd);
            statusbacand = (TextView)itemView.findViewById(R.id.statusbacand);
        }
    }
}
