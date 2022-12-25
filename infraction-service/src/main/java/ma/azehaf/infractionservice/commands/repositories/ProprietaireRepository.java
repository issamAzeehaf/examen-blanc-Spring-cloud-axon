package ma.azehaf.infractionservice.commands.repositories;

import ma.azehaf.infractionservice.commands.models.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
}
