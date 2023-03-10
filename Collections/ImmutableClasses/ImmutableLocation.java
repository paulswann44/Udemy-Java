package ImmutableClasses;


import java.util.HashMap;
import java.util.Map;


public final class ImmutableLocation {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

     ImmutableLocation(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>(exits);
        this.exits.put("Q", 0);
    }



    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}

