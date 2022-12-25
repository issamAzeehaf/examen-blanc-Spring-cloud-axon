package ma.azehaf.infractionservice.commands.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    private String id;
    private String matricule;
    private String marque;
    private String modele;
    private int puissance;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Proprietaire proprietaire;
    @Column(insertable=false, updatable=false)
    private String proprietaire_Id;
}
