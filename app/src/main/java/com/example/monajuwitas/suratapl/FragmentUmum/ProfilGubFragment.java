package com.example.monajuwitas.suratapl.FragmentUmum;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Utils.PrefManager;

public class ProfilGubFragment extends Fragment {
    TextView desskripsijabatan, isinipclient;
    PrefManager prefManager;

    public ProfilGubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil_gub, container, false);
        desskripsijabatan = (TextView)view.findViewById(R.id.deskripsijabatan);
        isinipclient = (TextView)view.findViewById(R.id.isinipclient);
        prefManager = new PrefManager(getContext());
        String nama = prefManager.getNAMA();
        String nip = prefManager.getNIP();

        desskripsijabatan.setText(nama);
        isinipclient.setText(nip);


        return view;
    }
}
