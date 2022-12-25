package ma.azehaf.radarservice.query.repositories;

import ma.azehaf.radarservice.query.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
