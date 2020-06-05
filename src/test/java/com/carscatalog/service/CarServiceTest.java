package com.carscatalog.service;

import com.carscatalog.CarsCatalogApplication;
import com.carscatalog.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {CarsCatalogApplication.class})
public class CarServiceTest {

	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Test
	public void testSaveCar() {

		Car car = new Car();

		car.setMark("AUDI");
		car.setModel("A5");
		car.setYear(2015);
		car.setScope(3.2);
		car.setMileage(34600);
		car.setTransmission("Auto");
		car.setPrice(new BigDecimal("23500"));
		car.setDate(new Date(2017 - 6 - 12));
		car.setImage("null");
		car.setId(Long.valueOf("2"));

		carService.saveCar(car);
		assertNotNull(car.getId());

		Car fetcherCar = carService.getCarById(car.getId());

		assertNotNull(fetcherCar);

		assertEquals(car.getId(), fetcherCar.getId());

	}
}