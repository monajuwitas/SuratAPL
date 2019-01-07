package com.example.monajuwitas.suratapl.Asisten;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.LoginActivity;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Utils.PrefManager;

public class ProfilAsistenFragment extends Fragment {
    TextView namaasisten,jabatanasisten, nipasisten;
    Button tbllogout;
    PrefManager prefManager;

    public ProfilAsistenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil_asisten, container, false);
        namaasisten = (TextView)view.findViewById(R.id.namaasisten);
        jabatanasisten = (TextView)view.findViewById(R.id.jabatanasisten);
        nipasisten = (TextView)view.findViewById(R.id.isinipasisten);
        tbllogout = (Button) view.findViewById(R.id.tbllogout);

        prefManager = new PrefManager(getContext());
        String nip = prefManager.getNIP();
        String nama = prefManager.getNAMA();
        String jabatan = prefManager.getROLE();
        nipasisten.setText(nip);
        namaasisten.setText(nama);
        jabatanasisten.setText(jabatan);

//        logou
        tbllogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mobilebanking", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent logout = new Intent(getActivity(), LoginActivity.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(logout);


            }
        });
        return view;
    }
}
