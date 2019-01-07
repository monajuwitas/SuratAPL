package com.example.monajuwitas.suratapl.Eselon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monajuwitas.suratapl.R;

public class EofficeAllFragment extends Fragment {
    private FragmentTabHost mTabHost;

    public EofficeAllFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_eoffice, container, false);
        mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("semua").setIndicator("SEMUA"), ListEOfficeFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("setuju").setIndicator("DISETUJUI"), EofficeAccFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("ditolak").setIndicator("DITOLAK"), EofficeDeniedFragment.class,null);
        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return view;
    }
}
