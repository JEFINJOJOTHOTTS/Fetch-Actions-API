package com.shopalyst.entities;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.shopalyst.models.Activity;

import jakarta.annotation.PostConstruct;

@Component
public class CSVCaching {

    private Map<String, List<Activity>> activityMap = new HashMap<>();

    public Map<String, List<Activity>> getActivityMap() {
        return activityMap;
    }

    /**
     * Reads the csv file from sample_data_csv.csv file in the classpath
     * and loads into memory
     */
    @PostConstruct
    public void readCSVFile() {
        try (

                Reader in = new FileReader(new ClassPathResource("sample_data_csv.csv").getFile())) {

            CSVFormat.RFC4180.builder()
                    .setHeader("shopper_id", "timestamp", "action", "product_id", "count")
                    .setSkipHeaderRecord(true).build().parse(in).forEach(record -> {
                        Activity activity = new Activity(record.get("shopper_id"), record.get("timestamp"),
                                record.get("action"),
                                record.get("product_id"), 1);
                        if (activityMap.get(activity.getCustomerId()) != null) {
                            activityMap.get(activity.getCustomerId()).add(activity);

                        } else {
                            List<Activity> activityList = new ArrayList<>();
                            activityList.add(activity);
                            activityMap.put(activity.getCustomerId(), activityList);
                        }

                    });

        } catch (Exception e) {
            throw new Error("CSV file can not;");
        }
    }

}