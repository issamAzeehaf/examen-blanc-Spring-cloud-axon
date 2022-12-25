package ma.azehaf.immatriculationservice.commonapi.commands;

import lombok.Getter;

import java.util.Date;

public class CreateProprietaireCommand extends BaseCommand<String>{
    @Getter public String nom;
    @Getter public Date dateNaiss;
    @Getter public String email;

    //constructor
    public CreateProprietaireCommand(String id, String nom, Date dateNaiss, String email) {
        super(id);
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.email = email;
    }
}
