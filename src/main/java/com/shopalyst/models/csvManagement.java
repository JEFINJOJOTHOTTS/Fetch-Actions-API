package com.shopalyst.models;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.shopalyst.models.Activity;

@Service
public class csvManagement {
    public void readCSVFile(String customerId, String productId) {
        try (

                Reader in = new FileReader(new ClassPathResource("sample_data_csv.csv").getFile())) {
            List<Activity> activities = new ArrayList<>();

            CSVFormat.RFC4180.builder()
                    .setAllowMissingColumnNames(true)
                    .setHeader("shopper_id", "timestamp", "action", "product_id", "count")
                    .setSkipHeaderRecord(true).build().parse(in).forEach(record -> {
                        if (customerId.equals(record.get("shopper_id"))) {
                            System.out.println(record.get("shopper_id"));

                        }
                        // Activity activity = new Activity(record.shopper_id, " timestamp", "action",
                        // "productId", 1);

                        // activities.add(activity);

                    });
            for (Activity activity : activities) {
                System.out.println("Customer ID: " + activity.getCustomerId());
                System.out.println("Timestamp: " + activity.getTimestamp());
                System.out.println("Action: " + activity.getAction());
                System.out.println("Product ID: " + activity.getProductId());
                System.out.println("Count: " + activity.getCount());
            }

        } catch (Exception e) {
            System.err.println("Unable to read CSV file" + e);
            // ("Unable to read CSV file" + e);
         }
    }

}
