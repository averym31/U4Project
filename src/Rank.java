import java.util.Arrays;

public class Rank {
    private String[] hands;
    private int[] handType;

    public Rank(String[] hands, int[] handType){
        this.hands = hands;
        this.handType = handType;
    }

    public String[] RankHands(){
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
                equalString[p] = equalString[p].replace("Jack","w");
                equalString[p] = equalString[p].replace("Queen","x");
                equalString[p] = equalString[p].replace("King","y");
                equalString[p] = equalString[p].replace("Ace","z");
            }
            String[] handTypeSeperate = new String[count-alrcount];
            for(int k = 0; k < handTypeSeperate.length; k++){
                handTypeSeperate[k] = equalString[k+alrcount];
            }
            Arrays.sort(handTypeSeperate);
            for(int m = 0; m < handTypeSeperate.length; m++){
                equalString[m+alrcount] = "";
                equalString[m+alrcount] = handTypeSeperate[m];
            }
            alrcount = count;
        }
        return equalString;
    }
}
