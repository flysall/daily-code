package flysall.enumerated;

import static flysall.enumerated.Outcome.*;

enum RoshamBo6 implements Competitor<RoshamBo6> {
    PAPER, SCISSORS, ROCK;
    private static Outcome[][] table = {
            {DRAW, LOSE, WIN},
            {WIN, DRAW, LOSE},
            {LOSE, WIN, DRAW},
    };
    public Outcome compete(RoshamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }
    public static void main(String[] args) {
        RoShamBo.play(RoshamBo6.class, 20);
    }
}
