package com.advocatediary.util;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JLabel;


/**
 *
 * @author PragyaRayamajhi 23048659
 */

public class ValidationUtil {

    // Regular expressions for validation
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+"); // Numeric pattern
    private static final Pattern CASE_ID_PATTERN = Pattern.compile("^\\d{5}$"); // Case ID with 5 digits
    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$"); // Only alphabets and spaces
    private static final Pattern CASE_NAME_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$"); // Up to 3 words (clientName, assignedLawyer, caseName)
    private static final Pattern COURT_NAME_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$"); // Court name: max 2 words
    private static final Pattern FILING_DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$"); // Filing date format: DD-MM-YYYY
    private static final Pattern CONTACT_NO_PATTERN = Pattern.compile("^(98|97)\\d{8}$"); // Contact no: starts with 98 or 97, 10 digits

    // Helper method to check if a string is null or empty
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the case ID.
     * It should be numeric and exactly 5 digits.
     *
     * @param caseId the case ID to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidCaseId(String caseId, JLabel lblError) {
        if (isNullOrEmpty(caseId)) {
            lblError.setText("Case ID cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!CASE_ID_PATTERN.matcher(caseId).matches()) {
            lblError.setText("Case ID must be exactly 5 digits.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the case name.
     * It should contain only alphabets and up to 3 words.
     *
     * @param caseName the case name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidCaseName(String caseName, JLabel lblError) {
        if (isNullOrEmpty(caseName)) {
            lblError.setText("Case name cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!CASE_NAME_PATTERN.matcher(caseName).matches()) {
            lblError.setText("Case name must contain only alphabets and up to 3 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the case type.
     * It should contain only alphabets.
     *
     * @param caseType the case type to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidCaseType(String caseType, JLabel lblError) {
        if (isNullOrEmpty(caseType)) {
            lblError.setText("Case type cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(caseType).matches()) {
            lblError.setText("Case type must contain only alphabets.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the assigned lawyer.
     * It should contain only alphabets and up to 3 words.
     *
     * @param assignedLawyer the assigned lawyer to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidAssignedLawyer(String assignedLawyer, JLabel lblError) {
        if (isNullOrEmpty(assignedLawyer)) {
            lblError.setText("Assigned lawyer cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!CASE_NAME_PATTERN.matcher(assignedLawyer).matches()) {
            lblError.setText("Assigned lawyer must contain only alphabets and up to 3 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the case status.
     * It should contain only alphabets.
     *
     * @param caseStatus the case status to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidCaseStatus(String caseStatus, JLabel lblError) {
        if (isNullOrEmpty(caseStatus)) {
            lblError.setText("Case status cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(caseStatus).matches()) {
            lblError.setText("Case status must contain only alphabets.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the court name.
     * It must be a string and contain at most two words.
     *
     * @param courtName the court name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidCourtName(String courtName, JLabel lblError) {
        if (isNullOrEmpty(courtName)) {
            lblError.setText("Court name cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!COURT_NAME_PATTERN.matcher(courtName).matches()) {
            lblError.setText("Court name must be a string and contain a maximum of two words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the filing date.
     * It should be in the format DD-MM-YYYY.
     *
     * @param filingDate the filing date to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidFilingDate(String filingDate, JLabel lblError) {
        if (isNullOrEmpty(filingDate)) {
            lblError.setText("Filing date cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!FILING_DATE_PATTERN.matcher(filingDate).matches()) {
            lblError.setText("Filing date must be in the format DD-MM-YYYY.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the client name.
     * It must be a string and contain at most three words.
     *
     * @param clientName the client name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidClientName(String clientName, JLabel lblError) {
        if (isNullOrEmpty(clientName)) {
            lblError.setText("Client name cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        // Updated regular expression: allow up to 3 words
        if (!CASE_NAME_PATTERN.matcher(clientName).matches()) {
            lblError.setText("Client name must be a string and contain a maximum of three words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the contact number.
     * It must be numeric, start with 98 or 97, and be exactly 10 digits.
     *
     * @param contactNo the contact number to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidContactNo(String contactNo, JLabel lblError) {
        if (isNullOrEmpty(contactNo)) {
            lblError.setText("Contact number cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!CONTACT_NO_PATTERN.matcher(contactNo).matches()) {
            lblError.setText("Contact number must be numeric, start with 98 or 97, and be exactly 10 digits.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

}
