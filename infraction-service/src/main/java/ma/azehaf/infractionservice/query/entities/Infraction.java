package ma.azehaf.infractionservice.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infraction {
    @Id
    private String id;
    private String matricule;
    private double vehicleSpeed;
    private Date dateInfraction;
    private String radarId;
    private double maxSpeedAllowed;
    private double amande;
}
