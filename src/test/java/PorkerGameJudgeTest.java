import handle.PorkerGameHandle;
import model.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PorkerGameJudgeTest {

    @Test
    public void test_porker_judge_given_2H_and_AS_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'));
        List<Poker> second = Arrays.asList(new Poker('A','S'));

        String message = PorkerGameHandle.porkerJudge(first, second);
        Assert.assertEquals("second win, his pokers are [AS]",message);
    }

    @Test
    public void test_porker_judge_given_JS_KC_and_QS_KH_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('K','C'),new Poker('J','S'));
        List<Poker> second = Arrays.asList(new Poker('K','H'),new Poker('Q','S'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [KH, QS]",message);
    }

    @Test
    public void test_porker_judge_given_2H_3D_5S_9C_KD_and_2D_3H_5C_9S_QD_then_return_first_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'),
                new Poker('3','D'),
                new Poker('5','S'),
                new Poker('9','C'),
                new Poker('K','D'));
        List<Poker> second = Arrays.asList(new Poker('2','D'),
                new Poker('3','H'),
                new Poker('5','C'),
                new Poker('6','S'),
                new Poker('Q','D'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("first win, his pokers are [2H, 3D, 5S, 9C, KD]",message);
    }

    @Test
    public void test_porker_judge_given_2H_3D_5S_9C_KD_and_2D_2S_5C_9S_TD_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'),
                new Poker('3','D'),
                new Poker('5','S'),
                new Poker('9','C'),
                new Poker('K','D'));
        List<Poker> second = Arrays.asList(new Poker('2','D'),
                new Poker('2','S'),
                new Poker('5','C'),
                new Poker('9','S'),
                new Poker('T','D'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [2D, 2S, 5C, 9S, TD]",message);
    }

    @Test
    public void test_porker_judge_given_2H_3D_5S_KC_KD_and_2D_3S_5C_AS_AD_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'),
                new Poker('3','D'),
                new Poker('5','S'),
                new Poker('K','C'),
                new Poker('K','D'));
        List<Poker> second = Arrays.asList(new Poker('2','D'),
                new Poker('3','S'),
                new Poker('5','C'),
                new Poker('A','S'),
                new Poker('A','D'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [2D, 3S, 5C, AS, AD]",message);
    }

    @Test
    public void test_porker_judge_given_2H_3D_5S_KC_KD_and_2D_3S_6H_KS_KH_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'),
                new Poker('3','D'),
                new Poker('5','S'),
                new Poker('K','C'),
                new Poker('K','D'));
        List<Poker> second = Arrays.asList(new Poker('2','D'),
                new Poker('3','S'),
                new Poker('6','H'),
                new Poker('K','S'),
                new Poker('K','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [2D, 3S, 6H, KS, KH]",message);
    }

    @Test
    public void test_porker_judge_given_2H_3D_KS_KC_KD_and_2D_3S_AC_AS_AH_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'),
                new Poker('3','D'),
                new Poker('K','S'),
                new Poker('K','C'),
                new Poker('K','D'));
        List<Poker> second = Arrays.asList(new Poker('2','D'),
                new Poker('3','S'),
                new Poker('A','C'),
                new Poker('A','S'),
                new Poker('A','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [2D, 3S, AC, AS, AH]",message);
    }

    @Test
    public void test_porker_judge_given_3H_4D_5S_6C_7D_and_2D_3S_AC_AS_AH_then_return_first_win(){
        List<Poker> first = Arrays.asList(new Poker('3','H'),
                new Poker('4','D'),
                new Poker('5','S'),
                new Poker('6','C'),
                new Poker('7','D'));
        List<Poker> second = Arrays.asList(new Poker('2','D'),
                new Poker('3','S'),
                new Poker('A','C'),
                new Poker('A','S'),
                new Poker('A','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("first win, his pokers are [3H, 4D, 5S, 6C, 7D]",message);
    }

    @Test
    public void test_porker_judge_given_3H_4D_5S_6C_7D_and_AD_2S_3C_4S_5H_then_return_first_win(){
        List<Poker> first = Arrays.asList(new Poker('3','H'),
                new Poker('4','D'),
                new Poker('5','S'),
                new Poker('6','C'),
                new Poker('7','D'));
        List<Poker> second = Arrays.asList(new Poker('A','D'),
                new Poker('2','S'),
                new Poker('3','C'),
                new Poker('4','H'),
                new Poker('5','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("first win, his pokers are [3H, 4D, 5S, 6C, 7D]",message);
    }

    @Test
    public void test_porker_judge_given_3C_4D_5S_6C_7D_and_2h_3H_5H_9H_KH_then_return_first_win(){
        List<Poker> first = Arrays.asList(new Poker('3','C'),
                new Poker('4','D'),
                new Poker('5','S'),
                new Poker('6','C'),
                new Poker('7','D'));
        List<Poker> second = Arrays.asList(new Poker('2','H'),
                new Poker('3','H'),
                new Poker('5','H'),
                new Poker('9','H'),
                new Poker('K','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [2H, 3H, 5H, 9H, KH]",message);
    }

    @Test
    public void test_porker_judge_given_4H_4D_5S_5C_5D_and_2h_3H_5H_9H_KH_then_return_first_win(){
        List<Poker> first = Arrays.asList(new Poker('4','H'),
                new Poker('4','D'),
                new Poker('5','S'),
                new Poker('5','C'),
                new Poker('5','D'));
        List<Poker> second = Arrays.asList(new Poker('2','H'),
                new Poker('3','H'),
                new Poker('5','H'),
                new Poker('9','H'),
                new Poker('K','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("first win, his pokers are [4H, 4D, 5S, 5C, 5D]",message);
    }

    @Test
    public void test_porker_judge_given_4H_4D_5S_5C_5D_and_3H_3C_3D_3S_KH_then_return_first_win(){
        List<Poker> first = Arrays.asList(new Poker('4','H'),
                new Poker('4','D'),
                new Poker('5','S'),
                new Poker('5','C'),
                new Poker('5','D'));
        List<Poker> second = Arrays.asList(new Poker('3','H'),
                new Poker('3','C'),
                new Poker('3','D'),
                new Poker('3','S'),
                new Poker('K','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win, his pokers are [3H, 3C, 3D, 3S, KH]",message);
    }

}
