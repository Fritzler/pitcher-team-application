/* This class is designed to handle any kind of file input or output required
 * by the program and process pitcher objects as needed for this function.
 * Created By: Ethan Kohn
 * Created: April 25, 2020
 
 * Changelog:
 * Revision: April 29, 2020
 * Made OutputToFile() process a date for the filename
 *
 * Revision: May 5, 2020
 * Added code functionality to ImportFile() function
 * Renamed OutputReport() to SummaryReport()
 *
 * Revision: May 6, 2020, Ethan Kohn
 * Made SummaryReport output to a formatted .txt file 
 * Made the formatted .txt empty out after every report print
 *
 * Revision: May 7, 2020, Ethan Kohn
 * Added SummaryReport functionality
*/

package fileIO;

import java.io.*;
import java.nio.file.*;
import players.Pitcher;
import java.text.NumberFormat;
import javafx.scene.control.Alert;

import java.util.List;

public class PitcherFileIO {
    
    public void OutputToFile(Pitcher p){
        // Set the path of the .txt file to the same as the java file
        Path pitcherFilePath = Paths.get(p.getFilename());
        
        // Attempt to prevent a FileNotFoundException
        if (Files.exists(pitcherFilePath)) {
            File pitcherFile = pitcherFilePath.toFile();
            // Attempt to open the file to write
            try {
                PrintWriter out = new PrintWriter(   // Make sure to append to
                                new BufferedWriter(  // the file!
                               new FileWriter(pitcherFile, true)));
                
                // Print everything to a file, with tabs (\t) as a separator
                out.print(p.getPlayerName() + "\t");
                out.print(p.getInningsPitched() + "\t");
                out.print(p.getBaseHits() + "\t");
                out.print(p.getRunsScored() + "\t");
                out.print(p.getEarnedRuns() + "\t");
                out.print(p.getWalksAllowed() + "\t");
                out.print(p.getStrikeOuts() + "\t");
                out.print(p.getAtBats() + "\t");
                out.print(p.getBattersFaced() + "\t");
                out.println(p.getNumberPitches()); // Final entry, no \t,

                // Close the file
                out.close();
            } catch (IOException e) {
                 System.out.println("Error on writing to file: " + e);
            }           
        }
    }
    
    public void SummaryReport(String filename, List<Pitcher> pitchers){
        try {
            BufferedReader in = new BufferedReader(
                            new FileReader(filename));
            try {
                // Read line of pitcher stats
                String line = in.readLine();
                while(line != null) {
                    // Split line into statistics
                    String[] stats = line.split("\t");
                    // Assign those to variables
                    String playerName = stats[0];
                    double inningsPitched = Double.parseDouble(stats[1]);
                    int baseHits = Integer.parseInt(stats[2]);
                    int runsScored = Integer.parseInt(stats[3]);
                    int earnedRuns = Integer.parseInt(stats[4]);
                    int walksAllowed = Integer.parseInt(stats[5]);
                    int strikeOuts = Integer.parseInt(stats[6]);
                    int atBats = Integer.parseInt(stats[7]);
                    int battersFaced = Integer.parseInt(stats[8]);
                    int numberPitches = Integer.parseInt(stats[9]);
                    
                    // Calculate Earned Run Average
                    double ERA = 9 * earnedRuns / inningsPitched;
                    
                    // For every pitcher in the linked list...
                    for (Pitcher pitcher : pitchers) {
                        // If the name of the pitcher object equals the
                        // currently read line in the file...
                        if (pitcher.getPlayerName().equals(playerName)){
                            // Add all the read stats to the object
                            pitcher.addInningsPitched(inningsPitched);
                            pitcher.addBaseHits(baseHits);
                            pitcher.addRunsScored(runsScored);
                            pitcher.addEarnedRuns(earnedRuns);
                            pitcher.addWalksAllowed(walksAllowed);
                            pitcher.addStrikeOuts(strikeOuts);
                            pitcher.addAtBats(atBats);
                            pitcher.addBattersFaced(battersFaced);
                            pitcher.addNumberPitches(numberPitches);
                            pitcher.addERA(ERA);
                        }  
                    }
                    
                    // Do it again until we're out of pitchers
                    line = in.readLine();
                }
                
                // Close the file
                in.close();
                
            } catch (IOException e) {
                System.out.println ("Error:" + e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found." + e);
        }
    }
    
    public void ImportFile(String filename){
        // We need to output this to a file for printing later
        // Create a name for a formatted version of the file
        String formattedFilePathString = "formatted " + filename;
        Path formattedFilePath = Paths.get(formattedFilePathString);
        
        // Attempt to create a formatted .txt file
        try {
            if (Files.notExists(formattedFilePath)) {
                Files.createFile(formattedFilePath);
            }
        } catch (IOException e) {
            System.out.println("Error on creating writeable file: " + e);
        }
        
        // Blank out the formatted file every time we call this function!
        if (Files.exists(formattedFilePath)) {
            File pitcherFileCleaner = formattedFilePath.toFile();
            try {
                PrintWriter clean = new PrintWriter(pitcherFileCleaner);
                clean.close();
            } catch (IOException e) {
                System.out.println("Error on emptying old report file: " 
                                    + e);
            }
        }
        
        // Try to read the file of choice
        try {
            BufferedReader in = new BufferedReader(
                            new FileReader(filename));
            try {
                // Read line of pitcher stats
                String line = in.readLine();
                while(line != null) {
                    // Split line into statistics
                    String[] stats = line.split("\t");
                    // Assign those to variables
                    String playerName = stats[0];
                    double inningsPitched = Double.parseDouble(stats[1]);
                    int baseHits = Integer.parseInt(stats[2]);
                    int runsScored = Integer.parseInt(stats[3]);
                    int earnedRuns = Integer.parseInt(stats[4]);
                    int walksAllowed = Integer.parseInt(stats[5]);
                    int strikeOuts = Integer.parseInt(stats[6]);
                    int atBats = Integer.parseInt(stats[7]);
                    int battersFaced = Integer.parseInt(stats[8]);
                    int numberPitches = Integer.parseInt(stats[9]);
                
                    // Create a new pitcher object from that object
                    // NOTE: Not necessary at this point, may be later.
                    //Pitcher p = new Pitcher(playerName, inningsPitched, baseHits,
                    //            runsScored, earnedRuns, walksAllowed,
                    //            strikeOuts, atBats, battersFaced, numberPitches,
                    //            filename);
                    
                    // Calculate earned run average
                    double ERA = 9 * earnedRuns / inningsPitched;
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(2);
                    String ERAFormatted = nf.format(ERA);
                    
                    // Attempt to prevent a FileNotFoundException
                    if (Files.exists(formattedFilePath)) {
                        File pitcherFileFormatted = formattedFilePath.toFile();
                        // Attempt to open the file to write
                        try {
                            PrintWriter out = new PrintWriter( 
                                            new BufferedWriter( 
                                            new FileWriter(pitcherFileFormatted, true)));
                            // We have to append if we're in the loop
                            // or else only the last line of data will be written
                            
                            // Output to file
                            out.println("Player Name: " + playerName
                            + " | Innings Pitched: " + inningsPitched
                            + " | Base Hits: " + baseHits
                            + " | Runs Scored: " + runsScored
                            + " | Earned Runs: " + earnedRuns
                            + " | Walks Allowed: " + walksAllowed
                            + " | Strike Outs: " + strikeOuts
                            + " | At Bats: " + atBats
                            + " | Batters Faced: " + battersFaced
                            + " | Number of Pitches: " + numberPitches
                            + " | ERA: " + ERAFormatted
                            + "\n");
                            out.close();
                        } catch (IOException e) {
                             System.out.println("Error on writing to file: " 
                                                + e);
                        }
                    }
                    
                    // Output formatted text for the player's stats
                    // *Mainly for confirmation purposes*
                    // This is how it should appear when request to print is
                    // called
                    System.out.println("Output to file: " 
                                    + formattedFilePathString);
                    System.out.println("Player Name: " + playerName
                            + " | Innings Pitched: " + inningsPitched
                            + " | Base Hits: " + baseHits
                            + " | Runs Scored: " + runsScored
                            + " | Earned Runs: " + earnedRuns
                            + " | Walks Allowed: " + walksAllowed
                            + " | Strike Outs: " + strikeOuts
                            + " | At Bats: " + atBats
                            + " | Batters Faced: " + battersFaced
                            + " | Number of Pitches: " + numberPitches
                            + " | ERA: " + ERAFormatted
                            + "\n");
                    
                    // Do it again until we're out of pitchers
                    line = in.readLine();
                }
                
                /*Creating the Alert that displays the Output*/
                    Alert output = new Alert(Alert.AlertType.NONE);
                    output.setAlertType(Alert.AlertType.INFORMATION); 
                    output.setTitle("Pitcher Program - Pitcher Report.");
                    output.setHeaderText("Document Name: " + filename);
                    output.setContentText("The report printed out to the console. You are able to copy and paste this information as you need.\n"
                            + "\n"
                            + " We apologize for any inconvenience and are working on an update to this method of printing.\n"
                            + "\n"
                            + "Please also see the directory as a copy of this file is located there as well.\n"
                            + "\n"
                            + "Thank you for using the Pitcher Program.");
                    output.show();
                
                // Close the file to free resources
                in.close();
            } catch (IOException e) {
                System.out.println ("Error:" + e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found." + e);
        }
    }
}
