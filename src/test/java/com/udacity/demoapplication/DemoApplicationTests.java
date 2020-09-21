package com.udacity.demoapplication;

import com.udacity.demoapplication.data.delivery.Delivery;
import com.udacity.demoapplication.data.delivery.DeliveryRepository;
import com.udacity.demoapplication.data.inventory.Plant;
import com.udacity.demoapplication.data.inventory.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
class DemoApplicationTests {

	@Autowired
	TestEntityManager testEntityManager;

	@Autowired
	PlantRepository plantRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testPriceLessThan() {
		Plant plant = testEntityManager.persist(new Plant("Bell",2.99));
		testEntityManager.persist(new Plant("Pinky",6.20));

		List<Plant> plants = plantRepository.findByPriceLessThan(BigDecimal.valueOf(6.20));
		Assertions.assertEquals(1, plants.size(), "Size");
		Assertions.assertEquals(1, plants.get(0).getId(), "Id");
	}

	@Test
	public void testDeliveryCompleted() {
		Plant plant = testEntityManager.persist(new Plant("Bell",2.99));
		Delivery delivery = testEntityManager.persist(new Delivery("Big Joe", "ButcherBay 12", LocalDateTime.now()));
		delivery.setPlants(Lists.newArrayList(plant));
		plant.setDelivery(delivery);

		Assertions.assertFalse(plantRepository.deliveryCompleted(plant.getId()), "before: completed");
		delivery.setCompleted(true);
		Assertions.assertTrue(plantRepository.deliveryCompleted(plant.getId()), "after: completed");
	}
}
