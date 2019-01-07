package com.example.monajuwitas.suratapl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.monajuwitas.suratapl.Asisten.HomeAsistenActivity;
import com.example.monajuwitas.suratapl.Eselon.HomeActivity;
import com.example.monajuwitas.suratapl.Gubernur.HomeGubActivity;
import com.example.monajuwitas.suratapl.Sekda.HomeSekdaActivity;
import com.example.monajuwitas.suratapl.Utils.AppConstants;
import com.example.monajuwitas.suratapl.Utils.PrefManager;

public class SplahsTTEActivity extends AppCompatActivity {
    Button splashcreentest;
    PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splahs_tte);
        splashcreentest = (Button) findViewById(R.id.splashcreentest);

//      anim
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        splashcreentest.startAnimation(myanim);
        prefManager = new PrefManager(this);

        Toast.makeText(SplahsTTEActivity.this, String.valueOf(prefManager.isLogin()), Toast.LENGTH_SHORT).show();
        if (prefManager.isLogin() == true){

            String jabatan = prefManager.getROLE();

            if (jabatan.equals(AppConstants.GUBERNUR)){

                gotoActivity(HomeGubActivity.class);

            }
            else if (jabatan.equals(AppConstants.SEKDA)){

                gotoActivity(HomeSekdaActivity.class);

            }
            else if (jabatan.equals(AppConstants.ASISTEN)){
                gotoActivity(HomeAsistenActivity.class);
            }
            else if (jabatan.equals(AppConstants.ESELON)){
                gotoActivity(HomeActivity.class);

            }
        }

        else {
            gotoActivity(LoginActivity.class);
        }
    }

    public void gotoActivity (Class destination) {
        final Intent i = new Intent(this, destination);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}
