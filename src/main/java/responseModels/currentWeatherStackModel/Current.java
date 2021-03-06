package responseModels.currentWeatherStackModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Current {

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("wind_speed")
    private int windSpeed;

    @JsonProperty("wind_dir")
    private String windDirection;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;

}
