package ma.azehaf.radarservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateRadarRequestDTO {
    private int vitesse;
    private double longitude;
    private double latitude;

}
