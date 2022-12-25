package ma.azehaf.radarservice.query.service;

import ma.azehaf.radarservice.commonapi.events.RadarCreatedEvent;
import ma.azehaf.radarservice.commonapi.queries.FindAllRadars;
import ma.azehaf.radarservice.query.entities.Radar;
import ma.azehaf.radarservice.query.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RadarServiceHandler {
    private RadarRepository radarRepository;

    @EventHandler
    @Transactional
    public void on(RadarCreatedEvent event){
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setVitesseMax(event.getVitesse());
        radarRepository.save(radar);
    }

    @QueryHandler
    public List<Radar> on(FindAllRadars query){
        return radarRepository.findAll();
    }
}
