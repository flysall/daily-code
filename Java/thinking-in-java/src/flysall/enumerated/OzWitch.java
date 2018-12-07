package flysall.enumerated;

import static net.mindview.util.Print.*;

public enum OzWitch {
    // Instance must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the west"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, Wearer of the Ruby " +
        "Slippers, crushed by dorothy's house"),
    SOUTH("Good by interence, but missing");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values())
            print(witch + ": " + witch.getDescription());
    }
}
