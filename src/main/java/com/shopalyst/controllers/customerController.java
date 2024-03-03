package com.shopalyst.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopalyst.models.Activity;
import com.shopalyst.services.customerService;

@RestController
@RequestMapping("/CustomerAPI/customers")
public class customerController {

    @Autowired
    customerService CustomerService;

    @GetMapping("/{customerId}/actions")
    public ResponseEntity<List<Activity>> getCustomerActions(
            @RequestParam(required = false) String productId,
            @PathVariable("customerId") String customerId) {

        List<Activity> activities = CustomerService.getCustomerData(customerId, productId);
        return ResponseEntity.ok()
                .body(activities);

    }
}
