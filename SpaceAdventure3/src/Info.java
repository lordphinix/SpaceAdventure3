
// Class for keeping track of players game info such as health and location
public class Info {
    private String name;
    private String shipName;
    private int health;
    private String location;
    private int missionsDone;
    //Add a thing to keep track of max Health later
    //Array for which missions actually done?
    public final int MAX_MISSIONS = 0;
    

    public Info (String inName, String inShipName){ // The new game info constructor 
        name = inName;
        shipName = inShipName;
        health = 12;
        setLocation("Space");
        missionsDone = 0;         
    }

    public Info(String inName, String inShipName, int inHealth, String inLocation, int inMissions){// the loaded game info constructor
        name = inName;
        shipName = inShipName;
        health = inHealth;
        location = inLocation;
        missionsDone = inMissions;
    }

    //Getter for health value
    public int getHealth(){
        return health;
    }

    //Getter for player name
    public String getName(){
        return name;
    }

    //Getter for location
    public String getLocation(){
        return location;
    }

    //Getter for ship name
    public String getShipName(){
        return shipName;
    }

    //Getter for number of missions done but not which ones
    public int getMissions(){
        return missionsDone;
    }

    //Changes health values either positively or negatively.
    public void changeHealth(int change){
        health += change;
    }

    //Sets the ship to full health, whatever we decide that to be. (UNFINISHED)
    public void fullHeal(){
        //Set health to the max health
    }

    // Updates the location value
    public void setLocation(String newLoc){
        location = newLoc;
    }

    //Adds one to the completed mission counter (For use when a mission completed)
    public void missionNumChange(){
        missionsDone++;
    }
    
}
