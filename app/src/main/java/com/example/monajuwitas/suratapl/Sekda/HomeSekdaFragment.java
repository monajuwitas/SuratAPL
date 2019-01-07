package com.example.monajuwitas.suratapl.Sekda;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Response.HomeEselonResponse;
import com.example.monajuwitas.suratapl.Response.HomeSekdaResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeSekdaFragment extends Fragment {
    ProgressDialog progress;
    CardView notadinas, spt;
    TextView j1, j2;

    public HomeSekdaFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_sekda, container, false);
        notadinas = (CardView)  view.findViewById(R.id.menu2);
         spt = (CardView)  view.findViewById(R.id.menu3);
         j1 = (TextView)  view.findViewById(R.id.des2);
         j2 = (TextView)  view.findViewById(R.id.des3);


         notadinas.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 NDSekdaFragment ndSekdaFragment= new NDSekdaFragment();
                 FragmentManager fragmentManager = getFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                 fragmentTransaction.replace(R.id.contenthomesekda, ndSekdaFragment);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();
             }
         });
         spt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SPTSekdaFragment sptSekdaFragment= new SPTSekdaFragment();
                 FragmentManager fragmentManager = getFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                 fragmentTransaction.replace(R.id.contenthomesekda, sptSekdaFragment);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();

             }
         });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        datajumlahsekda();
    }

    public void datajumlahsekda(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BaseUrl) //api
                .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                .build();

        MobileAPI api = retrofit.create(MobileAPI.class); //menghubungkan ke mobileAPI
        Call<HomeSekdaResponse> call = api.datahomesekda();
        call.enqueue(new Callback<HomeSekdaResponse>() {
            @Override
            public void onResponse(Call<HomeSekdaResponse> call, Response<HomeSekdaResponse> response) {
                progress.dismiss();
                j1.setText(response.body().getSpj());
                j2.setText(response.body().getSpt());
            }

            @Override
            public void onFailure(Call<HomeSekdaResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
