package com.example.a8mm;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.a8mm.Adapters.PlateAdapter;
import com.example.a8mm.EmailLoginRegister.EmailRegisterActivity;
import com.example.a8mm.Models.PlateModel;
import com.example.a8mm.PhoneLoginRegister.PhoneRegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "main";
    private RecyclerView recyclerView;
    List<PlateModel> plateModelList;
    PlateAdapter plateAdapter;
   private LinearLayout linear_email, linear_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////// No Status bar start ///////////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        ///////////////// No Status bar end ///////////////
        //////////////// hide status bar start ////////////
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //////////////// hide status bar end ////////////

        linear_email = findViewById(R.id.linear_email);
        linear_phone = findViewById(R.id.linear_phone);


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);

        plateModelList = new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));
        plateModelList.add(new PlateModel(R.drawable.plate_three));

        plateAdapter = new PlateAdapter(plateModelList,this);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(plateAdapter);
        Log.d(TAG, "onCreate: adapter set");

        autoScroll();

        linear_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmailRegisterActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });

        linear_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhoneRegisterActivity.class);
                startActivity(intent);
                Animatoo.animateSlideDown(MainActivity.this);
            }
        });



    }

    public void autoScroll(){
        final int speedScroll = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if (count == plateAdapter.getItemCount())
                    count = 0;
                if (count < plateAdapter.getItemCount()){

                    recyclerView.smoothScrollToPosition( count++);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };
        handler.postDelayed(runnable,speedScroll);
    }

    public void GoToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        Animatoo.animateWindmill(this);
    }
}