package com.example.monajuwitas.suratapl.Gubernur;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.Gubernur.EofficegubFragment;
import com.example.monajuwitas.suratapl.Gubernur.NDgubFragment;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Gubernur.SPTgubFragment;
import com.example.monajuwitas.suratapl.Response.HomeGubernurResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;
import com.example.monajuwitas.suratapl.Utils.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeGubFragment extends Fragment {
    CardView notadinas;
    TextView j1;
    ProgressDialog progress;
    PrefManager prefManager;

    public HomeGubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_gub, container, false);
        notadinas = (CardView)  view.findViewById(R.id.menu2gub);
        j1 = (TextView) view.findViewById(R.id.des2);
        prefManager = new PrefManager(getContext());


        String nama = prefManager.getNAMA();

        notadinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NDgubFragment fragmentnotadinas = new NDgubFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.contenthomegub, fragmentnotadinas);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();
        datagub();
    }

    public void datagub(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BaseUrl) //api
                .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                .build();

        MobileAPI api = retrofit.create(MobileAPI.class); //menghubungkan ke mobileAPI
        Call<HomeGubernurResponse> call = api.datahomegub();
        call.enqueue(new Callback<HomeGubernurResponse>() {
            @Override
            public void onResponse(Call<HomeGubernurResponse> call, Response<HomeGubernurResponse> response) {
                progress.dismiss();
                j1.setText(response.body().getSpj());
            }

            @Override
            public void onFailure(Call<HomeGubernurResponse> call, Throwable t) {

            }
        });
    }
}
