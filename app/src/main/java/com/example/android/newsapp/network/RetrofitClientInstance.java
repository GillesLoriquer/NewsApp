package com.example.android.newsapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    // L'instance retrofit suit le design pattern du Singleton, elle est donc unique
    private static Retrofit retrofit;

    // Base URL pour nos requêtes à l'API ne newsapi.org
    private static final String BASE_URL = "https://newsapi.org/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
