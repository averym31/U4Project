import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] hands = fileData.split("\n");

        int numFive = 0;
        int numFour = 0;
        int numFull = 0;
        int numThree = 0;
        int numTwo = 0;
        int numOne = 0;
        int numHigh = 0;

        int[] handType = new int[hands.length];
        int [] bidList = new int[hands.length];
        for (int i = 0; i < hands.length; i++) {
            String[] handNum = hands[i].split(",");
            bidList[i] = Integer.parseInt(handNum[4].substring(handNum[4].indexOf("|") + 1));
            handNum[4] = handNum[4].substring(0, handNum[4].indexOf("|"));
            String unequalString = "";
            int unequal = 0;
            for (String string : handNum) {
                if (!handNum[0].equals(string)) {
                    unequal++;
                    unequalString += string + "\n";
                }
            }
            String[] unequalArrayIteration = unequalString.split("\n");
            if (unequal == 0) {
                numFive++;
                handType[i] = 7;
            } else if (unequal == 1) {
                numFour++;
                handType[i] = 6;
            } else if (unequal == 2) {
                if (unequalArrayIteration[0].equals(unequalArrayIteration[1])) {
                    numFull++;
                    handType[i] = 5;
                } else {
                    numThree++;
                    handType[i] = 4;
                }
            } else if (unequal == 3) {
                unequalString = "";
                unequal = 0;
                for (String s : unequalArrayIteration) {
                    if (!unequalArrayIteration[0].equals(s)) {
                        unequal++;
                        unequalString += s + "\n";
                    }
                }
                if (unequal == 0) {
                    numFull++;
                    handType[i] = 5;
                } else if (unequal == 1) {
                    numTwo++;
                    handType[i] = 3;
                } else if (unequal == 2) {
                    String[] unequalArrayNextIteration = unequalString.split("\n");
                    if (unequalArrayNextIteration[0].equals(unequalArrayNextIteration[1])) {
                        numTwo++;
                        handType[i] = 3;
                    } else {
                        numOne++;
                        handType[i] = 2;
                    }
                }
            } else if (unequal == 4) {
                unequalString = "";
                unequal = 0;
                for (String s : unequalArrayIteration) {
                    if (!unequalArrayIteration[0].equals(s)) {
                        unequal++;
                        unequalString += s + "\n";
                    }
                }
                if (unequal == 0) {
                    numFour++;
                    handType[i] = 6;
                }
                if (unequal == 1) {
                    numThree++;
                    handType[i] = 4;
                }
                if (unequal == 2) {
                    String[] unequalArrayNextIteration = unequalString.split("\n");
                    if (unequalArrayNextIteration[0].equals(unequalArrayNextIteration[1])) {
                        numTwo++;
                        handType[i] = 3;
                    } else {
                        numOne++;
                        handType[i] = 2;
                    }
                }
                if (unequal == 3) {
                    String[] unequalArrayNextIteration = unequalString.split("\n");
                    unequalString = "";
                    unequal = 0;
                    for (String s : unequalArrayNextIteration) {
                        if (!unequalArrayNextIteration[0].equals(s)) {
                            unequal++;
                            unequalString += s + "\n";
                        }
                    }
                    if (unequal == 0) {
                        numThree++;
                        handType[i] = 4;
                    }
                    if (unequal == 1) {
                        numOne++;
                        handType[i] = 2;
                    }
                    if (unequal == 2) {
                        if (unequalArrayNextIteration[1].equals(unequalArrayNextIteration[2])) {
                            numOne++;
                            handType[i] = 2;
                        }
                        else {
                            numHigh++;
                            handType[i] = 1;
                        }
                    }
                }
            }
        }
        System.out.println("Number of five of a kind hands: " + numFive);
        System.out.println("Number of four of a kind hands: " + numFour);
        System.out.println("Number of full house hands: " + numFull);
        System.out.println("Number of three of a kind hands: " + numThree);
        System.out.println("Number of two pair hands: " + numTwo);
        System.out.println("Number of one pair hands: " + numOne);
        System.out.println("Number of high card hands: " + numHigh);

        // rankings for each hand in the handtype array (higher number = better ranking)
        // 7 = fivekind
        // 6 = fourkind
        // 5 = fullhouse
        // 4 = threekind
        // 3 = twokind
        // 2 = onekind
        // 1 = highcard

        System.out.println(Arrays.toString(hands));
        System.out.println(Arrays.toString(handType));
        Rank poker = new Rank(hands, handType);
        poker.RankHands();
    }
}