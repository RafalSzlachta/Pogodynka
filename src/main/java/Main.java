import DAO.CityDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import responseModels.currentOpenWeatherModel.Conditions;
import services.OpenWeatherService;
import services.WeatherStackService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

/*
        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz miasto, w którym chcesz sprawdzić aktualną pogodę: ");
        String miasto = sc.nextLine();
        City city = City.builder().name(miasto).build();


        OpenWeatherService ows = new OpenWeatherService();

*/

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
/*        WeatherStackService wss = new WeatherStackService();
        Conditions conditions = new Conditions();
        System.out.println("Aktualne warunki pogodowe w mieście " + city.getName() + ":");


        System.out.println("temperatura: " + (conditions.tempConverter((ows.getCurrentOpenWeatherTemperature(city).getTemp()))+
                wss.getCurrentWeatherStackConditions(city).getTemperature())/2);

        System.out.println("ciśnienie: " + (ows.getCurrentOpenWeatherTemperature(city).getPressure() +
                wss.getCurrentWeatherStackConditions(city).getPressure())/2);

        System.out.println("wilgotność: " + (ows.getCurrentOpenWeatherTemperature(city).getHumidity() +
                wss.getCurrentWeatherStackConditions(city).getHumidity())/2);
    }*/
        System.out.println("Hello and welcome to weather system 'Pogodynka'");
        System.out.println("Here You can check historical, current and forecast weather");
        System.out.println();
        Main main = new Main();
        main.mainMenu();



    }

    public Main() {
        SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(City.class)
                        .buildSessionFactory();
    }

    public void inputCity() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please write city: ");
        String cityInput = sc.nextLine();
        City city = City.builder().name(cityInput).build();

    }

    private void mainMenu() throws JsonProcessingException {

        int choice = 0;
        while (choice != 3) {
            System.out.println("You are in main menu. Please select option: ");
            System.out.println("1. Check weather at indicated city");
            System.out.println("2. Check weather from favotited list");
            System.out.println("3. Quit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            if (choice == 1) {
                checkWeatherMenu();
            } else if (choice == 2) {
                favoritedListMenu();
            } else if (choice == 3) {
                continue;

            }
        }

    }

    private void favoritedListMenu() throws JsonProcessingException {
        SessionFactory sf =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(City.class)
                        .buildSessionFactory();
        CityDAO cd = new CityDAO(sf);
        List<City> cities = cd.getAvailableCities();
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + 1 + ". " + cities.get(i).getName());
        }
        System.out.println("Select number of city: ");
        Scanner sc = new Scanner(System.in);
        int nrCity = sc.nextInt();
        City city = City.builder().name(cities.get(nrCity-1).getName()).build();
        System.out.println();

        System.out.println("Select option: ");
        System.out.println("1. Check historical weather");
        System.out.println("2. Check current weather");
        System.out.println("3. Check forecast weather");
        System.out.println("4. Back to main menu");
        int choice = 0;
        Scanner scannerChoice = new Scanner(System.in);
        choice = scannerChoice.nextInt();
        if (choice == 1) {
            System.out.println("historical weather");
        } else if (choice == 2) {

            OpenWeatherService ows = new OpenWeatherService();
            WeatherStackService wss = new WeatherStackService();
            Conditions conditions = new Conditions();
            System.out.println("Current weather in city " + city.getName() + ":");


            System.out.println("temperature: " + (conditions.tempConverter((ows.getCurrentOpenWeatherTemperature(city).getTemp())) +
                    wss.getCurrentWeatherStackConditions(city).getTemperature()) / 2);

            System.out.println("pressure: " + (ows.getCurrentOpenWeatherTemperature(city).getPressure() +
                    wss.getCurrentWeatherStackConditions(city).getPressure()) / 2);

            System.out.println("humidity: " + (ows.getCurrentOpenWeatherTemperature(city).getHumidity() +
                    wss.getCurrentWeatherStackConditions(city).getHumidity()) / 2);
            System.out.println();
        }
    }

        private void indicatedMenu () throws JsonProcessingException {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.print("Please write city: ");
            String cityInput = sc.nextLine();
            City city = City.builder().name(cityInput).build();
            System.out.println("Add city to favorite list? Y/N");
            Scanner scanner = new Scanner(System.in);
            String addChoice = scanner.nextLine();

            if (addChoice.equalsIgnoreCase("y")) {
            /*List<City> cities = new ArrayList<>();
            CityDAO cd = new CityDAO(sf);
            cd.save(city);
            //tutaj trzeba dodac miasto do ulubionych*/
            }
            checkWeatherMenu();
        }

        public void checkWeatherMenu () throws JsonProcessingException {
            int choice = 0;
            while (choice != 4) {
                System.out.println();

                System.out.println("Select option: ");
                System.out.println("1. Check historical weather");
                System.out.println("2. Check current weather");
                System.out.println("3. Check forecast weather");
                System.out.println("4. Back to main menu");
                Scanner scannerChoice = new Scanner(System.in);
                choice = scannerChoice.nextInt();

                if (choice == 1) {
                    System.out.println("historical weather");
                } else if (choice == 2) {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Please write city: ");
                    String cityInput = sc.nextLine();
                    City city = City.builder().name(cityInput).build();
                    OpenWeatherService ows = new OpenWeatherService();
                    WeatherStackService wss = new WeatherStackService();
                    Conditions conditions = new Conditions();
                    System.out.println("Current weather in city " + city.getName() + ":");


                    System.out.println("temperature: " + (conditions.tempConverter((ows.getCurrentOpenWeatherTemperature(city).getTemp())) +
                            wss.getCurrentWeatherStackConditions(city).getTemperature()) / 2);

                    System.out.println("pressure: " + (ows.getCurrentOpenWeatherTemperature(city).getPressure() +
                            wss.getCurrentWeatherStackConditions(city).getPressure()) / 2);

                    System.out.println("humidity: " + (ows.getCurrentOpenWeatherTemperature(city).getHumidity() +
                            wss.getCurrentWeatherStackConditions(city).getHumidity()) / 2);

                    System.out.println();
                    System.out.println("Add city to favorite list? Y/N");
                    Scanner scanner = new Scanner(System.in);
                    String addChoice = scanner.nextLine();

                    if (addChoice.equalsIgnoreCase("y")) {
                        SessionFactory sf =
                                new Configuration().configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(City.class)
                                        .buildSessionFactory();
                        List<City> cities = new ArrayList<>();
                        CityDAO cd = new CityDAO(sf);
                        cd.save(city);
                    }
                } else if (choice == 3) {
                    System.out.println("forecast weather");
                } else if (choice == 4) {
                    mainMenu();
                }

            }
        }
    }

