public class SimilarityChecker {
    public int getSimilarity(String inputStr1, String inputStr2) {
        if (inputStr1 == null || inputStr2 == null) throw new IllegalArgumentException();
        if (isSameLength(inputStr1, inputStr2)) return 60;
        if (isDoubleLength(inputStr1, inputStr2)) return 0;

        double gap = Math.abs(inputStr1.length() - inputStr2.length());
        double partialScore;
        if (inputStr1.length() > inputStr2.length()) {
            partialScore = (1 - gap / inputStr2.length()) * 60;
        }
        else {
            partialScore = (1 - gap / inputStr1.length()) * 60;
        }
        return (int) partialScore;
    }

    private boolean isDoubleLength(String inputStr1, String inputStr2) {
        return inputStr1.length() >= 2 * inputStr2.length()
                || inputStr2.length() >= 2 * inputStr1.length();
    }

    private boolean isSameLength(String inputStr1, String inputStr2) {
        return inputStr1.length() == inputStr2.length();
    }
}
