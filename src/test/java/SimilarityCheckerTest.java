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
    @Test
    void checkValidInputs() {
        assertInputException();
    }

    private void assertInputException() {
        assertIllegalArgumentException(null, "ASD");
        assertIllegalArgumentException("DSA", null);
        assertIllegalArgumentException("","ASD");
        assertIllegalArgumentException("DSA","");
    }

    private void assertIllegalArgumentException(String input1, String input2) {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            similarityChecker.assertIllegalArgumentException(input1, input2);
        });
    }


    @Test
    void getLengthSimilarityScoreMax() {
        assertEquals(60, similarityChecker.getLengthSimilarScore("ASD", "DSA"));
    }

    @Test
    void getLengthSimilarityScoreZero() {
        assertEquals(0, similarityChecker.getLengthSimilarScore("A", "BB"));
    }

    @Test
    void getPartialLengthSimilarityScore() {
        assertEquals(20, similarityChecker.getLengthSimilarScore("AAABB", "BAA"));
        assertEquals(30, similarityChecker.getLengthSimilarScore("AA", "AAE"));
    }

    //TODO    2. 등장 알파벳 검사 (최대 40점)

}
