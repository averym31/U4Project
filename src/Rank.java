import java.util.Arrays;

public class Rank {
    private String[] hands;
    private int[] handType;

    public Rank(String[] hands, int[] handType){
        this.hands = hands;
        this.handType = handType;
    }

    // ranks all the hands in the array
    public String[] RankHands(boolean isWild){
        int count = 0;
        int alrcount = 0;
        String eString = "";
        String[] equalString = new String[hands.length];
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < hands.length; i++) {
                if (handType[i] == j) {
                    count++;
                    eString += hands[i] + "\n";
                }
            }
            equalString = eString.split("\n");
            for (int p = 0; p < equalString.length; p++) {
                equalString[p] = equalString[p].replace("10","v");
                // makes jack the weakest card if the Jack Wild rule applies
                if (isWild){
                    equalString[p] = equalString[p].replace("Jack","1");
                }
                else{
                    equalString[p] = equalString[p].replace("Jack","w");
                }
                equalString[p] = equalString[p].replace("Queen","x");
                equalString[p] = equalString[p].replace("King","y");
                equalString[p] = equalString[p].replace("Ace","z");
            }
            String[] handTypeSeparate = new String[count-alrcount];
            for(int k = 0; k < handTypeSeparate.length; k++){
                handTypeSeparate[k] = equalString[k+alrcount];
            }
            Arrays.sort(handTypeSeparate);
            for(int m = 0; m < handTypeSeparate.length; m++){
                equalString[m+alrcount] = "";
                equalString[m+alrcount] = handTypeSeparate[m];
            }
            alrcount = count;
            System.out.println(Arrays.toString(equalString));
        }
        return equalString;
    }
}
