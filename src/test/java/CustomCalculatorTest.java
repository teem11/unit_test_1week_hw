
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator; //원본 클래스를 생성하는 것.

    @Test
    public void 더하기_테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(3323,2882);
        assertThat(result, is(6205));
        System.out.println("result :: " + result);
    }

    @Test
    public void 빼기_테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        assertThat(result, is(13));
        System.out.println("result :: " + result);
    }

    @Test
    public void 곱하기_테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        assertThat(result, is(45));
        System.out.println("result :: " + result);
    }

    @Test
    public void 나누기_테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, is(5));
        System.out.println("result :: " + result);
    }
    @Test(expected = ArithmeticException.class)
    public void 영으로_나누었을때_오류_테스트(){
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,0);
    }
}