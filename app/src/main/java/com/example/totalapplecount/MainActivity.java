package com.example.totalapplecount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener{

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TotalAppleFragment fragment = new TotalAppleFragment();
        transaction.add(R.id.fragment_container,fragment,"").commit();
    }

    @Override
    public void launchBuyAppleFrag(Bundle totalApple) {
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        BuyAppleFragment fragment = new BuyAppleFragment();
        fragment.setArguments(totalApple);
        transaction.replace(R.id.fragment_container,fragment,"").addToBackStack("").commit();
    }

    @Override
    public void launchTotalAppleFrag(Bundle remApple) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TotalAppleFragment fragment = new TotalAppleFragment();
        fragment.setArguments(remApple);
        transaction.replace(R.id.fragment_container,fragment,"").commit();
    }
}