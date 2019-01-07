package com.example.monajuwitas.suratapl.Eselon;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.Adapter.EofficeAdapter;
import com.example.monajuwitas.suratapl.Model.EofficeModel;
import com.example.monajuwitas.suratapl.PDFeofficeActivity;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Response.EofficeResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;
import com.example.monajuwitas.suratapl.Utils.OnLoadMoreListener;
import com.example.monajuwitas.suratapl.Utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListEOfficeFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ProgressDialog progress;
    List<EofficeModel> listdata = new ArrayList<>();
    private LinearLayoutManager lRecyler;

    Boolean isScrolled = false;
    int currentItem, totalItem, scrollItem,flag=0;

    //    ------------------------------1--------------------
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem,
            totalItemCount;
//    ------------------------------1--------------------

    public ListEOfficeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_eoffice,container,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.rceoffice);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EofficeAdapter(listdata);
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


        //        ----------------------------------------------------------------------------------------
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });

//        ----------------------------------------------------------------------------------------

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        datarecyclereoffice();
    }

    public void datarecyclereoffice(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MobileAPI api = retrofit.create(MobileAPI.class);
        Call<EofficeResponse> call = api.listeoffice(flag);
        call.enqueue(new Callback<EofficeResponse>() {
            @Override
            public void onResponse(Call<EofficeResponse> call, Response<EofficeResponse> response) {

                progress.dismiss();
                listdata.clear();
                listdata.addAll(response.body().getData());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<EofficeResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
