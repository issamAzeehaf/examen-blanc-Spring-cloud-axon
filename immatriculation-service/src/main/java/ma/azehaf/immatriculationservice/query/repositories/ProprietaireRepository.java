package ma.azehaf.immatriculationservice.query.repositories;

import ma.azehaf.immatriculationservice.query.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
