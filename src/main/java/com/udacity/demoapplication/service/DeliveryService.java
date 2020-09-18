package com.udacity.demoapplication.service;

import com.udacity.demoapplication.data.delivery.Delivery;
import com.udacity.demoapplication.data.delivery.DeliveryRepository;
import com.udacity.demoapplication.data.delivery.RecipientAndPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        return deliveryRepository.getBill(deliveryId);
    }
}
