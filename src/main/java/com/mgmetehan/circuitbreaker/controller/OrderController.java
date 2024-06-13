package com.mgmetehan.circuitbreaker.controller;

import com.mgmetehan.circuitbreaker.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orderProcess")
    public String orderProcess() {
        try {
            orderService.orderProcess("");
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }
}

