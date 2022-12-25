package ma.azehaf.infractionservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInfractionResponseDTO {
    private String id;
    private String matricule;
    private double vehicleSpeed;
    private Date dateInfraction;
    private String radarId;
    private double maxSpeedAllowed;
    private double amande;
}
