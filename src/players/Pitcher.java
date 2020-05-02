package players;

/* This class is designed to handle pitcher objects for the purpose of handling
 * data taken from the GUI, entered by the user.
 * Created By: Ethan Kohn
 * Created: April 24, 2020
 
 * Changelog:
 * Revision: April 25, 2020
 * Fixed Data Type of inningsPitched

 * Revision: April 29, 2020
 * Added filename string to pass along to file i/o
*/
public class Pitcher {
    
    // variables needed to track on each pitcher
    // this should be each stat that a user enters on the GUI
    private String playerName;
    private double inningsPitched;
    private int baseHits;
    private int runsScored;
    private int earnedRuns;
    private int walksAllowed;
    private int strikeOuts;
    private int atBats;
    private int battersFaced;
    private int numberPitches;
    private String filename;
    private String gameDate;
    
    // constructor
    public Pitcher(String name, double ip, int hits, int runs, int er, int bb, int so,
            int ab, int bf, int np, String fn, String date){
        this.playerName = name;
        this.inningsPitched = ip;
        this.baseHits = hits;
        this.runsScored = runs;
        this.earnedRuns = er;
        this.walksAllowed = bb;
        this.strikeOuts = so;
        this.atBats = ab;
        this.battersFaced = bf;
        this.numberPitches = np;
        this.filename = fn;
        this.gameDate = date;
    }
    

    // Everything below here is mutators and accessors (get and set)
    
    
    // Player Name
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Innings Pitched (IP)
    public double getInningsPitched() {
        return inningsPitched;
    }

    public void setInningsPitched(int inningsPitched) {
        this.inningsPitched = inningsPitched;
    }

    // Base Hits (H)
    public int getBaseHits() {
        return baseHits;
    }

    public void setBaseHits(int baseHits) {
        this.baseHits = baseHits;
    }

    // Runs Scored (R)
    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }
    
    // Earned Runs (ER)
    public int getEarnedRuns() {
        return earnedRuns;
    }

    public void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    // Walks Allowed (BB)
    public int getWalksAllowed() {
        return walksAllowed;
    }

    public void setWalksAllowed(int walksAllowed) {
        this.walksAllowed = walksAllowed;
    }

    // Strike Outs (SO)
    public int getStrikeOuts() {
        return strikeOuts;
    }

    public void setStrikeOuts(int strikeOuts) {
        this.strikeOuts = strikeOuts;
    }

    // At-Bats (AB)
    public int getAtBats() {
        return atBats;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    // Batters Faced (BF)
    public int getBattersFaced() {
        return battersFaced;
    }

    public void setBattersFaced(int battersFaced) {
        this.battersFaced = battersFaced;
    }

    // Number of Pitches (NP)
    public int getNumberPitches() {
        return numberPitches;
    }

    public void setNumberPitches(int numberPitches) {
        this.numberPitches = numberPitches;
    }
    
    // Name of file to write to
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    // Date of Game
    public String getGameDate() {
        return gameDate;
    }

    public void getGameDate(String game) {
        this.gameDate = game;
    }
}
