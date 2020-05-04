/*
Date Created: 4/23/2020

Version: Updated Version 1.4
Date Updated: 4/24/2020

Class: CSD 2522 - Java Programming II
Professor: Al Tokarsky

Program Page Author: Christopher Thurn
Program Purpose: To display the form and allow user entry of Baseball Pitcher
Stats.

Revision by: Ethan Kohn, 4/25/2020
Changes: Added file output, see comments in insertButtonClicked() function
         NOT A FINAL REVISION, READ COMMENTS

Revision by: Ethan Kohn, 4/27/2020
Changes: Moved file output to a separate function in fileIO package

Revision by: Ethan Kohn, 4/29/2020
Changes: Updated file output naming scheme to identify by the date of game

Revision by: Christopher Thurn, 05/04/2020
Changes: Addition of Print Report Button and Help Button; 
            Help Button has instructions to help user properly use the program.

Revision by: Ethan Kohn, 05/04/2020
Changes: Implementation of "print report" button
*/
package gui;


import players.Pitcher;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.*;
import players.Pitcher;
import fileIO.PitcherFileIO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Christopher
 */
public class BaseballPitcherGUIFX extends Application {
    private TextField playerNameField;
    private TextField inningsPitchedField;
    private TextField baseHitsField;
    private TextField runsScoredField;
    private TextField earnedRunField;
    private TextField walksAllowedField;
    private TextField strikeOutField;
    private TextField atBatsField;
    private TextField battersFacedField;
    private TextField numberOfPitchesField;
    
    private ComboBox gameDatesCombo;
    
    private Label playerNameLabel;
    private Label inningsPitchedLabel;
    private Label baseHitsLabel;
    private Label runsScoredLabel;
    private Label earnedRunLabel;
    private Label walksAllowedLabel;
    private Label strikeOutLabel;
    private Label atBatsLabel;
    private Label battersFacedLabel;
    private Label numberOfPitchesLable;
    private Label dateofGameLabel;
    
    // I/O object for any kind of input or output required
    // see fileIO.PitcherFileIO for details
    PitcherFileIO io = new PitcherFileIO();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Baseball Pitcher Stats - Entry Form");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
                
        Scene scene = new Scene(grid, 460, 500);
        
        grid.add(new Label("Player Name:"), 0, 0);
        playerNameField = new TextField();
        grid.add(playerNameField, 1, 0);
        playerNameLabel = new Label();
        grid.add(playerNameLabel, 2, 0);
        
        grid.add(new Label("Innings Pitched(IP):"), 0, 1);
        inningsPitchedField = new TextField();
        grid.add(inningsPitchedField, 1, 1);
        inningsPitchedLabel = new Label();
        grid.add(inningsPitchedLabel, 2, 1);
        
        grid.add(new Label("Base Hits(H):"), 0, 2);
        baseHitsField = new TextField();
        grid.add(baseHitsField, 1, 2);
        baseHitsLabel = new Label();
        grid.add(baseHitsLabel, 2, 2);
        
        grid.add(new Label("Runs Scored(R):"), 0, 3);
        runsScoredField = new TextField();
        grid.add(runsScoredField, 1, 3);
        runsScoredLabel = new Label();
        grid.add(runsScoredLabel, 2, 3);
        
        grid.add(new Label("Earned Runs(ER):"), 0, 4);
        earnedRunField = new TextField();
        grid.add(earnedRunField, 1, 4);
        earnedRunLabel = new Label();
        grid.add(earnedRunLabel, 2, 4);
        
        grid.add(new Label("Walks Allowed(BB):"), 0, 5);
        walksAllowedField = new TextField();
        grid.add(walksAllowedField, 1, 5);
        walksAllowedLabel = new Label();
        grid.add(walksAllowedLabel, 2, 5);
        
        grid.add(new Label("Strike Out(SO):"), 0, 6);
        strikeOutField = new TextField();
        grid.add(strikeOutField, 1, 6);
        strikeOutLabel = new Label();
        grid.add(strikeOutLabel, 2, 6);
        
        grid.add(new Label("At-Bats(AB):"), 0, 7);
        atBatsField = new TextField();
        grid.add(atBatsField, 1, 7);
        atBatsLabel = new Label();
        grid.add(atBatsLabel, 2, 7);
        
        grid.add(new Label("Batters Faced(BF):"), 0, 8);
        battersFacedField = new TextField();
        grid.add(battersFacedField, 1, 8);
        battersFacedLabel = new Label();
        grid.add(battersFacedLabel, 2, 8);

        grid.add(new Label("Number of Pitches(NP):"), 0, 9);
        numberOfPitchesField = new TextField();
        grid.add(numberOfPitchesField, 1, 9);
        numberOfPitchesLable = new Label();
        grid.add(numberOfPitchesLable, 2, 9);
        
        
        
        /* Combo Box Section Start */
        grid.add(new Label("Game Date:"), 0, 10);
        gameDatesCombo = new ComboBox();
        gameDatesCombo.getItems().addAll("Feb 14, 2020", 
                "Feb 15, 2020", 
                "Feb 16, 2020", 
                "Feb 22, 2020", 
                "Mar 11, 2020");
        gameDatesCombo.getSelectionModel().select(0);
        dateofGameLabel = new Label();
        grid.add(dateofGameLabel, 2, 10);
        
        HBox comboBox = new HBox(10);
        comboBox.getChildren().add(gameDatesCombo);
        comboBox.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(comboBox, 1, 10, 1, 1);
        /* Combo Box Section End */
        
        
        Button insertButton = new Button("Insert Information");
        insertButton.setOnAction(event -> insertButtonClicked());
        
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> exitButtonClicked());
        
        Button printReportButton = new Button("Print Report");
        printReportButton.setOnAction(event -> printReportButtonClicked());
        
        Button helpReportButton = new Button("Help");
        helpReportButton.setOnAction(event -> helpReportButtonClicked());
        
        HBox buttonBox = new HBox(20);
        buttonBox.getChildren().add(printReportButton);
        buttonBox.getChildren().add(insertButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.getChildren().add(helpReportButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 12, 2, 1);
                
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /* Insert Button Code Start */
    private void insertButtonClicked() {
        //Validates the information presnt in the form to ensure it is proper.
        Validator v = new Validator();
        playerNameLabel.setText(v.isPresent(playerNameField.getText(), "Player Name") );        
        inningsPitchedLabel.setText(v.isDouble(inningsPitchedField.getText(), "Innings Pitched") );        
        baseHitsLabel.setText(v.isInteger(baseHitsField.getText(), "Base Hits") );
        runsScoredLabel.setText(v.isInteger(runsScoredField.getText(), "Runs Scored") );
        earnedRunLabel.setText(v.isInteger(earnedRunField.getText(), "Earned Runs") );
        walksAllowedLabel.setText(v.isInteger(walksAllowedField.getText(), "Walks Allowed") );
        strikeOutLabel.setText(v.isInteger(strikeOutField.getText(), "Strike Outs") );
        atBatsLabel.setText(v.isInteger(atBatsField.getText(), "At-Bats") );
        battersFacedLabel.setText(v.isInteger(battersFacedField.getText(), "Batters Faced") );
        numberOfPitchesLable.setText(v.isInteger(numberOfPitchesField.getText(), "Number of Pitches") );   
        dateofGameLabel.setText(gameDatesCombo.getValue() + "");
        
        // Only run the following if everything passes validation
        if (playerNameLabel.getText().isEmpty() && 
            inningsPitchedLabel.getText().isEmpty() && 
            baseHitsLabel.getText().isEmpty() &&
            runsScoredLabel.getText().isEmpty() && 
            earnedRunLabel.getText().isEmpty() && 
            walksAllowedLabel.getText().isEmpty() && 
            strikeOutLabel.getText().isEmpty() && 
            atBatsLabel.getText().isEmpty() && 
            battersFacedLabel.getText().isEmpty() && 
            numberOfPitchesLable.getText().isEmpty() ) {
            
            String date = String.valueOf(gameDatesCombo.getValue());
            String filename = "";
            
            switch (date) {
                case "Feb 14, 2020":
                    filename = "02-14-2020.txt";
                    break;
                case "Feb 15, 2020":
                    filename = "02-15-2020.txt";
                    break;
                case "Feb 16, 2020":
                    filename = "02-16-2020.txt";
                    break;
                case "Feb 22, 2020":
                    filename = "02-22-2020.txt";
                    break;
                case "Mar 11, 2020":
                    filename = "03-11-2020.txt";
                    break;
            }
        
            // Convert everything to variables of the proper type
            // This is to make the creation of the pitcher object easier to read
            String playerName = playerNameField.getText();
            double inningsPitched = Double.parseDouble(inningsPitchedField.getText());
            int baseHits = Integer.parseInt(baseHitsField.getText());
            int runsScored = Integer.parseInt(runsScoredField.getText());
            int earnedRuns = Integer.parseInt(earnedRunField.getText());
            int walksAllowed = Integer.parseInt(walksAllowedField.getText());
            int strikeOuts = Integer.parseInt(strikeOutField.getText());
            int atBats = Integer.parseInt(atBatsField.getText());
            int battersFaced = Integer.parseInt(battersFacedField.getText());
            int numPitches = Integer.parseInt(numberOfPitchesField.getText());
        
            /* THIS IS THE ORDER OF THE VARIABLES FROM Pitcher.java
            * ============================
            * String playerName
            * double inningsPitched
            * int baseHits
            * int runsScored
            * int earnedRuns
            * int walksAllowed
            * int strikeOuts
            * int atBats
            * int battersFaced
            * int numberPitches
            * ============================
            */
            // Additionally, filename must be passed to make sure we we're
            // writing to the correct file.
            
            
            // Make an object out of the items entered by the user
            // Send this to PitcherFileIO methods to do stuff with it
             Pitcher p = new Pitcher(playerName, inningsPitched, baseHits,
                                runsScored, earnedRuns, walksAllowed,
                                strikeOuts, atBats, battersFaced, numPitches,
                                filename);
        
        
            // Output the data to the file
            io.OutputToFile(p);
        

            // Remove reference to the objects when we're done with them
            p = null;
            
            System.out.println("File Entry Added");

        }
    }
    /* Insert Button Code End */
    
    /* Print Report Button Code Start */
    private void printReportButtonClicked() {

        String date = String.valueOf(gameDatesCombo.getValue());
            String filename = "";
            
            switch (date) {
                case "Feb 14, 2020":
                    filename = "02-14-2020.txt";
                    break;
                case "Feb 15, 2020":
                    filename = "02-15-2020.txt";
                    break;
                case "Feb 16, 2020":
                    filename = "02-16-2020.txt";
                    break;
                case "Feb 22, 2020":
                    filename = "02-22-2020.txt";
                    break;
                case "Mar 11, 2020":
                    filename = "03-11-2020.txt";
                    break;
            }
            
            io.ImportFile(filename);
    }
    /* Print Report Button Code End */
    
    /* Help Menu Code Start */
    Alert help = new Alert(AlertType.NONE); 
    private void helpReportButtonClicked() {
                help.setAlertType(AlertType.INFORMATION); 
                
                help.setTitle("Pitcher Program - Help Menu");
                
                help.setHeaderText("How to use Pitcher Program");
  
                // set content text 
                help.setContentText("Enter the statistics into the form to add a pitcher to the form.\n"
                        + "\n"
                        + "Press insert information to add the information to the document.\n"
                        + "\n"
                        + "Press Print Report to print the report of that given day to display information on all pitchers entered.\n"
                        + "\n"
                        + "Press Exit to end the program.");
  
                // show the dialog 
                help.show();
    }
    /* Help Menu Code End */
    
    
    /* Exit Button Code Start */
    private void exitButtonClicked() {
        System.exit(0);   // 0 indicates a normal exit
    }
    /* Exit Button Code End */

    
    /* Main Method Start */
    public static void main(String[] args) {
         // Attempt to create a pitchers.txt file if one does not already exist
        try {
            String fileString = "02-14-2020.txt";
            Path filePath = Paths.get(fileString);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Error on creating writeable file: " + e);
        }
        
        try {
            String fileString = "02-15-2020.txt";
            Path filePath = Paths.get(fileString);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Error on creating writeable file: " + e);
        }
        
        try {
            String fileString = "02-16-2020.txt";
            Path filePath = Paths.get(fileString);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Error on creating writeable file: " + e);
        }
        
        try {
            String fileString = "02-22-2020.txt";
            Path filePath = Paths.get(fileString);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Error on creating writeable file: " + e);
        }
        
        try {
            String fileString = "03-11-2020.txt";
            Path filePath = Paths.get(fileString);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.out.println("Error on creating writeable file: " + e);
        }
        
        // Launch the GUI
        launch(args);
        
    }
    /* Main Method End */
    
}
