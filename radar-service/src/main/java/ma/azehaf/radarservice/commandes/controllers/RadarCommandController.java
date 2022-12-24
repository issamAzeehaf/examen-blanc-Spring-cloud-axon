package ma.azehaf.radarservice.commandes.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.radarservice.commonapi.commands.CreateRadarCommand;
import ma.azehaf.radarservice.commonapi.dtos.CreateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/radar")
@AllArgsConstructor
public class RadarCommandController {
    private org.axonframework.commandhandling.gateway.CommandGateway commandGateway;
    @PostMapping(path = "/create")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO requestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                requestDTO.getVitesse(),
                requestDTO.getLongitude(),
                requestDTO.getLatitude()
        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return responseEntity;
    }

}
