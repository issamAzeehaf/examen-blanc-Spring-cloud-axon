package ma.azehaf.infractionservice.commands.repositories;

import ma.azehaf.infractionservice.commands.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {

}
