package com.example.retrofit.remote.mon;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RespondWeather implements Serializable {
    @SerializedName("weather")
    public List<Weather> weatherList;
    @SerializedName("main")
    public Main main;
}
