package com.example.monajuwitas.suratapl.Eselon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.Adapter.SPTdeniedAdapter;
import com.example.monajuwitas.suratapl.Model.SPTModel;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.PDFsptActivity;
import com.example.monajuwitas.suratapl.Response.SPTResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;
import com.example.monajuwitas.suratapl.Utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SPTDeniedFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ProgressDialog progress;
    List<SPTModel> listdata = new ArrayList<>();

    public SPTDeniedFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sptdenied,container,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.rcsptdenied);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SPTdeniedAdapter(listdata);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), PDFsptActivity.class);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        datarecyclersptdenied();
    }

    public void datarecyclersptdenied(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MobileAPI api = retrofit.create(MobileAPI.class);
        Call<SPTResponse> call = api.listsptdenied();
        call.enqueue(new Callback<SPTResponse>() {
            @Override
            public void onResponse(Call<SPTResponse> call, Response<SPTResponse> response) {
                progress.dismiss();
                listdata.clear();
                listdata.addAll(response.body().getData());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SPTResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
