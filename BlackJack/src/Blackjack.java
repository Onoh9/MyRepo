import java.util.*;
public class Blackjack {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        P1Random rng = new P1Random();
        int gameNum = 1, myHand = 0, numPWins = 0, numDWins = 0, numTies = 0; // initialize all int
        double percentPWins; // declare percentage double
        outer: while (true) {
            System.out.println("START GAME #" + gameNum);
            int myNumber = rng.nextInt(13) + 1; // generates "random" number
            String myCard = null;
            if (myNumber == 1) { //translates mynumber into card numbers
                myCard = "ACE";
            } else if (myNumber >= 2 && myNumber <= 10) {
                myCard = String.valueOf(myNumber);
            } else if (myNumber == 11) {
                myCard = "JACK";
                myNumber = 10;
            } else if (myNumber == 12) {
                myCard = "QUEEN";
                myNumber = 10;
            } else if (myNumber == 13) {
                myCard = "KING";
                myNumber = 10;
            }
            System.out.println("Your card is a " + myCard + "!");
            myHand += myNumber;
            System.out.println("Your hand is: " + myHand);
            middle: while (true) {
                menu();
                System.out.println("Choose an option: "); // menu option fro user input
                int option = scnr.nextInt();


                inner: while (true) {

                    switch (option) {

                        case 1:

                            while (myHand < 21) {
                                myNumber = rng.nextInt(13) + 1;
                                myCard = null;
                                if (myNumber == 1) { //translates mynumber into my card
                                    myCard = "ACE";
                                } else if (myNumber >= 2 && myNumber <= 10) {
                                    myCard = String.valueOf(myNumber);
                                } else if (myNumber == 11) {
                                    myCard = "JACK";
                                    myNumber = 10;
                                } else if (myNumber == 12) {
                                    myCard = "QUEEN";
                                    myNumber = 10;
                                } else if (myNumber == 13) {
                                    myCard = "KING";
                                    myNumber = 10;
                                }
                                System.out.println("Your card is a " + myCard + "!");
                                myHand += myNumber;
                                System.out.println("Your hand is: " + myHand);
                                if (myHand == 21) { //if your hand is 21, blackjack
                                    System.out.println("BLACKJACK! You win!");
                                    myHand = 0;
                                    numPWins++;
                                    gameNum++;
                                    break middle;
                                } else if (myHand > 21) {
                                    System.out.println("You exceeded 21! You lose.");
                                    myHand = 0;
                                    numDWins++;
                                    gameNum++;
                                    break middle;
                                }
                                menu();
                                System.out.println("Choose an option: ");
                                option = scnr.nextInt();
                                break; // breaks out of the while loop
                            }

                            break; // breaks out of case 1

                        case 2:
                            int dealerHand = rng.nextInt(11) + 16;
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + myHand);
                            if (dealerHand > 21 || myHand > dealerHand && myHand > 21){
                                System.out.println("You win!");
                                myHand = 0;
                                numPWins++;
                                gameNum++;

                            } else if (myHand == dealerHand) {
                                System.out.println("It's a tie! No one wins!");
                                myHand = 0;
                                numTies++;
                                gameNum++;
                            } else {
                                System.out.println("Dealer wins!");
                                myHand = 0;
                                numDWins++;
                                gameNum++;
                            }
                            break middle;
                        case 3:
                            double nPW = numPWins;
                            double gN = numDWins + numPWins + numTies; // GAMENUMBER , gn , sum of all games won lost and tied
                            int gameNumber = (int) gN;
                            System.out.println("Number of Player wins: " + numPWins);
                            System.out.println("Number of Dealer wins: " + numDWins);
                            System.out.println("Number of tie games: " + numTies);
                            System.out.println("Total # of games played is: " + gameNumber);
                            percentPWins = (nPW / gN) * 100;
                            System.out.println("Percentage of Player wins: " + percentPWins + "%");
                            break inner;
                        case 4:
                            System.exit(0);
                            break;
                        default: // if user input isnt 1<=x<=4
                            System.out.println("Invalid input!");
                            System.out.println("Please enter an integer value between 1 and 4.");
                            break inner;
                    }
                }

            }
        }
    }
    public static void menu(){ //menu method
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
    }

}
