package ma.azehaf.radarservice.commandes.aggregates;

import lombok.NoArgsConstructor;
import ma.azehaf.radarservice.commonapi.commands.CreateRadarCommand;
import ma.azehaf.radarservice.commonapi.events.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor // Required by Axon
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private int vitesse;
    private double longitude;
    private double latitude;
    //constructor
    @CommandHandler
    public RadarAggregate(CreateRadarCommand createRadarCommand) {
        AggregateLifecycle.apply(new RadarCreatedEvent(
                createRadarCommand.getId(),
                createRadarCommand.getVitesse(),
                createRadarCommand.getLongitude(),
                createRadarCommand.getLatitude()
        ));
    }
    // method on
    @EventSourcingHandler
    public void on(RadarCreatedEvent radarCreatedEvent) {
        this.radarId = radarCreatedEvent.getId();
        this.vitesse = radarCreatedEvent.getVitesse();
        this.longitude = radarCreatedEvent.getLongitude();
        this.latitude = radarCreatedEvent.getLatitude();
    }



}
