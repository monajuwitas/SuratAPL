package com.example.monajuwitas.suratapl.Asisten;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.Adapter.NotaDinasAsistenAdapter;
import com.example.monajuwitas.suratapl.Adapter.NotaDinasAsistenRiwayatAdapter;
import com.example.monajuwitas.suratapl.Model.NDModel;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Response.NDResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NDriwayatasistenFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ProgressDialog progress;
    List<NDModel> listdata = new ArrayList<>();

    public NDriwayatasistenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ndriwayatasisten, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.ndasistenriwayat);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NotaDinasAsistenRiwayatAdapter(listdata);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        datariwayat();
    }

    public void datariwayat(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MobileAPI api = retrofit.create(MobileAPI.class);
        Call<NDResponse> call = api.listndasistenriwayat();
        call.enqueue(new Callback<NDResponse>() {
            @Override
            public void onResponse(Call<NDResponse> call, Response<NDResponse> response) {
                progress.dismiss();
                listdata.clear();
                listdata.addAll(response.body().getData());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NDResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
