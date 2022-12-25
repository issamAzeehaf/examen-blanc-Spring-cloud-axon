package ma.azehaf.immatriculationservice.query.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.immatriculationservice.commonapi.queries.GetVehicule;
import ma.azehaf.immatriculationservice.commonapi.queries.GetVehicules;
import ma.azehaf.immatriculationservice.query.entities.Proprietaire;
import ma.azehaf.immatriculationservice.query.entities.Vehicule;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/vehicules")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Service
public class VehiculeQueryController {
    private QueryGateway queryGateway;
    @GetMapping(path = "/")
    public List<Vehicule> getVehicules() {
        return queryGateway.query(new GetVehicules(), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
    }

    @GetMapping(path = "/{id}")
    public Proprietaire getVehicule(@PathVariable String id) {
        return queryGateway.query(new GetVehicule(id), Proprietaire.class).join();
    }
}
