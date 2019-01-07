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

public class EofficeAdapter extends RecyclerView.Adapter<EofficeAdapter.Viewholder> {
    private  List<EofficeModel> mItems;

    public EofficeAdapter(List<EofficeModel> eofficeModelList){
        super();
        this.mItems = eofficeModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_eoffice, viewGroup, false);
        Viewholder viewHolder = new Viewholder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        //
        EofficeModel modeleoffice= mItems.get(i);
        viewholder.nosurat.setText(modeleoffice.getNosurat());
        viewholder.tanggalsurat.setText(modeleoffice.getTanggal());
        viewholder.pengirimsurat.setText(modeleoffice.getPengirim());
        viewholder.perihalsurat.setText(modeleoffice.getPerihal());
        viewholder.statusbacasurat.setText(modeleoffice.getStatusbaca());
        viewholder.statusperiksasurat.setText(modeleoffice.getStatusperiksa());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView nosurat,tanggalsurat,pengirimsurat,perihalsurat,statusperiksasurat,statusbacasurat;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nosurat = (TextView)itemView.findViewById(R.id.no);
            tanggalsurat= (TextView)itemView.findViewById(R.id.tanggal);
            pengirimsurat = (TextView)itemView.findViewById(R.id.pengirim);
            perihalsurat = (TextView)itemView.findViewById(R.id.perihal);
            statusperiksasurat = (TextView)itemView.findViewById(R.id.statusperiksa);
            statusbacasurat = (TextView)itemView.findViewById(R.id.statusbaca);
        }
    }
}
