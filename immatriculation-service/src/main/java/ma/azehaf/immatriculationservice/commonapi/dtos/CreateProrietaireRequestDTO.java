package ma.azehaf.immatriculationservice.commonapi.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateProrietaireRequestDTO {
    private String nom;
    private Date dateNaiss;
    private String email;
}
