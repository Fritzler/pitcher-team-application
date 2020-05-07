package players;

/* This class is designed to handle pitcher objects for the purpose of handling
 * data taken from the GUI, entered by the user.
 * Created By: Ethan Kohn
 * Created: April 24, 2020
 
 * Changelog:
 * Revision: April 25, 2020
 * Fixed Data Type of inningsPitched

 * Revision: May 7, 2020
 * Added new constructor, "add" functions for game summaries, ERA tracking
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
    private double ERA;
    private String filename;
    
    // constructor
    public Pitcher(String name, double ip, int hits, int runs, int er, int bb, int so,
            int ab, int bf, int np, String fn){
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
    }
    
    // Constructor for the sake of summaries, initalize everything at 0
    public Pitcher(String name){
        this.playerName = name;
        this.inningsPitched = 0.0;
        this.baseHits = 0;
        this.runsScored = 0;
        this.earnedRuns = 0;
        this.walksAllowed = 0;
        this.strikeOuts = 0;
        this.atBats = 0;
        this.battersFaced = 0;
        this.numberPitches = 0;
        this.ERA = 0;
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

    public void setInningsPitched(double inningsPitched) {
        this.inningsPitched = inningsPitched;
    }
    
    public void addInningsPitched(double inningsPitched) {
        this.inningsPitched += inningsPitched;
    }

    // Base Hits (H)
    public int getBaseHits() {
        return baseHits;
    }

    public void setBaseHits(int baseHits) {
        this.baseHits = baseHits;
    }
    
    public void addBaseHits(int baseHits) {
        this.baseHits += baseHits;
    }

    // Runs Scored (R)
    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }
    
    public void addRunsScored(int runsScored) {
        this.runsScored += runsScored;
    }
    
    // Earned Runs (ER)
    public int getEarnedRuns() {
        return earnedRuns;
    }

    public void setEarnedRuns(int earnedRuns) {
        this.earnedRuns = earnedRuns;
    }

    public void addEarnedRuns(int earnedRuns) {
        this.earnedRuns += earnedRuns;
    }
    
    // Walks Allowed (BB)
    public int getWalksAllowed() {
        return walksAllowed;
    }

    public void setWalksAllowed(int walksAllowed) {
        this.walksAllowed = walksAllowed;
    }

    public void addWalksAllowed(int walksAllowed) {
        this.walksAllowed += walksAllowed;
    }
    
    // Strike Outs (SO)
    public int getStrikeOuts() {
        return strikeOuts;
    }

    public void setStrikeOuts(int strikeOuts) {
        this.strikeOuts = strikeOuts;
    }
    
    public void addStrikeOuts(int strikeOuts) {
        this.strikeOuts += strikeOuts;
    }

    // At-Bats (AB)
    public int getAtBats() {
        return atBats;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }
    
    public void addAtBats(int atBats) {
        this.atBats += atBats;
    }

    // Batters Faced (BF)
    public int getBattersFaced() {
        return battersFaced;
    }

    public void setBattersFaced(int battersFaced) {
        this.battersFaced = battersFaced;
    }
    
    public void addBattersFaced(int battersFaced) {
        this.battersFaced += battersFaced;
    }

    // Number of Pitches (NP)
    public int getNumberPitches() {
        return numberPitches;
    }

    public void setNumberPitches(int numberPitches) {
        this.numberPitches = numberPitches;
    }
    
    public void addNumberPitches(int numberPitches) {
        this.numberPitches += numberPitches;
    }
    
    // Earned Run Average (only used in summary report)
    public double getERA() {
        return ERA;
    }
    
    public void addERA(double ERA){
        this.ERA += ERA;
    }
    
    // Name of file to write to
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
}
