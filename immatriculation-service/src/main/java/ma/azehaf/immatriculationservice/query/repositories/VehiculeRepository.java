package ma.azehaf.immatriculationservice.query.repositories;

import ma.azehaf.immatriculationservice.query.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {

}

