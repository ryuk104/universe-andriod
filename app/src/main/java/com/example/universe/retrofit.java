package com.example.universe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
    private static String API_BASE_URL = "http://ryukshome.xyz/api";
    private static Retrofit retrofit;
    private static Gson gson;

    public static Retrofit getRetrofitinstance() {
        if (retrofit == null) {

            gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://ryukshome.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static final String BASE_URL = "http://api.myservice.com/";
    }
