public class SimilarityChecker {
    public int getSimilarity(String inputStr1, String inputStr2) {
        int totalScore = 0;
        assertIllegalArgumentException(inputStr1, inputStr2);
        totalScore += getLengthSimilarScore(inputStr1, inputStr2);
        return totalScore;
    }

    public void assertIllegalArgumentException(String inputStr1, String inputStr2) {
        if (inputStr1 == null || inputStr2 == null) throw new IllegalArgumentException();
        if(inputStr1.isEmpty() || inputStr2.isEmpty()) throw new IllegalArgumentException();
    }

    public int getLengthSimilarScore(String inputStr1, String inputStr2) {
        if (isSameLength(inputStr1, inputStr2)) return 60;
        if (isDoubleLength(inputStr1, inputStr2)) return 0;
        return getPartialLengthScore(inputStr1, inputStr2);
    }

    private boolean isSameLength(String inputStr1, String inputStr2) {
        return inputStr1.length() == inputStr2.length();
    }

    private boolean isDoubleLength(String inputStr1, String inputStr2) {
        return inputStr1.length() >= 2 * inputStr2.length()
                || inputStr2.length() >= 2 * inputStr1.length();
    }

    private int getPartialLengthScore(String longString, String shortString) {
        if (longString.length() < shortString.length()) {
            String temp = longString;
            longString = shortString;
            shortString = temp;
        }
        double gap = longString.length() - shortString.length();
        return (int) ((1 - (gap / shortString.length())) * 60);
    }
}
