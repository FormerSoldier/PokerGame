package handle;

import model.Poker;
import model.PorkerTypeIndexConstant;

import java.util.List;

public class PorkerGameHandle {
    private static String dictionary = Poker.dictionary;
    private static int PokerHandeCount = 5;

    public static String porkerJudge(List<Poker> first, List<Poker> second) {
        int[] firstNumbers = getPokersIndex(first);
        int[] secondNumbers = getPokersIndex(second);

        String message = "draw";
        for(int i = PorkerTypeIndexConstant.INDEXLENTH - 1; i >= 0; i--){
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
        int[] result = new int[PorkerTypeIndexConstant.INDEXLENTH];
        for(int i = 0; i < pokers.size(); i++){
            result[dictionary.indexOf(pokers.get(i).getNumber())]++;
        }
        dueIndexsIfHasTwoPairOrThreePair(result);
        dueIndexIfHasStraight(result);
        return result;
    }

    private static int[] dueIndexsIfHasTwoPairOrThreePair(int[] indexs){
        for(int i = 0; i < dictionary.length(); i++){
            if(indexs[i] == 2){
                indexs[PorkerTypeIndexConstant.TWOPAIRINDEX] += (i*100+1) ;
                indexs[i] = 0;
            }else if(indexs[i] == 3){
                indexs[PorkerTypeIndexConstant.THREEPAIRINDEX] += (i+1);
                indexs[i] = 0;
            }
        }
        return indexs;
    }

    private static boolean hasStraight(int[] indexs){
        int count = indexs[0] + indexs[1] + indexs[2] +indexs[3] + indexs[12] ;
        if(count == 5) {
            return true;
        }
        count = 0;

        for(int i = 0; i < dictionary.length(); i++){
            if(count == 5)
                break;

            if(indexs[i] == 1){
                count ++;
            }else{
                count = count <= 0 ? 0 : count-1;
            }
        }
        return count == PokerHandeCount;
    }
    private static int[] dueIndexIfHasStraight(int[] indexs){
        if(!hasStraight(indexs))
            return indexs;
        for(int i = dictionary.length() - 1; i >= 0; i--){
            if(indexs[i] == 1){
                indexs[PorkerTypeIndexConstant.STRAIGHTINDEX] = (i + 1) % dictionary.length();
                break;
            }
        }
        return indexs;
    }
}
