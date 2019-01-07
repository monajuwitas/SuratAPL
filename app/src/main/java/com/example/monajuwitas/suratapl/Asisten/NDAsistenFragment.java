package com.example.monajuwitas.suratapl.Asisten;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monajuwitas.suratapl.R;
public class NDAsistenFragment extends Fragment {
    private FragmentTabHost nTabHost;

    public NDAsistenFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ndasisten, container, false);
        nTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        nTabHost.setup(getActivity(), getChildFragmentManager(),R.id.framendeselon);
        nTabHost.addTab(nTabHost.newTabSpec("semua").setIndicator("SEMUA"), NDallasistenFragment.class,null);
        nTabHost.addTab(nTabHost.newTabSpec("riwayat").setIndicator("RIWAYAT"), NDriwayatasistenFragment.class,null);

        return view;
    }
}
