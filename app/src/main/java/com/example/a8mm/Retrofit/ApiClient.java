package com.example.a8mm.Retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
     public static final String BASE_URL = "http://192.168.100.242:80/80/";
     private static final String TAG = "apiClient";
     public static Retrofit retrofit = null;

     public static Retrofit getApiClient(){
          if (retrofit == null){
               Gson gson = new GsonBuilder()
                       .setLenient()
                       .create();
               retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create(gson))
                       .build();

          }
          Log.d(TAG, "getApiClient: "+BASE_URL);
          return retrofit;
     }
}
