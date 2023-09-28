package rest.MeteorologicalService.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {
    @Column(name = "value")
    @NotNull(message = "Величина температуры не должна быть пустой")
    @Max(value = 100, message = "Значение температуры должно быть не более 100")
    @Min(value = -100, message = "Значение температуры должно быть не менее -100")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "Отметка о дожде не должна быть пустой")
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_name", referencedColumnName = "name")
    @NotEmpty(message = "Поле 'sensor' не должно быть пустым")
    private SensorDTO sensorDTO;

    public MeasurementDTO() {
    }

    public MeasurementDTO(double value, boolean raining, SensorDTO sensorDTO) {
        this.value = value;
        this.raining = raining;
        this.sensorDTO = sensorDTO;
    }

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

    public SensorDTO getSensorDTO() {
        return sensorDTO;
    }

    public void setSensorDTO(SensorDTO sensorDTO) {
        this.sensorDTO = sensorDTO;
    }
}
