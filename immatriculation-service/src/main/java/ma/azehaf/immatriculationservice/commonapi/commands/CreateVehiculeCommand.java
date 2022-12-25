package ma.azehaf.immatriculationservice.commonapi.commands;

import lombok.Getter;

public class CreateVehiculeCommand extends BaseCommand<String> {
    @Getter private String immatriculation;
    @Getter private String marque;
    @Getter private String modele;

    @Getter private int puissance;
    @Getter private String proprietaireId;

    public CreateVehiculeCommand(String id, String immatriculation, String marque, String modele,int puissance, String proprietaireId) {
        super(id);
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.proprietaireId = proprietaireId;
    }
}

