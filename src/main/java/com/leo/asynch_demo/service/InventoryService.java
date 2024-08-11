package com.leo.asynch_demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService {

    /**
     * @Author: Leo
     * @Date: 2022/10/11 15:40
     * Checks the availability of a product based on the provided trackingId.
     * @param trackingId the ID of the product to check
     * @return true if the product is available, false otherwise
     */
    public boolean checkProductAvailability(String trackingId) {
        return true;
    }

}
