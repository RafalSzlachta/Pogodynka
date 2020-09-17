package responseModels.currentWeatherStackModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherStack {

    @Getter
    @Setter
    Current current;
}
