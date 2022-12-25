package ma.azehaf.immatriculationservice.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class ProprietaireCreatedEvent extends BaseEvent<String>{
    @Getter public String nom;
    @Getter public Date dateNaiss;
    @Getter public String email;
    //Constructor
    public ProprietaireCreatedEvent(String id, String nom, Date dateNaiss, String email) {
        super(id);
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.email = email;
    }
}
