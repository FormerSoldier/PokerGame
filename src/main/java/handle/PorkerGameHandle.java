package handle;

import model.Poker;

import java.util.Collections;
import java.util.List;

public class PorkerGameHandle {

    public static String porkerJudge(List<Poker> first, List<Poker> second) {
        Collections.sort(first);
        Collections.sort(second);

        String message = "draw";
        for(int i = first.size() - 1; i >= 0; i--){
            if(first.get(i).getNumber() > second.get(i).getNumber()){
                message = "first win";
                break;
            }else if(first.get(i).getNumber() < second.get(i).getNumber()){
                message = "second win";
                break;
            }
        }
        return message;
    }
}
