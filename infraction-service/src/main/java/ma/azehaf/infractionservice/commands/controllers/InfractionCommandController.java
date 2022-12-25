package ma.azehaf.infractionservice.commands.controllers;

import ma.azehaf.infractionservice.commonapi.commands.CreateInfractionCommand;
import ma.azehaf.infractionservice.commonapi.dtos.CreateInfractionRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/command/infraction")
public class InfractionCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody CreateInfractionRequestDTO infractionCreationRequestDTO){
        CompletableFuture<String> response = commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                infractionCreationRequestDTO.getMatricule(),
                infractionCreationRequestDTO.getSpeed(),
                infractionCreationRequestDTO.getDate(),
                infractionCreationRequestDTO.getRadarId(),
                infractionCreationRequestDTO.getRadarSpeed()
        ));
        return response;
    }
    @GetMapping("/events/{infractionId}")
    public Stream eventsStream(@PathVariable String infractionId){
        return eventStore.readEvents(infractionId).asStream();
    }
}
