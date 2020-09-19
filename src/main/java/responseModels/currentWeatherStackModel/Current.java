package responseModels.currentWeatherStackModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Current {

    @JsonProperty("temperature")
    private int temperature;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;

}
