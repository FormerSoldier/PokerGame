import handle.PorkerGameHandle;
import model.Poker;
import org.junit.Assert;
import org.junit.Test;

public class PorkerGameJudgeTest {

    @Test
    public void test_porker_judge_given_2_and_A_then_return_second_win(){
        Poker first = new Poker('2','H');
        Poker second = new Poker('A','S');

        String message = PorkerGameHandle.porkerJudge(first, second);
        Assert.assertEquals("second win",message);
    }
}
