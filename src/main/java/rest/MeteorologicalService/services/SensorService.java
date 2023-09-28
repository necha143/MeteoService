package rest.MeteorologicalService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.MeteorologicalService.models.Sensor;
import rest.MeteorologicalService.repositories.SensorRepository;
import rest.MeteorologicalService.util.SensorNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Sensor findOne(int id) {
        Optional<Sensor> foundPerson = sensorRepository.findById(id);
        return foundPerson.orElseThrow(SensorNotFoundException::new);
    }

    public Sensor findOne(String name) {
        Optional<Sensor> foundSensor = sensorRepository.findByName(name);
        return foundSensor.orElseThrow(SensorNotFoundException::new);
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
