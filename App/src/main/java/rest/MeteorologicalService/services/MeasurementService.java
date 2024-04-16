package rest.MeteorologicalService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.MeteorologicalService.models.Measurement;
import rest.MeteorologicalService.repositories.MeasurementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findOne(String name) {
        return measurementRepository.findBySensorName(name).get();
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public long getRainyDaysCount() {
        return measurementRepository.findAll().stream().filter(Measurement::isRaining).count();
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setSensor(sensorService.findOne(measurement.getSensor().getName()).get());
        measurement.setAddedAt(LocalDateTime.now());
    }
}
