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
        Assert.assertEquals("second win",message);
    }

    @Test
    public void test_porker_judge_given_JS_KC_and_QS_KH_then_return_second_win(){
        List<Poker> first = Arrays.asList(new Poker('K','C'),new Poker('J','S'));
        List<Poker> second = Arrays.asList(new Poker('K','H'),new Poker('Q','S'));

        String message = PorkerGameHandle.porkerJudge(first,second);
        Assert.assertEquals("second win",message);
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
        Assert.assertEquals("first win",message);

    }
}
