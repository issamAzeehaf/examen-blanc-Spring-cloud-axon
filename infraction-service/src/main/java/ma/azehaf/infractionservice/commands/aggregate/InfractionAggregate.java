package ma.azehaf.infractionservice.commands.aggregate;

import ma.azehaf.infractionservice.commonapi.commands.CreateInfractionCommand;
import ma.azehaf.infractionservice.commonapi.events.InfractionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

import java.util.Date;

public class InfractionAggregate {
    @AggregateIdentifier
    private String id;
    private String matricule;
    private double vehicleSpeed;
    private Date date;
    private String radarId;
    private double maxSpeedAllowed;
    private double amende;

    public InfractionAggregate() {
    }

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {
        if (command.getMatricule() == null || command.getMatricule().isEmpty()) {
            throw new IllegalArgumentException("Matricule cannot be empty");
        }
        AggregateLifecycle.apply(new InfractionCreatedEvent(
                command.getId(),
                command.getMatricule(),
                command.getVehicleSpeed(),
                command.getDate(),
                command.getRadarId(),
                command.getMaxSpeedAllowed()));
    }
    @EventSourcingHandler
    public void on(InfractionCreatedEvent event) {
        this.id = event.getId();
        this.matricule = event.getMatricule();
        this.vehicleSpeed = event.getVehicleSpeed();
        this.date = event.getDate();
        this.radarId = event.getRadarId();
        this.maxSpeedAllowed = event.getMaxSpeedAllowed();
    }


}
