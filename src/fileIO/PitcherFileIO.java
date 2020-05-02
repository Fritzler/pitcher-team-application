/* This class is designed to handle any kind of file input or output required
 * by the program and process pitcher objects as needed for this function.
 * Created By: Ethan Kohn
 * Created: April 25, 2020
 
 * Changelog:
 * Revision: April 29, 2020
 * Made OutputToFile() process a date for the filename
*/

package fileIO;

import java.io.*;
import java.nio.file.*;
import players.Pitcher;

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
    
    public void OutputReport(){
        // TODO: function logic
    }
    
    public void ImportFile(){
        // TODO: function logic
    }
    
}
