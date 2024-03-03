package com.shopalyst.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shopalyst.entities.CSVCaching;
import com.shopalyst.models.Activity;

@Service
public class CustomerService {

    // @Autowired
    // csvManagement csvManagement;

    private final Map<String, List<Activity>> activityMap;

    public CustomerService(CSVCaching csvCaching) {
        this.activityMap = csvCaching.getActivityMap();
    }

    public List<Activity> getCustomerData(String customerId, String productId) {

        //code for fetching csv file in every API call
        // List<Activity> activities = csvManagement.readCSVFile(customerId, productId);

        List<Activity> activities = activityMap.get(customerId);
      
        if (productId == null && activities != null) {//only customerId
            return activities;
        } else if (activities != null && productId != null) {// both customer and product Id
           
            List<Activity> activitiesMatchProductId = new ArrayList<>();

            for (Activity activity : activities) {
                if (activity.getProductId().equals(productId)) {
                    activitiesMatchProductId.add(activity);
                }
            }
            if (activitiesMatchProductId.isEmpty()) {
                throw new IllegalArgumentException("no activities found; check the customer Id & product Id");

            }
            return activitiesMatchProductId;

        } else {
            throw new IllegalArgumentException("no activities found; check the customer Id");
        }
    }
}
