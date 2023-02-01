package Adventure;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits= new HashMap<String,Integer>();
        //This prevents redundant code being ran, instead of having locations.get(1).addExit("Q", 0);" everywhere

        this.exits.put("Q",0);

    }
    //we want to add the ability to add an exit
    public void addExit(String direction, int location){
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    //hashmap of exit simply exits in the constructor
    //The reasons that we're doing that is that instead of just returning the exits map
    //I am creating a new hashmap and passing out exits in the constructor.
    //A new map is created, and it has all the mappings from the exit map.
    //useful tek doing that here is that nothing outside of our class can change exits
    //getter returns a copy of exits so that is the calling program wants to + or - mapping from it the the exits mapping field won't be affected

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
