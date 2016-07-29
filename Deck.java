package black_jack;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author atdp-11 Alyssa Lo
 *
 */
public class Deck {
    // Card Deck
    static String [] deck = {"Ace Of Clubs", "Ace Of Spades", "Ace Of Diamonds", "Ace Of Hearts",
        "Two Of Clubs", "Two Of Spades", "Two Of Diamonds", "Two Of Hearts",
        "Three Of Clubs", "Three Of Spades", "Three Of Diamonds", "Three Of Hearts",
        "Four Of Clubs", "Four Of Spades", "Four Of Diamonds", "Four Of Hearts",
        "Five Of Clubs", "Five Of Spades", "Five Of Diamonds", "Five Of Hearts",
        "Six Of Clubs", "Six Of Spades", "Six Of Diamonds", "Six Of Hearts",
        "Seven Of Clubs", "Seven Of Spades", "Seven Of Diamonds", "Seven Of Hearts",
        "Eight Of Clubs", "Eight Of Spades", "Eight Of Diamonds", "Eight Of Hearts",
        "Nine Of Clubs", "Nine Of Spades", "Nine Of Diamonds", "Nine Of Hearts",
        "Ten Of Clubs", "Ten Of Spades", "Ten Of Diamonds", "Ten Of Hearts",
        "Jack Of Clubs", "Jack Of Spades", "Jack Of Diamonds", "Jack Of Hearts",
        "Queen Of Clubs", "Queen Of Spades", "Queen Of Diamonds", "Queen Of Hearts",
        "King Of Clubs", "King Of Spades", "King Of Diamonds", "King Of Hearts"};
    int i = 0;

    /*
     *  Deck - Constructor Method 
     *  
     *  @param - none
     *  
     *  @return - none
     *  
     *  Can Shuffle Cards Using For Loop
     */
    public Deck (){ 
        shuffle();
    }

    /*
     * 
     */
    public static void shuffle (){
        // Goes To Each Element And Trades Values With Random Element (Shuffling)
        for (int i = 0; i < deck.length; i++){
            String holder = deck[i];
            int random = (int)(Math.random() * 52);

            deck[i] = deck[random];
            deck[random] = holder;
        }
    }

    /* 
     *  randomCard - Gives Card
     *  
     *  @param - none
     *  
     *  @return - card : A Card
     *  
     *  Finds A Random Card
     */
    public String randomCard (){
        String card = deck[i];

        // Never Run Out Of Cards
        if (i == 51){
            i = 0;
        } 

        i++;

        return card;

    }

    /*
     *   valueOfCards - Finds The Total Value Of Cards
     *  
     *   @param - ArrayList <String> cards : Cards Whose Total Value Will Be Found
     *  
     *   @return - int sum : Sum Of All Cards' Values
     *   
     *   for each Loop To Look At Each Element In ArrayList
     */
    public static int valueOfCards(ArrayList <String> cards){
        int sum = 0; 
        int sumAce = 0;

        for (String a : cards){
            if (a.startsWith("Two")){
                sum += 2;
            }
            if (a.startsWith("Three")){
                sum += 3;
            }
            if (a.startsWith("Four")){
                sum += 4;
            }
            if (a.startsWith("Five")){
                sum += 5;
            }
            if (a.startsWith("Six")){
                sum += 6;
            }
            if (a.startsWith("Seven")){
                sum += 7;
            }
            if (a.startsWith("Eight")){
                sum += 8;
            }
            if (a.startsWith("Nine")){
                sum += 9;
            }
            if (a.startsWith("Ten") || a.startsWith("Jack") || a.startsWith("Queen") || a.startsWith("King")){
                sum += 10;
            }
            if (a.startsWith("Ace")){
                sum += 1;
                sumAce = 10;
            }

            // Make Ace = 11 If It Is Beneficial To Player Or Dealer
            if (sum + sumAce <= 21){
                sum += sumAce;
            }
        }
        return sum;
    }

}
