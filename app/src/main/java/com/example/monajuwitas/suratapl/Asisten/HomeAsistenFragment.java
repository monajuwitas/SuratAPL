package com.example.monajuwitas.suratapl.Asisten;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.example.monajuwitas.suratapl.Response.HomeAsistenResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeAsistenFragment extends Fragment {
    CardView notadinas;
    TextView j1;
    ProgressDialog progress;

    public HomeAsistenFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_asisten, container, false);
        notadinas = (CardView)  view.findViewById(R.id.menu2asisten);
        j1 =(TextView) view.findViewById(R.id.des2);

        notadinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NDAsistenFragment ndAsistenFragment= new NDAsistenFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.contenthomeasisten, ndAsistenFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        datajmlasisten();
    }

    public void datajmlasisten(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BaseUrl) //api
                .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                .build();

        MobileAPI api = retrofit.create(MobileAPI.class); //menghubungkan ke mobileAPI
        Call<HomeAsistenResponse> call = api.datahomeasisten();
        call.enqueue(new Callback<HomeAsistenResponse>() {
            @Override
            public void onResponse(Call<HomeAsistenResponse> call, Response<HomeAsistenResponse> response) {
                progress.dismiss();
                j1.setText(response.body().getSpj());
            }

            @Override
            public void onFailure(Call<HomeAsistenResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
