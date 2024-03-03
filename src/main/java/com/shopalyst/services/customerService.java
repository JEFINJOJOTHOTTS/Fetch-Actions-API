package com.shopalyst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopalyst.models.Activity;
import com.shopalyst.models.csvManagement;

@Service
public class customerService {

    @Autowired
    csvManagement csvManagement;

    public List<Activity> getCustomerData(String customerId, String productId) {
        System.out.println("service");
        List<Activity> activities = csvManagement.readCSVFile(customerId, productId);

        // List<Activity> activities = new ArrayList<>();

        return activities;
    }
}
