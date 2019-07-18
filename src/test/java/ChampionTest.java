import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;


public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("레넥톤", "탑");
        Champion jungleChamp = new Champion("신짜오", "정글");
        Champion midChamp = new Champion("블라디미르", "미드");
        Champion adcChamp = new Champion("징크스", "바텀");
        Champion supportChamp = new Champion("쓰레쉬", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void List_처음생성했을때_값이_비어있는지_테스트() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void 생성하고_값을넣은_list가_null이_아닌지_테스트(){
        assertThat(championList,notNullValue());
    }
    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {

        String lcs = "LCS";
        assertThat(lcs, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String leagueName = null;
        assertThat(leagueName, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString1, is(endsWith("Focus")));
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, allOf(startsWith("Player"), endsWith("point")));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(2.71, closeTo(3, 0.3));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(2), anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertThat(championList, hasSize(5));
    }

    //서폿 챔피언은 파이크이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("파이크", "바텀");
        assertThat("파이크", is(supportChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(2), hasProperty("position", equalTo("미드")));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> iLikeChampNames = Arrays.asList("징크스", "케이틀린", "애쉬", "시비르", "트위치");
        assertThat(iLikeChampNames.get(1), hasToString("케이틀린"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }

    //정글 챔피언은 신짜오여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("정글"))
                .findFirst();
        System.out.println("result ::" + filterdChampion);
        String champName = filterdChampion.get().getName();
        assertThat(champName, is("신짜오"));
    }

}