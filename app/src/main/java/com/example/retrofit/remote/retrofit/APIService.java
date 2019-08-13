package com.example.retrofit.remote.retrofit;

import com.example.retrofit.remote.mon.RespondWeather;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIService {
    @GET("/weather")
    Call<RespondWeather> getCurrentWeatherData(@Header("x-rapidapi-key") String apikey,
                                               @Query("units") String unit,@Query("mode") String mode,
                                               @Query("q") String q);
}


