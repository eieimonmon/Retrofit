package com.example.retrofit.remote.mon;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable {
    @SerializedName("temp")
    public float temp;
    @SerializedName("temp_min")
    public float temp_min;
    @SerializedName("temp_max")
    public float temp_max;

    public Main(float temp,float temp_min,float temp_max){
        this.temp=temp;
        this.temp_min=temp_min;
        this.temp_max=temp_max;
    }
}
