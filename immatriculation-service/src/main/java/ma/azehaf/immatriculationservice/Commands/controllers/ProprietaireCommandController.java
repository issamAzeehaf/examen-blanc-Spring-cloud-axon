package ma.azehaf.immatriculationservice.Commands.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.immatriculationservice.commonapi.commands.CreateProprietaireCommand;
import ma.azehaf.immatriculationservice.commonapi.dtos.CreateProrietaireRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/proprietaire")
@AllArgsConstructor
@Service
public class ProprietaireCommandController {
    private CommandGateway commandGateway;
    @PostMapping(path = "/create")
    public CompletableFuture<String> createOwner(@RequestBody CreateProrietaireRequestDTO createProrietaireRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateProprietaireCommand(
                UUID.randomUUID().toString(),
                createProrietaireRequestDTO.getNom(),
                createProrietaireRequestDTO.getDateNaiss(),
                createProrietaireRequestDTO.getEmail()
        ));
        return response;
    }
}
