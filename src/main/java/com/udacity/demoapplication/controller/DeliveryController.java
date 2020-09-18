package com.udacity.demoapplication.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.demoapplication.data.delivery.Delivery;
import com.udacity.demoapplication.data.delivery.RecipientAndPrice;
import com.udacity.demoapplication.data.inventory.Plant;
import com.udacity.demoapplication.service.DeliveryService;
import com.udacity.demoapplication.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliverySerivce;
    @Autowired
    PlantService plantService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliverySerivce.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliverySerivce.getBill(deliveryId);
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findCheaperPlants(price);
    }
}
