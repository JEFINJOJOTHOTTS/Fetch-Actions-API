package com.shopalyst.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopalyst.models.Activity;
import com.shopalyst.services.CustomerService;

@RestController
@RequestMapping("/CustomerAPI/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerId}/actions")
    public ResponseEntity<?> getCustomerActions(
            @RequestParam(required = false) String productId,
            @PathVariable("customerId") String customerId) {
        try {

            List<Activity> activities = customerService.getCustomerData(customerId, productId);
            
            return ResponseEntity.ok().body(activities);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
