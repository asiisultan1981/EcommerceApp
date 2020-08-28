package com.example.a8mm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.a8mm.Fragments.GoOutFragment;
import com.example.a8mm.Fragments.GoldFragment;
import com.example.a8mm.Fragments.OrdersFragment;
import com.example.a8mm.Fragments.VideosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       
        ///////////////// No Status bar end ///////////////

//////////////// hide status bar start ////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //////////////// hide status bar end ////////////

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);

        frameLayout = findViewById(R.id.frameLayout);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.orders:
                             Toast.makeText(HomeActivity.this,"orders",Toast.LENGTH_SHORT).show();
                             selectedFragment = new OrdersFragment();
                             break;
                        case R.id.goout:
                            Toast.makeText(HomeActivity.this,"goout", Toast.LENGTH_SHORT).show();
                            selectedFragment = new GoOutFragment();
                            break;
                        case R.id.gold:
                            Toast.makeText(HomeActivity.this,"gold", Toast.LENGTH_SHORT).show();
                            selectedFragment = new GoldFragment();
                            break;
                        case R.id.videos:
                            Toast.makeText(HomeActivity.this,"videos", Toast.LENGTH_SHORT).show();
                            selectedFragment = new VideosFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                            selectedFragment).commit();
                    return true;
                }
            };
}