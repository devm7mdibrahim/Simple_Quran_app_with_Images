package com.devm7mdibrahim.quranwithpages.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://mohamedib16.github.io/";

    private static Retrofit retrofit;

    public static SurahApi getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(SurahApi.class);
    }
}
