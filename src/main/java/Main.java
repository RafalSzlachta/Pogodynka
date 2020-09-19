import com.fasterxml.jackson.core.JsonProcessingException;
import entity.City;
import services.OpenWeatherService;
import services.WeatherStackService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz miasto, w którym chcesz sprawdzić aktualną pogodę: ");
        String miasto = sc.nextLine();
        City city = City.builder().name(miasto).build();
        
        OpenWeatherService ows = new OpenWeatherService();


        System.out.println("Aktualne warunki pogodowe OpenWeather w mieście " + city.getName() + ":");
        System.out.println("temperatura: " + (ows.getCurrentOpenWeatherTemperature(city).getTemp()-273));
        System.out.println("ciśnienie: " + ows.getCurrentOpenWeatherTemperature(city).getPressure());
        System.out.println("wilgotność: " + ows.getCurrentOpenWeatherTemperature(city).getHumidity());

        WeatherStackService wss = new WeatherStackService();
        System.out.println("Aktualne warunki pogodowe WeatherStack w mieście " + city.getName() + ":");
        System.out.println("temperatura: " + wss.getCurrentWeatherStackConditions(city).getTemperature());
        System.out.println("ciśnienie: " + wss.getCurrentWeatherStackConditions(city).getPressure());
        System.out.println("wilgotność: " + wss.getCurrentWeatherStackConditions(city).getHumidity());
        

    }
}
