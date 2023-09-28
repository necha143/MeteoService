package rest.MeteorologicalService.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class SensorDTO {
    @Column(name = "name")
    @NotEmpty(message = "Имя не должно быть пустым")
    private String name;

    public SensorDTO() {
    }

    public SensorDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
