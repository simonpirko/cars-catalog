package com.carscatalog.service;

import com.carscatalog.CarsCatalogApplication;
import com.carscatalog.entity.Cars;
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
public class CarsServiceTest {

	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	@Test
	public void testSaveCar() {

		Cars cars = new Cars();

		cars.setMark("AUDI");
		cars.setModel("A5");
		cars.setYear(2015);
		cars.setScope(3.2);
		cars.setMileage(34600);
		cars.setTransmission("Auto");
		cars.setPrice(new BigDecimal("23500"));
		cars.setDate(new Date(2017 - 6 - 12));
		cars.setImage("null");
		cars.setId(Long.valueOf("2"));

		carsService.saveCar(cars);
		assertNotNull(cars.getId());

		Cars fetcherCars = carsService.getCarById(cars.getId());

		assertNotNull(fetcherCars);

		assertEquals(cars.getId(), fetcherCars.getId());

	}
}