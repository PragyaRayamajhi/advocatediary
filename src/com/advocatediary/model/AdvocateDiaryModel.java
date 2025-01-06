package com.advocatediary.model;

/**
 *
 * @author PragyaRayamajhi  23048659
 */
public class AdvocateDiaryModel {
    private int caseId;
    private String caseName;
    private String caseType; // For comboBox selection
    private String assignedLawyer;
    private String caseStatus; // For comboBox selection
    
    // New fields
    private String courtName;
    private String filingDate; // Format: DD-MM-YYYY
    private String clientName;
    private String contactNo; // Format: 10 digits, starts with 98 or 97

    public AdvocateDiaryModel() {
    }

    public AdvocateDiaryModel(int caseId, String caseName, String caseType, String assignedLawyer, String caseStatus, String courtName, String filingDate, String clientName, String contactNo) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.caseType = caseType;
        this.assignedLawyer = assignedLawyer;
        this.caseStatus = caseStatus;
        this.courtName = courtName;
        this.filingDate = filingDate;
        this.clientName = clientName;
        this.contactNo = contactNo;
    }

    // Getters
    public int getCaseId() {
        return caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getAssignedLawyer() {
        return assignedLawyer;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public String getCourtName() {
        return courtName;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactNo() {
        return contactNo;
    }

    // Setters
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public void setAssignedLawyer(String assignedLawyer) {
        this.assignedLawyer = assignedLawyer;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }  
}