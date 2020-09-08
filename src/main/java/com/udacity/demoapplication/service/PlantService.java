package com.udacity.demoapplication.service;

import com.udacity.demoapplication.data.inventory.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name) {
        return new Plant();
    }
}
