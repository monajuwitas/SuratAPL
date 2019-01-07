package com.example.monajuwitas.suratapl.Gubernur;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monajuwitas.suratapl.Adapter.EofficeDeniedAdapter;
import com.example.monajuwitas.suratapl.Adapter.EofficeGubAdapter;
import com.example.monajuwitas.suratapl.PDFeofficeActivity;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Utils.RecyclerTouchListener;

public class EofficegubFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    public EofficegubFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_eofficegub, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.rceofficegub);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EofficeGubAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), PDFeofficeActivity.class);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }
}
