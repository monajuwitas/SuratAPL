package com.example.monajuwitas.suratapl.Sekda;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.monajuwitas.suratapl.R;

public class HomeSekdaActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_homesekda:
//                    mTextMessage.setText(R.string.title_dashboard);
                    HomeSekdaFragment homeSekdaFragment= new HomeSekdaFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                    fragmentTransaction.replace(R.id.contenthomesekda, homeSekdaFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_profildsekda:
//                    mTextMessage.setText(R.string.title_dashboard);
                    ProfilSekdaFragment profilSekdaFragment = new ProfilSekdaFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                    fragmentTransaction1.replace(R.id.contenthomesekda, profilSekdaFragment);
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
        setContentView(R.layout.activity_home_sekda);
        BottomNavigationView navigationsekda = (BottomNavigationView) findViewById(R.id.navigationsekda);
        navigationsekda.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeSekdaFragment homeSekdaFragment= new HomeSekdaFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.contenthomesekda, homeSekdaFragment);
        fragmentTransaction.commit();
    }
}
