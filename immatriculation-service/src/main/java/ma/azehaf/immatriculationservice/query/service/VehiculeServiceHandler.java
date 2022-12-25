package ma.azehaf.immatriculationservice.query.service;

import ma.azehaf.immatriculationservice.commonapi.events.VehiculeCreatedEvent;
import ma.azehaf.immatriculationservice.query.entities.Proprietaire;
import ma.azehaf.immatriculationservice.query.entities.Vehicule;
import ma.azehaf.immatriculationservice.query.repositories.ProprietaireRepository;
import ma.azehaf.immatriculationservice.query.repositories.VehiculeRepository;

public class VehiculeServiceHandler {
    private VehiculeRepository vehiculeRepository;
    private ProprietaireRepository proprietaireRepository;

    public void on(VehiculeCreatedEvent event) {
        if(event.getProprietaireId()!= null) {
            Proprietaire proprietaire = proprietaireRepository.findById(event.getProprietaireId()).get();
            System.out.println("owner: " + proprietaire.getNom());
            Vehicule vehicule = new Vehicule();
            vehicule.setId(event.getId());
            vehicule.setMatricule(event.getImmatriculation());
            vehicule.setMarque(event.getMarque());
            vehicule.setModele(event.getModele());
            vehicule.setPuissance(event.getPuissance());
            vehicule.setProprietaire(proprietaire);
            vehicule.setProprietaire_Id(proprietaire.getId());
            vehiculeRepository.save(vehicule);
        }
    }
}
