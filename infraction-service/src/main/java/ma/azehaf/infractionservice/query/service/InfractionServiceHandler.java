package ma.azehaf.infractionservice.query.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.azehaf.infractionservice.commands.models.Proprietaire;
import ma.azehaf.infractionservice.commands.models.Vehicule;
import ma.azehaf.infractionservice.commands.repositories.ProprietaireRepository;
import ma.azehaf.infractionservice.commands.repositories.VehiculeRepository;
import ma.azehaf.infractionservice.commonapi.dtos.CreateInfractionResponseDTO;
import ma.azehaf.infractionservice.commonapi.events.InfractionCreatedEvent;
import ma.azehaf.infractionservice.commonapi.events.ProprietaireCreatedEvent;
import ma.azehaf.infractionservice.commonapi.events.RadarCatchSpeedEvent;
import ma.azehaf.infractionservice.commonapi.events.VehiculeCreatedEvent;
import ma.azehaf.infractionservice.commonapi.queries.GetInfractionByVehicule;
import ma.azehaf.infractionservice.query.entities.Infraction;
import ma.azehaf.infractionservice.query.repositories.InfractionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionServiceHandler {
    private InfractionRepository infractionRepository;
    private VehiculeRepository vehiculeRepository;
    private ProprietaireRepository proprietaireRepository;

    private EventStore eventStore;

    @EventHandler
    public void on(InfractionCreatedEvent event) {
        if(event.getMaxSpeedAllowed()< event.getVehicleSpeed()){
            Infraction infraction = new Infraction();
            infraction.setId(event.getId());
            infraction.setMatricule(event.getMatricule());
            infraction.setDateInfraction(event.getDate());
            infraction.setVehicleSpeed(event.getVehicleSpeed());
            infraction.setMaxSpeedAllowed(event.getMaxSpeedAllowed());
            infraction.setAmande(300+300*(event.getVehicleSpeed() - event.getMaxSpeedAllowed())/event.getMaxSpeedAllowed());
            infractionRepository.save(infraction);
        }
    }
    @EventHandler
    public void on (RadarCatchSpeedEvent event){
        if(event.getRadarSpeed()< event.getVehiculeSpeed()){
            Infraction infraction = new Infraction();
            infraction.setId(event.getId());
            infraction.setMatricule(event.getMatricule());
            infraction.setDateInfraction(event.getDate());
            infraction.setVehicleSpeed(event.getVehiculeSpeed());
            infraction.setMaxSpeedAllowed(event.getRadarSpeed());
            infraction.setAmande(300+300*(event.getVehiculeSpeed() - event.getRadarSpeed())/event.getRadarSpeed());
            infractionRepository.save(infraction);
        }
    }
    @QueryHandler
    public List<CreateInfractionResponseDTO> on(GetInfractionByVehicule query) {
        List<Infraction> infractions = infractionRepository.findByMatriculeEquals(query.getId());
        List<CreateInfractionResponseDTO> infractionResponseDTOS = new ArrayList<>();
        for (Infraction infraction: infractions) {
            CreateInfractionResponseDTO infractionResponseDTO = new CreateInfractionResponseDTO();
            infractionResponseDTO.setId(infraction.getId());
            infractionResponseDTO.setMatricule(infraction.getMatricule());
            infractionResponseDTO.setDateInfraction(infraction.getDateInfraction());
            infractionResponseDTO.setVehicleSpeed(infraction.getVehicleSpeed());
            infractionResponseDTO.setMaxSpeedAllowed(infraction.getMaxSpeedAllowed());
            infractionResponseDTO.setAmande(infraction.getAmande());
            infractionResponseDTOS.add(infractionResponseDTO);
        }
        return infractionResponseDTOS;
    }

    @EventHandler
    public void on(VehiculeCreatedEvent event) {

        Vehicule vehicule = new Vehicule();
        vehicule.setId(UUID.randomUUID().toString());
        vehicule.setMatricule(event.getMatricule());
        vehicule.setMarque(event.getMarque());
        vehicule.setModele(event.getModele());
        String ownerId = event.getProprietaire();
        vehicule.setProprietaire(proprietaireRepository.findById(ownerId).get());
        vehicule.setPuissance(event.getPuissance());vehicule.setProprietaireId(event.getProprietaire());
        vehiculeRepository.save(vehicule);

    }
    @EventHandler
    public void on(ProprietaireCreatedEvent event) {
        log.info("OwnerCreatedEvent: {}");
        System.out.println("OwnerCreatedEvent: {}");
        Proprietaire proprietaire = new Proprietaire();
        proprietaire.setId(UUID.randomUUID().toString());
        proprietaire.setName(event.getName());
        proprietaire.setDateOfBirth(event.getDateOfBirth());
        proprietaire.setEmail(event.getEmail());
        proprietaire.setVehicules(new ArrayList<>());
        proprietaireRepository.save(proprietaire);
    }
}
