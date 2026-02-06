import java.util.Arrays;

public class Rank {
    private String[] hands;
    private int[] handType;

    public Rank(String[] hands, int[] handType){
        this.hands = hands;
        this.handType = handType;
    }

    public void RankHands(){
        int[] ranking = new int[hands.length];
        int count = 0;
        int alrRanked = 0;
        String eString = "";
        for (int i = 0; i < hands.length; i++){
            if (handType[i] == 1){
                count++;
                eString += hands[i] + "\n";
            }
        }
        if (count > 1){
            String[] equalString = eString.split("\n");
            System.out.println(Arrays.toString(equalString));
        }
        System.out.println(Arrays.toString(ranking));
    }
}
