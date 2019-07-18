import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    @Test
    public void 더하기_테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(-35,15);
        assertThat(result, is(-20));
        System.out.println("result :: " + result);
    }

    @Test
    public void 빼기_테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(-10,-10);
        assertThat(result, is(0));
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
        int result = customCalculator.divide(-25,5);
        assertThat(result, is(-5));
        System.out.println("result :: " + result);
    }
    @Test(expected = ArithmeticException.class)
    public void 영으로_나누었을때_excetption이나는지_테스트(){
        customCalculator = new CustomCalculator();
        customCalculator.divide(25,0);
    }
}