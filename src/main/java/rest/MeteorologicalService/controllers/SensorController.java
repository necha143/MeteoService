package rest.MeteorologicalService.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.MeteorologicalService.dto.SensorDTO;
import rest.MeteorologicalService.models.Sensor;
import rest.MeteorologicalService.services.SensorService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sensor")
public class SensorController {
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<SensorDTO> getSensors() {
        return sensorService.findAll().stream().map(this::convertToSensorDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SensorDTO getSensor (@PathVariable("id") int id) {
        return convertToSensorDTO(sensorService.findOne(id));
    }

    // TODO registration 

    private SensorDTO convertToSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }
}
