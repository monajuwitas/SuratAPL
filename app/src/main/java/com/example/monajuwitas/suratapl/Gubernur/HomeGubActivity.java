package com.example.monajuwitas.suratapl.Gubernur;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.monajuwitas.suratapl.FragmentUmum.ProfilGubFragment;
import com.example.monajuwitas.suratapl.R;

public class HomeGubActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_homegub:
//                    mTextMessage.setText(R.string.title_home);
                    HomeGubFragment homeGubFragment= new HomeGubFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                    fragmentTransaction.replace(R.id.contenthomegub, homeGubFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_akungub:
//                    mTextMessage.setText(R.string.title_dashboard);
                    ProfilGubFragment profilFragment1 = new ProfilGubFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                    fragmentTransaction2.replace(R.id.contenthomegub, profilFragment1);
                    fragmentTransaction2.addToBackStack(null);
                    fragmentTransaction2.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_gub);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationgubernur);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeGubFragment homeGubFragment= new HomeGubFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.contenthomegub, homeGubFragment);
        fragmentTransaction.commit();
    }
}
