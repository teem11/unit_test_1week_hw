import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        Champion topChamp = new Champion("레넥톤", "탑");
        Champion jungleChamp = new Champion("신짜오", "정글");
        Champion midChamp = new Champion("블라디미르", "미드");
        Champion adcChamp = new Champion("징크스", "바텀");
        Champion supportChamp = new Champion("쓰레쉬", "바텀");

        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }
    
    @Test
    public void List_처음생성했을때_값이_비어있는지_테스트() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void 생성하고_값을넣은_list가_null이_아닌지_테스트(){
        assertThat(championList,notNullValue());
    }
    @Test
    public void notNullCheck() {

        String lcs = "LCS";
        assertThat(lcs, notNullValue());
    }

    @Test
    public void givenStringWhenNullIsCorrect() {
        String leagueName = null;
        assertThat(leagueName, nullValue());
    }

    @Test
    public void testForRelatedString() {
        String sampleString1 = "도라에몽";
        String sampleString2 = "도라이몽";
        String startString = "도라";
        String endString = "에몽";
        assertThat(sampleString1, is(endsWith("에몽")));
        assertThat(sampleString2, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString1, allOf(startsWith(startString), endsWith(endString)));
    }

    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 1.5));
    }

    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(2), anything());
    }

    @Test
    public void shouldChampionCountFive() {
        assertThat(championList, hasSize(5));
    }

    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("파이크", "바텀");
        assertThat("파이크", is(supportChamp.getName()));
    }

    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(2), hasProperty("position", equalTo("미드")));
    }

    @Test
    public void shouldHaveSomeChampName() {
        List<String> iLikeChampNames = Arrays.asList("징크스", "케이틀린", "애쉬", "시비르", "트위치");
        assertThat(iLikeChampNames.get(1), hasToString("케이틀린"));
    }

    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }

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