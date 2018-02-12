package flysall.enumerated;

import java.util.*;
import static flysall.enumerated.AlarmPoints.*;
import static net.mindview.util.Print.*;

interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            public void action() {
                print("Kitchen fire!");
            }
        });
        em.put(BATHROOM, new Command() {
            public void action() {
                print("Bathroom alert");
            }
        });
        for(Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }
        try {
            em.get(UTILITY).action();
        } catch(Exception e) {
            print(e);
        }
    }
}
