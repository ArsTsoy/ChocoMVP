package com.example.arslan.chocomvp2.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mService;
    private static final String BaseURL = "https://chocolife.me/mobileapi/";
    private Retrofit mRetrofit;

    public static NetworkService getInstance(){
        if(mService == null){
            mService = new NetworkService();
        }
        return mService;
    }

    private NetworkService(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public JSONChocoAPI getJSONApi(){
        return mRetrofit.create(JSONChocoAPI.class);

    }


}
