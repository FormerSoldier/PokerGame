# 解题思路：

**将每个玩家的手牌转成数组，并且在数组后面增加多个位置，每个位置表示手牌能达到的维度，从尾到头对比数组的元素中的大小。**

```
    //dictionary = "23456789TJQKA"
    List<Poker> player;	//2H,3D,5S,7C,9C
    
    // 七种维度，对子，三张，顺子，同花，三带二，四张，皇家同花顺
    // 前面13个元素为[1,1,0,1,0,1,0,1,0,0,0,0,0,...],表示对应dictionary下角标是否有值
    // 后面七个元素的值则代表达到的维度，0则不满足；若达到了，元素值为达到维度的牌在dictionary的下角标+1，比如对2，则为result[表示对二维度的下角标] = 1
	int[] result = [dictionary.length + 7];
```



## 处理手牌的方法

```
private static int[] getPokersIndex(List<Poker> pokers){
		//使用一个数组来存储传入的List<Poker>中，每个对象所对应字符的下角标。
        int[] result = new int[PorkerTypeIndexConstant.INDEXLENTH];
        // dictionary = "23456789TJQKA"
        for(int i = 0; i < pokers.size(); i++){
            result[dictionary.indexOf(pokers.get(i).getNumber())]++;
        }
        // 下面是处理不同的维度
        dueIndexsIfHasTwoPairOrThreePair(result);
        dueIndexIfHasStraight(result);
        dueIndexIfHasFlush(result,pokers);
        dueIndexIfHasFullHouse(result);
        dueIndexIfHasFourOfAKind(result);
        dueIndexIfHasStrgihtFlush(result);
        return result;
    }
```

针对每一个维度（比如two Pair 和Three Pair就是不同的维度），我就会将数组添加一个位置来表示这个维度。将各种类型抽出到一个接口中。

```
public interface PorkerTypeIndexConstant {
    int INDEXLENTH = 20;		//最终数组的长度，dictionary.length + 各位类型的维度
    int TWOPAIRINDEX = Poker.dictionary.length();
    int THREEPAIRINDEX = TWOPAIRINDEX + 1;
    int STRAIGHTINDEX = THREEPAIRINDEX + 1;
    int FLUSHINDEX = STRAIGHTINDEX + 1;
    int FULLHOUSEINDEX = FLUSHINDEX + 1;
    int FOUROFAKINDINDEX = FULLHOUSEINDEX + 1;
    int STRAIGHTFLUSHINDEX = FOUROFAKINDINDEX + 1;
}

```

**转换成功之后，只需要从后面到前面去对比，取大的就行**

```
public static String porkerJudge(List<Poker> first, List<Poker> second) {
		// 此处进行转换
        int[] firstNumbers = getPokersIndex(first);
        int[] secondNumbers = getPokersIndex(second);
		
        String message = "draw";	//平局
        // 只要有一个元素出现差别，则大的赢
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
```



**PS：**

1. 在我的程序中A2345是顺子，是一个最小的顺子
2. 针对一些例如3带2的情况，为了避免BUG，我会将（3张的下角标+1 ）* 100 + 两张的值，这样就可以避免出现[10,10,10,9,9]会大于[A,A,A,2,2]的情况。
3. 对于以后出现的新类型，我只需要在接口类中修改一下长度，再实现功能，最后调用即可。