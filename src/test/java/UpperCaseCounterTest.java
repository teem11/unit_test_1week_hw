import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    @Test
    public void null을_전달했을때_0을_리턴하는지에_대한_테스트(){
        String str = null;

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        //System.out.println("result ::" + numberOfUpperCaseCharactersInString);
        assertTrue(numberOfUpperCaseCharactersInString == 0);

//        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
    }

    @Test
    public void 빈값을_전달했을때_0을_리턴하는지에_대한_테스트() {
        String str = "";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(numberOfUpperCaseCharactersInString == 0);

    }

    @Test
    public void 대문자들이_포함된_문자열을_전달했을때_카운팅된_숫자와_맞는지_검증하는_테스트() {
        String str = "ABCDEFGHIJ";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(numberOfUpperCaseCharactersInString == 10);
        assertFalse(numberOfUpperCaseCharactersInString == 9);
        assertThat(numberOfUpperCaseCharactersInString, is(10));
    }


    @Test
    public void 대소문자가_섞여_있을때_정확히_카운팅_되는지에_대한_테스트(){
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result == 6);
        assertFalse(result == 9);
        assertThat(result, is(6));
        System.out.println("result :: " + result);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void 잘못된_값을_참조했을때_IndexOutOfBoundsException_Exception이_발생하는지_테스트() {
        new ArrayList<Object>().get(0);
    }

    @Ignore
    @Test(timeout = 5000)
    public void 메소드가_제한된_시간내에_실행되는지에_대한_테스트_코드() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");
    }
}
