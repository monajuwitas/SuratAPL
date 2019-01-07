package com.example.monajuwitas.suratapl.Sekda;

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

public class ProfilSekdaFragment extends Fragment {
    TextView namasekda, jabatansekda;
    PrefManager prefManager;

    public ProfilSekdaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil_sekda, container, false);
        namasekda = (TextView) view.findViewById(R.id.namasekda);
        jabatansekda = (TextView) view.findViewById(R.id.jabatansekda);

        prefManager = new PrefManager(getContext());
        String nama = prefManager.getNAMA();
        String jabatan = prefManager.getROLE();
        namasekda.setText(nama);
        jabatansekda.setText(jabatan);
        return view;
    }

}
