package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.City;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import responseModels.currentOpenWeatherModel.CurrentOpenWeather;

import java.io.IOException;

public class OpenWeatherService {
    public double getCurrentOpenWeatherTemperature(City city) throws JsonProcessingException {

        String owApiKey = "605f3728c013ce474c7267bc817c0300";
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=" + city.getName() +
                        "&appid=" + owApiKey)
                        .build();

        String responseBodyString = null;
        try (Response response = new OkHttpClient().newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code: " + response);

            responseBodyString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        CurrentOpenWeather cow = objectMapper.readValue(responseBodyString, CurrentOpenWeather.class);
        return cow.getOwmain().getTemp()-273;
    }

}
