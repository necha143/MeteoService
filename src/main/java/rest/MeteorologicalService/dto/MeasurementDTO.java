package rest.MeteorologicalService.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {
    @NotNull(message = "Величина температуры не должна быть пустой")
    @Max(value = 100, message = "Значение температуры должно быть не более 100")
    @Min(value = -100, message = "Значение температуры должно быть не менее -100")
    private double value;

    @NotNull(message = "Отметка о дожде не должна быть пустой")
    private boolean raining;

    @NotNull(message = "Поле 'sensor' не должно быть пустым")
    private SensorDTO sensor;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
