package com.example.monajuwitas.suratapl.Eselon;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monajuwitas.suratapl.R;
public class SPTFragment extends Fragment {
    private FragmentTabHost sTabHost;
    public SPTFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spt, container, false);
        sTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        sTabHost .setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);
        sTabHost .addTab(sTabHost .newTabSpec("semua").setIndicator("SEMUA"), SPTAllFragment.class,null);
        sTabHost .addTab(sTabHost .newTabSpec("setuju").setIndicator("DISETUJUI"), SPTAccFragment.class,null);
        sTabHost .addTab(sTabHost .newTabSpec("ditolak").setIndicator("DITOLAK"), SPTDeniedFragment.class,null);
        return view;

    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
