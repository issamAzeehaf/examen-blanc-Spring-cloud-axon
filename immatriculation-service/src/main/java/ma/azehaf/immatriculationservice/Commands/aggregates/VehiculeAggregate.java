package ma.azehaf.immatriculationservice.Commands.aggregates;

import ma.azehaf.immatriculationservice.commonapi.commands.CreateVehiculeCommand;
import ma.azehaf.immatriculationservice.commonapi.events.VehiculeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String immatriculation;
    private String marque;
    private String modele;
    private int puissance;
    private String proprietaireId;

    public VehiculeAggregate() {
        // Required by Axon
    }

    @CommandHandler
    public VehiculeAggregate(CreateVehiculeCommand command) {
        if (command.getImmatriculation() == null || command.getMarque() == null || command.getMarque().isEmpty() || command.getModele() == null || command.getModele().isEmpty() || command.getPuissance() == 0 || command.getProprietaireId() == null || command.getProprietaireId().isEmpty()) {
            throw new IllegalArgumentException("No field can be empty");
        }
        AggregateLifecycle.apply(new VehiculeCreatedEvent(
                UUID.randomUUID().toString(),
                command.getImmatriculation(),
                command.getMarque(),
                command.getModele(),
                command.getPuissance(),
                command.getProprietaireId()));
    }
    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event) {
        this.id = event.getId();
        this.immatriculation = event.getImmatriculation();
        this.marque = event.getMarque();
        this.modele = event.getModele();
        this.puissance = event.getPuissance();
        this.proprietaireId = event.getProprietaireId();
    }
}
