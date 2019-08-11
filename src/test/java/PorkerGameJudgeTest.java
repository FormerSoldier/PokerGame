import handle.PorkerGameHandle;
import model.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PorkerGameJudgeTest {

    @Test
    public void test_porker_judge_given_2_and_A_then_return_second_win(){
        Poker first = new Poker('2','H');
        Poker second = new Poker('A','S');

        String message = PorkerGameHandle.porkerJudge(first, second);
        Assert.assertEquals("second win",message);
    }

    @Test
    public void test_porker_judge_given_JK_QK_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('J','S'),new Poker('K','C'));
        List<Poker> second = Arrays.asList(new Poker('Q','S'),new Poker('K','H'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win",message);
    }
}
