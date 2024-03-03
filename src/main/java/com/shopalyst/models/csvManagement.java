/* 
 * code if the data is fetched for csv file for every API call;
 */

// package com.shopalyst.models;

// import java.io.FileReader;
// import java.io.Reader;
// import java.util.ArrayList;
// import java.util.List;

// import org.apache.commons.csv.CSVFormat;
// import org.springframework.core.io.ClassPathResource;

// // @Service
// public class CSVManagement {
//     public List<Activity> readCSVFile(String customerId, String productId) {
//         try (

//                 Reader in = new FileReader(new ClassPathResource("sample_data_csv.csv").getFile())) {
//             List<Activity> activities = new ArrayList<>();

//             CSVFormat.RFC4180.builder()
//                     .setAllowMissingColumnNames(true)
//                     .setHeader("shopper_id", "timestamp", "action", "product_id", "count")
//                     .setSkipHeaderRecord(true).build().parse(in).forEach(record -> {
//                         if (productId == null) {
//                             if (customerId.equals(record.get("shopper_id"))) {
//                                 Activity activity = new Activity(record.get("shopper_id"), record.get("timestamp"),
//                                         record.get("action"),
//                                         record.get("product_id"), 1);
//                                 activities.add(activity);
//                             }
//                         } else {
//                             if (customerId.equals(record.get("shopper_id"))
//                                     && productId.equals(record.get("product_id"))) {
//                                 Activity activity = new Activity(record.get("shopper_id"), record.get("timestamp"),
//                                         record.get("action"),
//                                         record.get("product_id"), 1);
//                                 activities.add(activity);
//                             }
//                         }

//                     });

//             return activities;

//         } catch (Exception e) {
//             List<Activity> activities = new ArrayList<>();
//             System.err.println("Unable to read CSV file" + e);

//             return activities;
//         }
//     }

// }
