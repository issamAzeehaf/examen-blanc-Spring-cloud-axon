package ma.azehaf.immatriculationservice.query.controllers;

import lombok.AllArgsConstructor;
import ma.azehaf.immatriculationservice.commonapi.queries.GetProprietaire;
import ma.azehaf.immatriculationservice.commonapi.queries.GetProprietaires;
import ma.azehaf.immatriculationservice.query.entities.Proprietaire;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query/proprietaire")
@AllArgsConstructor
@Service
@CrossOrigin(origins = "*")
public class ProprietaireQueryController {
    private QueryGateway queryGateway;


    @GetMapping(path = "/")
    public List<Proprietaire> getProprietaires() {
        return queryGateway.query(new GetProprietaires(), ResponseTypes.multipleInstancesOf(Proprietaire.class)).join();
    }

    @GetMapping(path = "/{id}")
    public Proprietaire getProprietaire(@PathVariable String id) {
        return queryGateway.query(new GetProprietaire(id), Proprietaire.class).join();
    }

}
