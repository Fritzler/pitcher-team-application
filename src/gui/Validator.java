/*
Date Created: 4/23/2020

Version: Updated Version 1.4
Date Updated: 4/24/2020

Class: CSD 2522 - Java Programming II
Professor: Al Tokarsky

Program Page Author: Christopher Thurn
Program Purpose: To validate the form information a user enters to ensure
it is the correct type of data to be submitted. 

Small Revision Author: Ethan Kohn
Change: Added "isDefault" function for validating pitcher choice
*/
package gui;

/**
 *
 * @author Christopher
 */
public class Validator {
    private String lineEnd;
    
    public Validator() {
        this.lineEnd = "\n";
    }
    public Validator(String lineEnd) {
        this.lineEnd = lineEnd;
    }
    
    public String isPresent(String value, String name) {
        String msg = "";
        if (value.isEmpty()) {
            msg = name + " is required." + lineEnd;
        }
        return msg;
    }
    
    public String isDefault(String value, String name) {
        String msg = "";
        if (value.equals("Select a Pitcher")) {
            msg = name + " is required." + lineEnd;
        }
        return msg;
    }
    
    public String isDouble(String value, String name) {
        String msg = "";
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            msg = name + " must be a valid number." + lineEnd;
        }
        return msg;
    }
    
    public String isInteger(String value, String name) {
        String msg = "";
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            msg = name + " must be an integer." + lineEnd;
        }
        return msg;
    }
}
