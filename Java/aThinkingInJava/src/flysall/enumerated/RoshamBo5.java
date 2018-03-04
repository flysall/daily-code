package flysall.enumerated;

import java.util.*;
import static flysall.enumerated.Outcome.*;

enum RoshamBo5 implements Competitor<RoshamBo5> {
    PAPER, SCISSORS, ROCK;
    static EnumMap<RoshamBo5, EnumMap<RoshamBo5, Outcome>> table =
            new EnumMap<>(RoshamBo5.class);
    static {
        for(RoshamBo5 it : RoshamBo5.values())
            table.put(it, new EnumMap<RoshamBo5, Outcome>(RoshamBo5.class));
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }
    static void initRow(RoshamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoshamBo5, Outcome> row = RoshamBo5.table.get(it);
        row.put(RoshamBo5.PAPER, vPAPER);
        row.put(RoshamBo5.SCISSORS, vSCISSORS);
        row.put(RoshamBo5.ROCK, vROCK);
    }
    public Outcome compete(RoshamBo5 it) {
        return table.get(this).get(it);
    }
    public static void main(String[] args) {
        RoShamBo.play(RoshamBo5.class, 20);
    }
}
