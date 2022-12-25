package ma.azehaf.immatriculationservice.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.azehaf.immatriculationservice.commonapi.events.ProprietaireCreatedEvent;
import ma.azehaf.immatriculationservice.commonapi.queries.GetProprietaire;
import ma.azehaf.immatriculationservice.commonapi.queries.GetProprietaires;
import ma.azehaf.immatriculationservice.query.entities.Proprietaire;
import ma.azehaf.immatriculationservice.query.repositories.ProprietaireRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProprietaireServiceHandler {
    private ProprietaireRepository proprietaireRepository;

    @EventHandler
    @Transactional
    public void on(ProprietaireCreatedEvent event) {
        log.info("OwnerCreatedEvent: {}", event);
        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setId(event.getId());
        proprietaire.setNom(event.getNom());
        proprietaire.setDateOfBirth(event.getDateNaiss());
        proprietaire.setEmail(event.getEmail());
        proprietaireRepository.save(proprietaire);
    }


    @QueryHandler
    public List<Proprietaire> on(GetProprietaires query) {
        return proprietaireRepository.findAll();
    }

    @QueryHandler
    public Proprietaire on(GetProprietaire query) {
        return proprietaireRepository.findById(query.getId()).get();
    }
}
