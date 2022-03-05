package com.example.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.universe.R;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;


public class loginpage extends AppCompatActivity {

    EditText email, password;
    Button loginbutton;
    CheckBox remember;

    boolean isAuth = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        remember = findViewById(R.id.remembermecheckbox);
        loginbutton = findViewById(R.id.userloginsubmitinformation);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");

        if(checkbox.equals("true")) {
            Intent intent = new Intent(this, homepage.class);
            startActivity(intent);
        }else if(checkbox.equals("false")) {
            Toast.makeText(this, "Please sign in", Toast.LENGTH_SHORT).show();
        }

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = email.getText().toString();
                String userpassword = password.getText().toString();
                
                if(useremail.isEmpty() || userpassword.isEmpty()) {
                    Toast.makeText(loginpage.this, "Fill the fourm out", Toast.LENGTH_SHORT).show();
                } else {
                    isAuth = loginuser(useremail, userpassword);

                } if(!isAuth) {
                    Toast.makeText(loginpage.this, "Incorrect login", Toast.LENGTH_SHORT).show();
                }else{
                    Intent MainActivity = new Intent(loginpage.this, homepage.class);
                    startActivity(MainActivity);
                }
            }
        });
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                }else if (!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }
            }
        });
    }

    private boolean loginuser(String email, String password){
        @POST("auth/login")
        Call<User> getUser(@Path("email") String email)
        if(email.equals (email)) {
            return true;
        }
        return false;
    }


}