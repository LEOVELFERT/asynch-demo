package com.leo.asynch_demo.service;

import com.leo.asynch_demo.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public void processPayment(Order order) {
        log.info("Payment processed");
        try {
            //call actual code
            Thread.sleep(2000);
            log.info("Payment processed successfully");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
