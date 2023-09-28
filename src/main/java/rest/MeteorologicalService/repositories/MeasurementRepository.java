package rest.MeteorologicalService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.MeteorologicalService.models.Measurement;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    Optional<Measurement> findBySensorName(String name);
}
