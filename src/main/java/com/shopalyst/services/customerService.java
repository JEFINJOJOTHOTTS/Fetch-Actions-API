package com.shopalyst.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.shopalyst.models.Activity;

@Service
public class customerService {
   
    public List<Activity> getCustomerData(String customerId, String productId) {
        
        List<Activity> activities = new ArrayList<>();

        return activities;
    }
}
