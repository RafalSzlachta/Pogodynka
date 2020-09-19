package responseModels.currentOpenWeatherModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conditions {

    @JsonProperty("temp")
    private int temp;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("humidity")
    private int humidity;

    public int tempConverter(int temp){
        temp= temp-273;
        return temp;
    }

}