package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.City;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import responseModels.currentWeatherStackModel.Current;
import responseModels.currentWeatherStackModel.CurrentWeatherStack;

import java.io.IOException;

public class WeatherStackService {

    //metoda pobierająca aktualną temperaturę w danym mieście
    public Current getCurrentWeatherStackConditions(City city) throws JsonProcessingException {

        //klucz do API
        String wsApiKey = "c6c41f31513a19b82b4a2a5124bc2fad";

        //przygotowywanie żądania
        Request request = new Request.Builder()
                .url("http://api.weatherstack.com/current?" +
                        "access_key=" + wsApiKey +
                        "&query=" + city)
                .build();

        //wywoływanie żądania i przygotowywanie odpowiedzi w postaci JSON
        String responseBodyString = null;
        try (Response response = new OkHttpClient().newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code: " + response);

            responseBodyString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //przekształcenie JSON w obiekt javowy
        ObjectMapper objectMapper = new ObjectMapper();
        CurrentWeatherStack cws = objectMapper.readValue(responseBodyString, CurrentWeatherStack.class);

        return cws.getCurrent();
    }
}
