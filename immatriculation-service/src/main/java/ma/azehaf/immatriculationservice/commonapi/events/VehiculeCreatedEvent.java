package ma.azehaf.immatriculationservice.commonapi.events;

import lombok.Getter;

public class VehiculeCreatedEvent extends BaseEvent<String> {
    @Getter
    public String immatriculation;
    @Getter public String marque;
    @Getter public String modele;
    @Getter public int puissance;
    @Getter public String proprietaireId;
    public VehiculeCreatedEvent(String id, String matricule, String marque, String modele, int puissance, String proprietaire) {
        super(id);
        this.immatriculation = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.proprietaireId = proprietaire;
    }
}

