/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.advocatediary.controller.algorithms;

import com.advocatediary.model.AdvocateDiaryModel;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author PragyaRayamajhi   23048659
 */

public class BinarySearch {

    // Generic binary search method
    public AdvocateDiaryModel searchByField(String searchValue, String searchColumn, List<AdvocateDiaryModel> contractList, int left, int right) {
        if (right < left) {
            return null; // Element not found
        }

        int mid = (left + right) / 2;

        // Get the value based on the selected column
        String midValue = getFieldValue(contractList.get(mid), searchColumn);

        // Handle numeric comparisons for Case ID
        if (searchColumn.equals("Case ID")) {
            try {
                int searchInt = Integer.parseInt(searchValue); // Convert the search value to an integer
                int midInt = Integer.parseInt(midValue); // Convert mid value (Drone ID) to integer

                if (searchInt == midInt) { // Match found
                    return contractList.get(mid);
                } else if (searchInt < midInt) { // Search left half
                    return searchByField(searchValue, searchColumn, contractList, left, mid - 1);
                } else { // Search right half
                    return searchByField(searchValue, searchColumn, contractList, mid + 1, right);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for Drone ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        // Default case (string comparison for other fields, if needed)
        int comparison = searchValue.compareToIgnoreCase(midValue);
        if (comparison == 0) { // Match found
            return contractList.get(mid);
        } else if (comparison < 0) { // Search left half
            return searchByField(searchValue, searchColumn, contractList, left, mid - 1);
        } else { // Search right half
            return searchByField(searchValue, searchColumn, contractList, mid + 1, right);
        }
    }

    // Helper method to fetch value based on selected column
    private String getFieldValue(AdvocateDiaryModel advocate, String columnName) {
        switch (columnName) {
            case "Case ID":
                return String.valueOf(advocate.getCaseId()); // Convert integer to string
            case "Case Name":
                return advocate.getCaseName();
            case "Case Type":
                return advocate.getCaseType();
            case "AssigendLawyer":
                return advocate.getAssignedLawyer();
            case "Case Status":
                return advocate.getCaseStatus();
            case "Court Name":
                return advocate.getCourtName();
            case "Filing Date":
                return advocate.getFilingDate();
            case "Client Name":
                return advocate.getClientName();
            case "ContactNo":
                return String.valueOf(advocate.getContactNo());
            default:
                return ""; // Default case for unsupported columns
        }
    }
}