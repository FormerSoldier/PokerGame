package handle;

import model.Poker;

public class PorkerGameHandle {

    public static String porkerJudge(Poker first, Poker second) {
        return first.getNumber() > second.getNumber() ? "first win" : first.getNumber() == second.getNumber() ? "draw" : "second win";
    }
}
