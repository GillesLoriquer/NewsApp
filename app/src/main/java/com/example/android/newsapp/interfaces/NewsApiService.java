package com.example.android.newsapp.interfaces;

import com.example.android.newsapp.Models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {
    @GET("/v2/top-headlines")
    Call<News> newsForCategory(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey);
}
