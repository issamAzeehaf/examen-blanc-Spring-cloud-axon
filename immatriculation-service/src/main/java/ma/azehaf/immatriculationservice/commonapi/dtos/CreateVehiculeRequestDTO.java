package ma.azehaf.immatriculationservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehiculeRequestDTO {
    private String immatriculation;
    private String marque;
    private String modele;
    private int puissance;
    private String proprietaireId;
}
