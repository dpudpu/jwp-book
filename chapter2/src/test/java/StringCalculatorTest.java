import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import practice.my.StringCalculator;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @Before
    public void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문(){
        assertEquals(0,stringCalculator.getSum(null));
        assertEquals(0,stringCalculator.getSum(""));
    }

    @Test
    public void 숫자하나(){
        assertEquals(1,stringCalculator.getSum("1"));
    }

    @Test
    public void 컴마_테스트(){
        int result = stringCalculator.getSum("1,2,3");

        assertEquals(6,result);
    }

    @Test
    public void 컴마_콜론_테스트(){
        int result = stringCalculator.getSum("1,2:3");

        assertEquals(6,result);
    }

    @Test
    public void 추가구분자_테스트(){
        int result = stringCalculator.getSum("//;\n1;2;3");

        assertEquals(6,result);
    }

    @Test(expected = RuntimeException.class)
    public void 음수있으면에러_테스트(){
        int result = stringCalculator.getSum("//;\n1;2:-3");
    }
}
