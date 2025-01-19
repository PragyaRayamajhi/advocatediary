/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.advocatediary.controller.algorithms;
import com.advocatediary.model.AdvocateDiaryModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PragyaRayamajhi 23048659
 */
public class InsertionSort {
    
    List<AdvocateDiaryModel> caseSortList;

    public InsertionSort() {
        caseSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of CaseModel objects by their ItemName in ascending or descending order.
     *
     * @param caseList the list of CaseModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<AdvocateDiaryModel> sortByItemName(List<AdvocateDiaryModel> caseList, boolean isDesc) {
        this.caseSortList.clear();
        this.caseSortList.addAll(caseList);

        if (caseSortList == null || caseSortList.isEmpty()) {
            throw new IllegalArgumentException("Case list cannot be null or empty.");
        }

        // Insertion sort algorithm
        for (int i = 1; i < caseSortList.size(); i++) {
            AdvocateDiaryModel currentCase = caseSortList.get(i);
            int j = i - 1;

            // Move elements that are greater than currentcase (or less, based on order)
            while (j >= 0 && shouldSwap(currentCase.getCaseName(), caseSortList.get(j).getCaseName(), isDesc)) {
                caseSortList.set(j + 1, caseSortList.get(j));
                j = j - 1;
            }
            caseSortList.set(j + 1, currentCase);
        }

        return caseSortList;
    }

    /**
     * Determines whether the current ItemName should be swapped based on the order.
     *
     * @param current the current ItemName value
     * @param comparison the ItemName to compare with
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current ItemName should be swapped; false otherwise
     */
    private boolean shouldSwap(String current, String other, boolean isDesc){
     int comparisonResult=current.compareTo(other);//lexicographical comparison
     return isDesc?comparisonResult>0:comparisonResult<0;
    }
}