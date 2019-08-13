package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit.remote.mon.RespondWeather;
import com.example.retrofit.remote.retrofit.APIService;
import com.example.retrofit.remote.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtview=findViewById(R.id.txtview);
        APIService service= RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
        Call<RespondWeather> call=service.getCurrentWeatherData("9e4bdd9152mshf287c4ba16fa608p1baa7djsncaf3b7f230d8",
                "metric\"or\"imperial\"",
                "xml,html",
                "Dawei,MM");
        call.enqueue(new Callback<RespondWeather>() {
            @Override
            public void onResponse(@NonNull Call<RespondWeather> call,@NonNull Response<RespondWeather> response) {
                if (response.isSuccessful()){
                    RespondWeather respondWeather=response.body();
                    assert respondWeather!=null;
                    Log.d("MainActivity","weather main:"+respondWeather.weatherList.get(0).main);
                    Log.d("MainActivity","weather description:"+respondWeather.weatherList.get(0).main);
                    Log.d("MainActivity","weather temp:"+respondWeather.main.temp);
                    Log.d("MainActivity","weather temp_min:"+respondWeather.main.temp_min);
                    Log.d("MainActivity","weather temp_max:"+respondWeather.main.temp_max);

                    txtview.setText("weather main:"+respondWeather.weatherList.get(0).main+"\n"+
                    "weather description:"+respondWeather.weatherList.get(0).main+"\n"+
                            "Temp:"+respondWeather.main.temp+"\n"+
                            "Temp_min:"+respondWeather.main.temp_min+"\n"+
                            "Temp_max"+respondWeather.main.temp_max);
                }

            }

            @Override
            public void onFailure(Call<RespondWeather> call, Throwable t) {
                Log.d("MainActivity",String.format("Error: %s",t.getMessage()));

            }
        });

    }
}


