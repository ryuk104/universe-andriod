package com.example.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.example.universe.R;

public class MainActivity extends AppCompatActivity {

    boolean isAuth = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void launchlogin (View view) {
        Intent intent = new Intent(this, loginpage.class);
        startActivity(intent);
    }

    public void signuplaunch (View view) {
        Intent intent = new Intent(this, loginpage.class);
        startActivity(intent);
    }
}