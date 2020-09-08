package com.udacity.demoapplication.data.inventory;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.demoapplication.controller.Views;
import com.udacity.demoapplication.data.delivery.Delivery;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plant")
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;
    @Column(precision = 12, scale = 4)
    @JsonView(Views.Public.class)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
