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
 * @author PragyaRayamajhi    23048659
 */
public class SelectionSort {
    
    List<AdvocateDiaryModel> caseSortList;

    public SelectionSort() {
        caseSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of caseModel objects by their case ID in ascending or descending order.
     *
     * @param caseList the list of caseModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<AdvocateDiaryModel> sortByCaseId(List<AdvocateDiaryModel> caseList, boolean isDesc) {
        this.caseSortList.clear();
        this.caseSortList.addAll(caseList);

        if (caseSortList == null || caseSortList.isEmpty()) {
            throw new IllegalArgumentException("case list cannot be null or empty.");
        }

        // Selection sort algorithm
        for (int i = 0; i < caseSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(caseSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(caseSortList, i, extremumIndex);
            }
        }

        return caseSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list from the start index.
     *
     * @param caseSortList the list of caseModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<AdvocateDiaryModel> caseSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < caseSortList.size(); j++) {
            if (shouldSwap(caseSortList.get(j).getCaseId(), caseSortList.get(extremumIndex).getCaseId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should replace the extremum; false otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param caseSortList the list of caseModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<AdvocateDiaryModel> caseSortList, int i, int j) {
        AdvocateDiaryModel temp = caseSortList.get(i);
        caseSortList.set(i, caseSortList.get(j));
        caseSortList.set(j, temp);
    }
}