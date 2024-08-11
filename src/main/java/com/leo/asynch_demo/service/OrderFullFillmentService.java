package com.leo.asynch_demo.service;

import com.leo.asynch_demo.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderFullFillmentService {
    private final PaymentService paymentService;
    private final InventoryService inventoryService;


    /*
    /1)purcase order
     2)inventory services
     3)payment serices
     4)notification
     5)assign vendor
     6)packaging
     7)assing the delivey vendor
     8)Dispatch
     */


    public Order processOrder(Order order) {
        order.setTrackingId(UUID.randomUUID().toString());
        if (inventoryService.checkProductAvailability(order.getProductId())) {
            //handle exception here
            paymentService.processPayment(order);
        } else {
            throw new RuntimeException("Technical issue. Product not available");
        }
        return order;
    }

    @Async("asyncExecutor")
    public void notifyUser(Order order) throws InterruptedException {
        //send notification
        Thread.sleep(4000);
        log.info("Notification sent successfully {}", Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void assignVendor(Order order) throws InterruptedException {
        //send notification
        Thread.sleep(5000);
        log.info("Vendor assigned successfully {}", Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void packaging(Order order) throws InterruptedException {
        //send notification
        Thread.sleep(2000);
        log.info("Packaging done successfully {}", Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void delivery(Order order) throws InterruptedException {
        //send notification
        Thread.sleep(3000);
        log.info("Delivery done successfully {}", Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void dispatch(Order order) throws InterruptedException {
        //send notification
        Thread.sleep(3000);
        log.info("Dispatch done successfully {}", Thread.currentThread().getName());
    }
}
