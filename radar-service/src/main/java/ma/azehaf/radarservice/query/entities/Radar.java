package ma.azehaf.radarservice.query.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Radar {
        @Id
        private String id;
        private double VitesseMax;
        private double latitude;
        private double longitude;
}

