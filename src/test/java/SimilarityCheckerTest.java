import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {

    SimilarityChecker similarityChecker;
    @BeforeEach
    void setUp() {
         similarityChecker = new SimilarityChecker();
    }
    @Test
    void createSimilarityChecker() {
        assertNotNull(similarityChecker);
    }

    //TODO    1. 글자 수 검사 (최대 60점)
    /* 글자 수 검사 (max 60점)
    같은 글자수일때, 최대 점수 60점 획득
    문자열 길이가 2배 이상 차이가 난다면, 0점

    부분 점수 측정 방법
    • 𝐴 = 긴 문자열 길이
    • 𝐵 = 짧은 문자열의 길이

    ASD, DSA = 60점
    A, BB = 0점
    AAABB, BAA = 부분점수
    AA, AAE = 부분점수

    - 부분점수 공식: (1 - 𝐺𝑎𝑝/𝐵)× 60
    *Gap = 𝐴 − 𝐵
     */


    @Test
    void checkValidInputs() {
        assertInputException();
    }

    private void assertInputException(){
        assertIllegalArgumentException(null,"ASD");
        assertIllegalArgumentException("DSA",null);
    }

    private void assertIllegalArgumentException(String input1, String input2) {
        assertThrowsExactly(IllegalArgumentException.class,()->{
            similarityChecker.getSimilarity(input1, input2);
        });
    }


    @Test
    void getMaxLengthSimilarity() {
        assertEquals(60,similarityChecker.getSimilarity("ASD","DSA"));
    }

    //TODO    2. 등장 알파벳 검사 (최대 40점)

}
