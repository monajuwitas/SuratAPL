package com.example.monajuwitas.suratapl.Asisten;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.monajuwitas.suratapl.R;

public class HomeAsistenActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_homeas:
//                    mTextMessage.setText(R.string.title_home);
                    HomeAsistenFragment homeAsFragment= new HomeAsistenFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                    fragmentTransaction.replace(R.id.contenthomeasisten, homeAsFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_dashboardas:
//                    mTextMessage.setText(R.string.title_dashboard);
                    ProfilAsistenFragment profilAsistenFragment = new ProfilAsistenFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                    fragmentTransaction1.replace(R.id.contenthomeasisten, profilAsistenFragment);
                    fragmentTransaction1.addToBackStack(null);
                    fragmentTransaction1.commit();
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_asisten);
        BottomNavigationView navigationsekda = (BottomNavigationView) findViewById(R.id.navigationasisten);
        navigationsekda.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeAsistenFragment homeAsFragment= new HomeAsistenFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.contenthomeasisten, homeAsFragment);
        fragmentTransaction.commit();
    }
}
