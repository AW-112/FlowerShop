package com.udacity.demoapplication.data.inventory;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shrub")
public class Shrub extends Plant {
    private Long heightCm;
    private Long widthCm;

    public Long getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(Long heightCm) {
        this.heightCm = heightCm;
    }

    public Long getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(Long widthCm) {
        this.widthCm = widthCm;
    }
}
