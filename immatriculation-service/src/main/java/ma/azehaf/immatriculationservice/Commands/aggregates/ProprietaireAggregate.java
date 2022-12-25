package ma.azehaf.immatriculationservice.Commands.aggregates;

import lombok.NoArgsConstructor;
import ma.azehaf.immatriculationservice.commonapi.commands.CreateProprietaireCommand;
import ma.azehaf.immatriculationservice.commonapi.events.ProprietaireCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

import java.util.Date;

@NoArgsConstructor //Required by Axon
public class ProprietaireAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private Date dateNaiss;
    private String email;

    @CommandHandler
    public ProprietaireAggregate(CreateProprietaireCommand command) {
        if (command.getNom() == null || command.getNom().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        AggregateLifecycle.apply(new ProprietaireCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getDateNaiss(),
                command.getEmail()));
    }

}
