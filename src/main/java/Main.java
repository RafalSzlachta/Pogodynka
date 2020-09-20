import com.fasterxml.jackson.core.JsonProcessingException;
import entity.City;
import responseModels.currentOpenWeatherModel.Conditions;
import services.OpenWeatherService;
import services.WeatherStackService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {


      /*  try {
            ResultSet result=QueryExecutor.executeSelect("SELECT * FROM public");
            result.next();
            String userName = result.getString("city");
            System.out.println("Znaleziono" + userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } */

        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz miasto, w którym chcesz sprawdzić aktualną pogodę: ");
        String miasto = sc.nextLine();
        City city = City.builder().name(miasto).build();


        OpenWeatherService ows = new OpenWeatherService();


    /*    System.out.println("Aktualne warunki pogodowe OpenWeather w mieście " + city.getName() + ":");
        System.out.println("temperatura: " + (ows.getCurrentOpenWeatherTemperature(city).getTemp()-273));
        System.out.println("ciśnienie: " + ows.getCurrentOpenWeatherTemperature(city).getPressure());
        System.out.println("wilgotność: " + ows.getCurrentOpenWeatherTemperature(city).getHumidity());

        WeatherStackService wss = new WeatherStackService();
        System.out.println("Aktualne warunki pogodowe WeatherStack w mieście " + city.getName() + ":");
        System.out.println("temperatura: " + wss.getCurrentWeatherStackConditions(city).getTemperature());
        System.out.println("ciśnienie: " + wss.getCurrentWeatherStackConditions(city).getPressure());
        System.out.println("wilgotność: " + wss.getCurrentWeatherStackConditions(city).getHumidity());
     */
        WeatherStackService wss = new WeatherStackService();
        Conditions conditions = new Conditions();
        System.out.println("Aktualne warunki pogodowe w mieście " + city.getName() + ":");


        System.out.println("temperatura: " + (conditions.tempConverter((ows.getCurrentOpenWeatherTemperature(city).getTemp()))+
                wss.getCurrentWeatherStackConditions(city).getTemperature())/2);

        System.out.println("ciśnienie: " + (ows.getCurrentOpenWeatherTemperature(city).getPressure() +
                wss.getCurrentWeatherStackConditions(city).getPressure())/2);

        System.out.println("wilgotność: " + (ows.getCurrentOpenWeatherTemperature(city).getHumidity() +
                wss.getCurrentWeatherStackConditions(city).getHumidity())/2);
    }
}
