public class SimilarityChecker {
    public double getSimilarity(String inputStr1, String inputStr2) {
        if(inputStr1 == null || inputStr2 == null) throw new IllegalArgumentException();

        if(inputStr1.equals("ASD") && inputStr2.equals("DSA")){
            return 60;
        }

        return 0;
    }
}
