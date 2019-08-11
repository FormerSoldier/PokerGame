package handle;

import model.Poker;
import model.PorkerTypeIndexConstant;

import java.util.List;

public class PorkerGameHandle {
    private static String dictionary = Poker.dictionary;
    private static int PokerHandeCount = 5;
    private static int times = 100;

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
        dueIndexIfHasFlush(result,pokers);
        dueIndexIfHasFullHouse(result);
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

    private static boolean hasFlush(List<Poker> pokers){
        char suit = pokers.get(0).getSuit();
        int count = 0;
        for(Poker poker : pokers){
            if(poker.getSuit() == suit)
                count ++;
        }
        return count == pokers.size();
    }
    private static int[] dueIndexIfHasFlush(int[] indexs, List<Poker> pokers){
        if(hasFlush(pokers))
            indexs[PorkerTypeIndexConstant.FLUSHINDEX] = 1;
        return indexs;
    }

    private static int[] dueIndexIfHasFullHouse(int[] indexs){
        if(indexs[PorkerTypeIndexConstant.THREEPAIRINDEX] == 0 || indexs[PorkerTypeIndexConstant.TWOPAIRINDEX] == 0)
            return indexs;
        indexs[PorkerTypeIndexConstant.FULLHOUSEINDEX] = indexs[PorkerTypeIndexConstant.THREEPAIRINDEX] * times + indexs[PorkerTypeIndexConstant.TWOPAIRINDEX];
        return indexs;
    }
}
