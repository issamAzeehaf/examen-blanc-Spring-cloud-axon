package ma.azehaf.infractionservice.query.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.infractionservice.commonapi.queries.GetAllInfractions;
import ma.azehaf.infractionservice.commonapi.queries.GetInfraction;
import ma.azehaf.infractionservice.commonapi.queries.GetInfractionByProprietaire;
import ma.azehaf.infractionservice.commonapi.queries.GetInfractionByVehicule;
import ma.azehaf.infractionservice.query.entities.Infraction;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/infraction")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class InfractionQueryHandler {
    private QueryGateway queryGateway;

    @GetMapping("/All")
    public CompletableFuture<List<Infraction>> getAll(){
        return queryGateway.query(new GetAllInfractions(), ResponseTypes.multipleInstancesOf(Infraction.class));
    }

    @GetMapping("/byIdProprietaire/{id}")
    public CompletableFuture<List<Infraction>> getByIdProprietaire(@PathVariable String id){
        return queryGateway.query(new GetInfractionByProprietaire(id), ResponseTypes.multipleInstancesOf(Infraction.class));
    }

    @GetMapping("/byIdVehicule/{id}")
    public CompletableFuture<List<Infraction>> getByIdVehicule(@PathVariable String id){
        return queryGateway.query(new GetInfractionByVehicule(id), ResponseTypes.multipleInstancesOf(Infraction.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Infraction> getById(@PathVariable String id){
        return queryGateway.query(new GetInfraction(id), ResponseTypes.instanceOf(Infraction.class));
    }


}
