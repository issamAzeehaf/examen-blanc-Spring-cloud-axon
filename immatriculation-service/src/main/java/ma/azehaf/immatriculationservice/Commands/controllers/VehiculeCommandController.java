package ma.azehaf.immatriculationservice.Commands.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.immatriculationservice.commonapi.commands.CreateVehiculeCommand;
import ma.azehaf.immatriculationservice.commonapi.dtos.CreateVehiculeRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/vehicules")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class VehiculeCommandController {
    private CommandGateway commandGateway;
    public CompletableFuture<String> createVehicule(@RequestBody CreateVehiculeRequestDTO createVehiculeRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateVehiculeCommand(
                UUID.randomUUID().toString(),
                createVehiculeRequestDTO.getImmatriculation(),
                createVehiculeRequestDTO.getMarque(),
                createVehiculeRequestDTO.getModele(),
                createVehiculeRequestDTO.getPuissance(),
                createVehiculeRequestDTO.getProprietaireId()
        ));
        return response;
    }
}
