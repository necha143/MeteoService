package rest.MeteorologicalService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import rest.MeteorologicalService.controllers.SensorController;
import rest.MeteorologicalService.models.Sensor;
import rest.MeteorologicalService.services.SensorService;
import rest.MeteorologicalService.util.SensorValidator;

import java.util.Optional;

@SpringBootTest
class MeteorologicalServiceApplicationTests {

	@Test
	void sensorControllerGetMethodTest() {
		Sensor sensor = new Sensor("SensorInTest");

		SensorService sensorServiceMock = Mockito.mock(SensorService.class);
		
		Mockito.when(sensorServiceMock.findOne(1)).thenReturn(sensor);

		SensorController sensorController = new SensorController(sensorServiceMock, new ModelMapper(), new SensorValidator(sensorServiceMock));
		
		String expected = sensor.getName();
		String actual = sensorController.getSensor(1).getName();

		Assertions.assertEquals(expected, actual);
	}

}
