/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballguifx;


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

/**
 *
 * @author Christopher
 */
public class BaseballGUIFX extends Application {
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
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Baseball Pitcher Stats - Entry Form");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        String game_dates[] = { "Feb 14, 2020", "Feb 15, 2020", "Feb 16, 2020", "Feb 22, 2020" } ;
        
        Scene scene = new Scene(grid, 700, 500);
        
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
        
        /* ISSUE WITH THE COMBO BOX
        grid.add(new Label("Game Date:"), 0, 10);
        ComboBox gameDatesCombo = new ComboBox(FXCollections.observableArrayList(game_dates));
        grid.add(gameDatesCombo, 1, 10);
        grid.add(dateofGameLabel, 2, 10);
        */
        
        Button insertButton = new Button("Insert Information");
        insertButton.setOnAction(event -> insertButtonClicked());
        
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> exitButtonClicked());
        
        HBox buttonBox = new HBox(20);
        buttonBox.getChildren().add(insertButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 12, 2, 1);
                
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void insertButtonClicked() {
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
    }
    
    private void exitButtonClicked() {
        System.exit(0);   // 0 indicates a normal exit
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
