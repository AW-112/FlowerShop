package com.udacity.demoapplication.data.inventory;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "plant")
public class Flower {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;
    private String color;
    @Column(precision = 12, scale = 4)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
