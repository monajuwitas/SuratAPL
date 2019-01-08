package com.example.monajuwitas.suratapl;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monajuwitas.suratapl.API.MobileAPI;
import com.example.monajuwitas.suratapl.Asisten.HomeAsistenActivity;
import com.example.monajuwitas.suratapl.Eselon.HomeActivity;
import com.example.monajuwitas.suratapl.Gubernur.HomeGubActivity;
import com.example.monajuwitas.suratapl.Model.UserModel;
import com.example.monajuwitas.suratapl.Response.LoginResponse;
import com.example.monajuwitas.suratapl.Sekda.HomeSekdaActivity;
import com.example.monajuwitas.suratapl.Utils.AppConstants;
import com.example.monajuwitas.suratapl.Utils.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {
    EditText lgusername, lgpassword;
    ProgressDialog progress;
    PrefManager prefManager;

//deklarasi onbackpressed
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefManager =  new PrefManager(this);

//      set default font size
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MFthin.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

//      inisialisasi ID yang akan diambil nilai
        lgusername = (EditText) findViewById(R.id.loginusername);
        lgpassword = (EditText) findViewById(R.id.loginpassword);
        Button a = (Button) findViewById(R.id.btnlogin);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. membuat progress dialog
                progress = new ProgressDialog(LoginActivity.this);
                progress.setCancelable(false);
                progress.setMessage("Loading ...");
                progress.show();

                //mengambil data textview
                String username_request = lgusername.getText().toString();
                String password_request = lgpassword.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(AppConstants.BaseUrl) //api
                        .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                        .build();
                MobileAPI api = retrofit.create(MobileAPI.class);
                Call<LoginResponse> call = api.login(username_request, password_request);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        progress.dismiss();
                        String respon = response.body().getResponse_code();
                        String nip = response.body().getNip();
                        String nama = response.body().getNama();
                        String jabatan = response.body().getJabatan();
                        String pesan = response.body().getPesan();

                        prefManager.saveLoginData(nip, nama, jabatan);
                        prefManager.setLogin(true);

                        Toast.makeText(LoginActivity.this, String.valueOf(prefManager.isLogin()), Toast.LENGTH_SHORT).show();

                        if (respon.equals(AppConstants.SUCCESS)){
                            Toast.makeText(LoginActivity.this, jabatan, Toast.LENGTH_SHORT).show();
                            if (jabatan.equals(AppConstants.GUBERNUR)){
                                Intent pindah = new Intent(LoginActivity.this, HomeGubActivity.class);
                                pindah.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                startActivity(pindah);
                            }
                            else if (jabatan.equals(AppConstants.SEKDA)){
                                Intent pindah = new Intent(LoginActivity.this, HomeSekdaActivity.class);
                                pindah.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                startActivity(pindah);
                            }
                            else if (jabatan.equals(AppConstants.ASISTEN)){
                                Intent pindah = new Intent(LoginActivity.this, HomeAsistenActivity.class);
                                pindah.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                startActivity(pindah);
                            }
                            else if (jabatan.equals(AppConstants.ESELON)){
                                Intent pindah = new Intent(LoginActivity.this, HomeActivity.class);
                                pindah.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                startActivity(pindah);
                            }
                        }
                        else if (respon.equals(AppConstants.FAILED)){
                            Toast.makeText(LoginActivity.this, pesan, Toast.LENGTH_SHORT).show();
                            progress.dismiss();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Gagal Terhubung, Jaringan Bermasalah", Toast.LENGTH_SHORT).show();
                        progress.dismiss();

                    }
                });


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    protected void onPause() {
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onPause();
    }
}
