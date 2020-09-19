import com.fasterxml.jackson.core.JsonProcessingException;
import entity.City;
import services.WeatherStackService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz miasto, w którym chcesz sprawdzić aktualną temperaturę: ");
        String miasto = sc.nextLine();
        City city = City.builder().name(miasto).build();

        WeatherStackService wss = new WeatherStackService();
        System.out.println("Aktualna temperatura w mieście " + city.getName() + " wynosi: " + wss.getCurrentWeatherStackTemperature(city) +
                " stopni Celcjusza");





    }
}
