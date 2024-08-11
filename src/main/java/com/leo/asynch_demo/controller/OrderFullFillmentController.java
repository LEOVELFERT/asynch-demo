package com.leo.asynch_demo.controller;

import com.leo.asynch_demo.dto.Order;
import com.leo.asynch_demo.service.OrderFullFillmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderFullFillmentController {
    private final OrderFullFillmentService orderFullFillmentService;

    @PostMapping("/process")
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
        orderFullFillmentService.processOrder(order);
        orderFullFillmentService.notifyUser(order);
        orderFullFillmentService.assignVendor(order);
        orderFullFillmentService.packaging(order);
        orderFullFillmentService.delivery(order);
        orderFullFillmentService.dispatch(order);
        return ResponseEntity.ok(order);
    }
}
