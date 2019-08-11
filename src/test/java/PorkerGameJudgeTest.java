import handle.PorkerGameHandle;
import model.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PorkerGameJudgeTest {

    @Test
    public void test_porker_judge_given_2_A_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('2','H'));
        List<Poker> second = Arrays.asList(new Poker('A','S'));

        String message = PorkerGameHandle.porkerJudge(first, second);
        Assert.assertEquals("second win",message);
    }

    @Test
    public void test_porker_judge_given_JK_QK_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('K','C'),new Poker('J','S'));
        List<Poker> second = Arrays.asList(new Poker('K','H'),new Poker('Q','S'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win",message);
    }
}
