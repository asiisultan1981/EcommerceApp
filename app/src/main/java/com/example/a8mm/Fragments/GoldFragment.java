package com.example.a8mm.Fragments;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a8mm.R;
import com.google.android.material.navigation.NavigationView;


public class GoldFragment extends Fragment implements View.OnClickListener {

    public GoldFragment() {
    }
    DrawerLayout drawerLayout;
    ImageView navigationBar;

    NavigationView navigationView;
    private RelativeLayout loginSignUp, bookmarks, eightMMGold;
    private TextView tv_yourOrders, tv_favOrders, tv_address, tv_onlineHelp, feedback, safety, rateUs;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gold, container, false);

        loginSignUp = (RelativeLayout) view.findViewById(R.id.relativeLayout1);
        bookmarks = (RelativeLayout) view.findViewById(R.id.relativeLayout2);
        eightMMGold = (RelativeLayout) view.findViewById(R.id.relativeLayout3);

        tv_yourOrders = view.findViewById(R.id.tv_yourOrders);
        tv_favOrders = view.findViewById(R.id.tv_favOrders);
        tv_address = view.findViewById(R.id.tv_address);
        tv_onlineHelp = view.findViewById(R.id.tv_onlineHelp);
        feedback = view.findViewById(R.id.feedback);
        safety = view.findViewById(R.id.safety);
        rateUs = view.findViewById(R.id.rateUs);

        onSetNavigationDrawerEvents();

        return view;
    }
    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) view.findViewById(R.id.navigationView);

        drawerLayout.openDrawer(GravityCompat.END);

        navigationBar = (ImageView) view.findViewById(R.id.navigationBar);


        navigationBar.setOnClickListener(this);
        loginSignUp.setOnClickListener(this);
        bookmarks.setOnClickListener(this);
        eightMMGold.setOnClickListener(this);

        tv_yourOrders.setOnClickListener(this);
        tv_favOrders.setOnClickListener(this);
        tv_onlineHelp.setOnClickListener(this);
        tv_address.setOnClickListener(this);
        feedback.setOnClickListener(this);
        safety.setOnClickListener(this);
        rateUs.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.relativeLayout1:
                Toast.makeText(getContext(), "LogInSignUp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout2:
                Toast.makeText(getContext(), "Bookmars", Toast.LENGTH_SHORT).show();
                break;
            case R.id.relativeLayout3:
                Toast.makeText(getContext(), "EightMMGold", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_yourOrders:
                Toast.makeText(getContext(), "Your Oders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_favOrders:
                Toast.makeText(getContext(), "Favourite Oders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_onlineHelp:
                Toast.makeText(getContext(), "OnLine Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_address:
                Toast.makeText(getContext(), "Address", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Toast.makeText(getContext(), "Send us FeedBack", Toast.LENGTH_SHORT).show();
                break;
            case R.id.safety:
                Toast.makeText(getContext(), "Safety Report", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rateUs:
                Toast.makeText(getContext(), "Rate us on playStore", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}