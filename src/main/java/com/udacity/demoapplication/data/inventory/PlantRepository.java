package com.udacity.demoapplication.data.inventory;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    public Boolean isPlantDelivered(Long plantId);

    //@Query("select * from plant p where p.price < :price")
    public List<Plant> findByPriceLessThan(@Param("price") BigDecimal price);
}
