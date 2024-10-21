import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "Anda berada " + description + ".\n" + getExitString();
    }

    String getExitString() {
        StringBuilder returnString = new StringBuilder("Pintu keluar:");
        for (String key : exits.keySet()) {
            returnString.append(" ").append(key);
        }
        return returnString.toString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}