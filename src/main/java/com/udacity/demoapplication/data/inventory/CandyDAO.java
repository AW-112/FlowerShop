package com.udacity.demoapplication.data.inventory;

import java.util.List;

public interface CandyDAO {
    public List<CandyData> list();
    public void addToDelivery(Long candyId, Long deliveryId);
    public List<CandyData> findByDelivery(Long deliveryId);
}
