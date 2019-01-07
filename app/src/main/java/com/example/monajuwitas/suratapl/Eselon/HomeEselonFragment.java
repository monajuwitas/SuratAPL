package com.example.monajuwitas.suratapl.Eselon;

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
import android.widget.Toast;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.Eselon.EofficeAllFragment;
import com.example.monajuwitas.suratapl.Eselon.NDFragment;
import com.example.monajuwitas.suratapl.R;
import com.example.monajuwitas.suratapl.Eselon.SPTFragment;
import com.example.monajuwitas.suratapl.Response.HomeEselonResponse;
import com.example.monajuwitas.suratapl.Utils.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeEselonFragment extends Fragment {
    CardView eoffice, notadinas, spt;
    TextView j1,j2,j3;
    ProgressDialog progress;


    public HomeEselonFragment() {
        // Required empty public constructor
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        eoffice = (CardView)  view.findViewById(R.id.menu1);
        notadinas = (CardView)  view.findViewById(R.id.menu2);
        spt = (CardView) view.findViewById(R.id.menu3);
        j1 =(TextView) view.findViewById(R.id.des1eselon);
        j2 =(TextView) view.findViewById(R.id.des2eselon);
        j3 =(TextView) view.findViewById(R.id.des3eselon);
//        TextView jds2 =(TextView) view.findViewById(R.id.jds2);
        //        mengatur font
//        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MFthin.otf");
//        jds2.setTypeface(font);



        eoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EofficeAllFragment fragment2 = new EofficeAllFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.contenthome, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        notadinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NDFragment fragmentnotadinas = new NDFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.contenthome, fragmentnotadinas);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        spt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPTFragment fragmentspt = new SPTFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fragmentTransaction.replace(R.id.contenthome, fragmentspt);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        datajumlah();
    }

    public void datajumlah(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BaseUrl) //api
                .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                .build();

        MobileAPI api = retrofit.create(MobileAPI.class); //menghubungkan ke mobileAPI
        Call<HomeEselonResponse> call = api.datahomeeselon();
        call.enqueue(new Callback<HomeEselonResponse>() {
            @Override
            public void onResponse(Call<HomeEselonResponse> call, Response<HomeEselonResponse> response) {
                progress.dismiss();
                j3.setText(response.body().getSpt());
                j2.setText(response.body().getSpj());
                j1.setText(response.body().getEoffice());
            }

            @Override
            public void onFailure(Call<HomeEselonResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "Gagal", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
