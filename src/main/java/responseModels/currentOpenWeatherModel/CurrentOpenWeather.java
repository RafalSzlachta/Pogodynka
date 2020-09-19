package responseModels.currentOpenWeatherModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentOpenWeather {

    @Getter
    @Setter
    @JsonProperty("main")
    Main owmain;
}
