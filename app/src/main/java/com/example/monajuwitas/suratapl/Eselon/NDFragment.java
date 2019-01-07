package com.example.monajuwitas.suratapl.Eselon;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monajuwitas.suratapl.R;

public class NDFragment extends Fragment {
    private FragmentTabHost nTabHost;
    public NDFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nd, container, false);
        nTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        nTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);
        nTabHost.addTab(nTabHost.newTabSpec("semua").setIndicator("SEMUA"), NDAllFragment.class,null);
        nTabHost.addTab(nTabHost.newTabSpec("setuju").setIndicator("DISETUJUI"), NDAccFragment.class,null);
        nTabHost.addTab(nTabHost.newTabSpec("ditolak").setIndicator("DITOLAK"), NDDeniedFragment.class,null);
        return view;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
