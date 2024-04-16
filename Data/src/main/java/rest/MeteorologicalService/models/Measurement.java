package rest.MeteorologicalService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @NotNull(message = "Величина температуры не должна быть пустой")
    @Max(value = 100, message = "Значение температуры должно быть не более 100")
    @Min(value = -100, message = "Значение температуры должно быть не менее -100")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "Отметка о дожде не должна быть пустой")
    private boolean raining;

    @Column(name = "date_time")
    private LocalDateTime addedAt;

    @ManyToOne
    @JoinColumn(name = "sensor_name", referencedColumnName = "name")
    @NotNull(message = "Поле 'sensor' не должно быть пустым")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(double value, boolean raining, LocalDateTime addedAt, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.addedAt = addedAt;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", raining=" + raining +
                ", addedAt=" + addedAt +
                ", sensor=" + sensor +
                '}';
    }
}
