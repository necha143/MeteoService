package rest.MeteorologicalService.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rest.MeteorologicalService.models.Sensor;
import rest.MeteorologicalService.services.SensorService;

@Component
public class SensorValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Sensor.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if (sensorService.findOne(sensor.getName()).isPresent()){
            errors.rejectValue(
                    "name",
                    "",
                    "Сенсор с таким названием уже добавлен");
        }
    }
}
