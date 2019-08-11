package handle;

import model.Poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PorkerGameHandle {
    private static String dictionary = Poker.dictionary;
    private static final int INDEXLENTH = 15;
    private static final int TWOPAIRINDEX = dictionary.length();
    private static final int THREEPAIRINDEX = dictionary.length()+1;

    public static String porkerJudge(List<Poker> first, List<Poker> second) {
        int[] firstNumbers = getPokersIndex(first);
        int[] secondNumbers = getPokersIndex(second);

        String message = "draw";
        for(int i = firstNumbers.length - 1; i >= 0; i--){
            if(firstNumbers[i] > secondNumbers[i]){
                message = String.format("first win, his pokers are %s", first);
                break;
            }else if(firstNumbers[i] < secondNumbers[i]){
                message = String.format("second win, his pokers are %s", second);
                break;
            }
        }
        return message;
    }

    private static int[] getPokersIndex(List<Poker> pokers){
        int[] result = new int[INDEXLENTH];
        for(int i = 0; i < pokers.size(); i++){
            result[dictionary.indexOf(pokers.get(i).getNumber())]++;
        }
        dueIndexsIfHasTwoPair(result);
        return result;
    }

    private static int[] dueIndexsIfHasTwoPair(int[] indexs){
        for(int i = 0; i < dictionary.length(); i++){
            if(indexs[i] == 2){
                indexs[TWOPAIRINDEX] += (i+1) ;
                indexs[i] = 0;
            }else if(indexs[i] == 3){
                indexs[THREEPAIRINDEX] += (i+1);
                indexs[i] = 0;
            }
        }
        return indexs;
    }
}
