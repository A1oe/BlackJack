package black_jack;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author atdp-11 Alyssa Lo
 *
 */
public class BlackJackGame {

    /*
     *  main - Main Method
     * 
     *  @param - none
     * 
     *  @return - void
     * 
     *  Runs mainMenu Method
     */
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        Deck deck = new Deck();

        // Headers
        System.out.println("Welcome To Black Jack.");
        mainMenu(console, deck);        

    }

    /*
     *  mainMenu - Main Menu Of Game
     * 
     *  @param - Scanner console : Scanner That Reads Inputs
     *             Deck deck : Object That Deals With The Deck
     * 
     *  @return - void
     * 
     *  Calls Other multiPlayer
     */
    public static void mainMenu (Scanner console, Deck deck){
        String players = "100";

        // Makes Sure Input Is Valid
        while (!players.equals("1") && !players.equals("2") && !players.equals("3")
                && !players.equals("4") && !players.equals("5") && !players.equals("6")
                && !players.equals("7") && !players.equals("8") && !players.equals("9") && !players.equals("10")){

            // Keeps Asking For # of Players Until There Is A Valid #
            System.out.println("Please Enter A Valid Number Of Players (1-10): ");
            players = console.nextLine();
        }

        int numPlayers = Integer.parseInt(players);
        multiPlayer(console, deck, numPlayers);
    }

    /*
     *  multiPlayer - MultiPlayer & One Player Mode Of Game
     * 
     *  @param - Scanner console : Scanner That Reads Inputs
     *             Deck deck : Object That Deals With The Deck
     * 
     *  @return - void
     * 
     *  Runs For Any Number Of Players
     *  Has Objects, Arrays, for Loops, if Statements, while Loops 
     */
    public static void multiPlayer (Scanner console, Deck deck, int players){
        String name = "";
        int ender = 0; // Ends Game

        // Array Of BlackJackPlayers
        BlackJackPlayer [] playerInfo = new BlackJackPlayer [players + 1]; // Normal People Who Don't Do Split Cases
        BlackJackPlayer [] splitPlayerInfo = new BlackJackPlayer [players + 1];  // Crazy People Who Do Split Cases
        playerInfo[playerInfo.length - 1] = new BlackJackPlayer ("Dealer"); // New Object

        // Puts Stuff Inside Array of Objects
        for (int i = 0; i < playerInfo.length - 1; i++){
            // Put Stuff Inside Objects
            System.out.println("Player " + (i+1) + "'s name: ");
            name = console.nextLine();
            playerInfo[i] = new BlackJackPlayer (name, 10);   
            splitPlayerInfo[i] = new BlackJackPlayer ();
        }

        System.out.println("\nEveryone Starts With 10 Tokens.");

        // Run This Until ender = 0
        while (ender == 0){

            // Goes Through Each Player
            for (int a = 0; a < playerInfo.length - 1; a++){
                int countNoTokenPlayers = 0;
                while (ender == 0){


                    for (int c = 0; c < playerInfo.length - 1; c++){
                        if (playerInfo[c].token == 0){

                            System.out.println(playerInfo[c].playerName + ", You have no more tokens.");
                            countNoTokenPlayers++;

                            if (countNoTokenPlayers == playerInfo.length - 1){
                                System.out.println("All Players Have 0 Tokens. Game Has Ended.");

                                ender++;
                            }

                        } else {
                            playerInfo[c].cards.add(deck.randomCard()); // Two Random Cards
                            playerInfo[c].cards.add(deck.randomCard());

                            // Deals With Tokens
                            System.out.println(playerInfo[c].playerName + " (" + playerInfo[c].token + ") " +
                            ": How Much Would You Like To Bet?");
                            String tokensIn = console.nextLine();

                            // Make Sure Input Is An Integer 
                            while (!tokensIn.equals("1") && !tokensIn.equals("2") && !tokensIn.equals("3") && 
                                    !tokensIn.equals("4") && !tokensIn.equals("5") && !tokensIn.equals("6") &&
                                    !tokensIn.equals("7") && !tokensIn.equals("8") && !tokensIn.equals("9") &&
                                    !tokensIn.equals("10") && !tokensIn.equals("11") && !tokensIn.equals("12") && 
                                    !tokensIn.equals("13") && !tokensIn.equals("14") && !tokensIn.equals("15") && 
                                    !tokensIn.equals("16") && !tokensIn.equals("17") && !tokensIn.equals("18") && 
                                    !tokensIn.equals("19") && !tokensIn.equals("20") && !tokensIn.equals("21") && 
                                    !tokensIn.equals("22") && !tokensIn.equals("23") && !tokensIn.equals("24") && 
                                    !tokensIn.equals("25") && !tokensIn.equals("26") && !tokensIn.equals("27") &&
                                    !tokensIn.equals("28") && !tokensIn.equals("29") && !tokensIn.equals("30") && 
                                    !tokensIn.equals("31") && !tokensIn.equals("32") && !tokensIn.equals("33") && 
                                    !tokensIn.equals("34") && !tokensIn.equals("35") && !tokensIn.equals("36") &&
                                    !tokensIn.equals("37") && !tokensIn.equals("38") && !tokensIn.equals("39") &&
                                    !tokensIn.equals("40")){

                                System.out.println("Please Enter A Valid Number Of Tokens: ");
                                tokensIn = console.nextLine();

                            }

                            // Tokens Bet
                            playerInfo[c].tokenBet = Integer.parseInt(tokensIn);

                            // Makes Sure Tokens Bet Is Valid 
                            while (playerInfo[c].tokenBet > playerInfo[c].token){
                                System.out.println("Please Enter A Valid Number Of Tokens: ");
                                tokensIn = console.nextLine();

                                // Make Sure Input Is An Integer
                                while (!tokensIn.equals("1") && !tokensIn.equals("2") && !tokensIn.equals("3") && 
                                        !tokensIn.equals("4") && !tokensIn.equals("5") && !tokensIn.equals("6") &&
                                        !tokensIn.equals("7") && !tokensIn.equals("8") && !tokensIn.equals("9") &&
                                        !tokensIn.equals("10") && !tokensIn.equals("11") && !tokensIn.equals("12") && 
                                        !tokensIn.equals("13") && !tokensIn.equals("14") && !tokensIn.equals("15") && 
                                        !tokensIn.equals("16") && !tokensIn.equals("17") && !tokensIn.equals("18") && 
                                        !tokensIn.equals("19") && !tokensIn.equals("20") && !tokensIn.equals("21") &&
                                        !tokensIn.equals("22") && !tokensIn.equals("23") && !tokensIn.equals("24") && 
                                        !tokensIn.equals("25") && !tokensIn.equals("26") && !tokensIn.equals("27") &&
                                        !tokensIn.equals("28") && !tokensIn.equals("29") && !tokensIn.equals("30") && 
                                        !tokensIn.equals("31") && !tokensIn.equals("32") && !tokensIn.equals("33") && 
                                        !tokensIn.equals("34") && !tokensIn.equals("35") && !tokensIn.equals("36") &&
                                        !tokensIn.equals("37") && !tokensIn.equals("38") && !tokensIn.equals("39") &&
                                        !tokensIn.equals("40")){

                                    System.out.println("Please Enter A Valid Number Of Tokens: ");
                                    tokensIn = console.nextLine();
                                }
                                playerInfo[c].tokenBet = Integer.parseInt(tokensIn);
                            }        

                            playerInfo[c].token = playerInfo[c].token - playerInfo[c].tokenBet;
                        }
                    }

                    // Dealer Information
                    if (ender == 0){
                        playerInfo[playerInfo.length - 1].cards.add(deck.randomCard()); // Adds Random Card
                        playerInfo[playerInfo.length - 1].cards.add("[Unknown]"); // Hides Second Card
                        System.out.println(playerInfo[playerInfo.length - 1]); // Prints Card As Unknown First
                        playerInfo[playerInfo.length - 1].cards.set(1, deck.randomCard()); // Replaces Second Card With Valid Card

                        // Prints Out Player Information     
                        for (int b = 0; b < playerInfo.length - 1; b++){
                            System.out.println(playerInfo[b]);
                        }

                        // Actual Game Play
                        // h,s,dd,sp,x for Players
                        for (int i = 0; i < playerInfo.length - 1; i++){

                            String step = "";
                            if (playerInfo[i].tokenBet > playerInfo[i].token){ // No Double Down For Too Big A Bet
                                System.out.println("\n" + playerInfo[i].playerName + " Enter: 'h' - Hit, "
                                        + "'s' - Stay, "  + "'x' - Surrender");
                                step = console.nextLine().toLowerCase();

                                while (!step.equals("h") && !step.equals("s") && 
                                        !step.equals("sp") && !step.equals("x")){

                                    System.out.println("\nInvalid Input. " + playerInfo[i].playerName + " Enter: 'h' - Hit, "
                                            + "'s' - Stay, " + "'x' - Surrender");
                                    step = console.nextLine().toLowerCase();
                                }
                            } else if (playerInfo[i].tokenBet <= playerInfo[i].token){ // Can Double Down
                                // Check For Same Values
                                boolean splitOrNah = false;

                                for (int x = 0; x < playerInfo[i].cards.size(); x++){
                                    int compare = cardValue(playerInfo[i].cards.get(x));

                                    for (int y = 0; y < playerInfo[i].cards.size(); y++){
                                        if (x != y){
                                            if (cardValue(playerInfo[i].cards.get(y)) == compare){
                                                splitOrNah = true;
                                                y = playerInfo[i].cards.size() - 1; // Get Out Of nested for Loops
                                                x = playerInfo[i].cards.size() - 1;
                                            }
                                        }
                                    }
                                }

                                if (splitOrNah == true ){ // Can Split
                                    System.out.println("\n" + playerInfo[i].playerName + " Enter: 'h' - Hit, "
                                            + "'s' - Stay, 'dd' - Double Down, "
                                            + "'sp' - Split, 'x' - Surrender");
                                    step = console.nextLine().toLowerCase();

                                    while (!step.equals("h") && !step.equals("s") && 
                                            !step.equals("sp") && !step.equals("dd") && !step.equals("x")){

                                        System.out.println("\nInvalid Input. " + playerInfo[i].playerName + " Enter: 'h' - Hit, "
                                                + "'s' - Stay, 'dd' - Double Down, "
                                                + "'sp' - Split, 'x' - Surrender");
                                        step = console.nextLine().toLowerCase();
                                    }
                                } else { // Cannot Split
                                    System.out.println("\n" + playerInfo[i].playerName + " Enter: 'h' - Hit, "
                                            + "'s' - Stay, 'dd' - Double Down, "
                                            + "'x' - Surrender");
                                    step = console.nextLine().toLowerCase();

                                    while (!step.equals("h") && !step.equals("s") && 
                                            !step.equals("dd") && !step.equals("x")){

                                        System.out.println("\nInvalid Input. " + playerInfo[i].playerName + " Enter: 'h' - Hit, "
                                                + "'s' - Stay, 'dd' - Double Down, "
                                                + "'x' - Surrender");
                                        step = console.nextLine().toLowerCase();
                                    }

                                }
                            }

                            int sum = 0;

                            // Run For Hit
                            if (step.equals("h")){
                                int stop = 0;

                                // Run Until Bust Or Stay
                                while (step.equals("h") && stop == 0){
                                    playerInfo[i].cards.add(deck.randomCard());

                                    sum = Deck.valueOfCards(playerInfo[i].cards); 

                                    if (sum > 21){ // Bust
                                        System.out.println(playerInfo[i].playerName + " Has Busted.");

                                        stop = 1;
                                    } else { // Hit Or Stay
                                        System.out.println(playerInfo[i]);

                                        System.out.println(playerInfo[i].playerName + ": Hit(h) Or Stay(s)");
                                        step = console.nextLine().toLowerCase();

                                        // Make Sure step Is Valid
                                        while (!step.equals("h") && !step.equals("s")) {
                                            System.out.println("Invalid Input. " + playerInfo[i].playerName + ": Hit(h) Or Stay(s)");
                                            step = console.nextLine().toLowerCase();    
                                        }
                                    }
                                }
                            }
                            // Run For Stay
                            if (step.equals("s")){
                            }
                            // Run For Double Down
                            if (step.equals("dd") ){    
                                playerInfo[i].token -= playerInfo[i].tokenBet; 
                                playerInfo[i].tokenBet *= 2;

                                playerInfo[i].cards.add(deck.randomCard());
                                System.out.println(playerInfo[i]);

                                sum = Deck.valueOfCards(playerInfo[i].cards);
                                if (sum > 21){
                                    System.out.println(playerInfo[i].playerName + " Has Busted.");
                                }
                            }
                            // Run For Split
                            if (step.equals("sp")){
                                playerInfo[i].token -= playerInfo[i].tokenBet;
                                
                                for (int x = 0; x < playerInfo[i].cards.size(); x++){
                                    int compare = cardValue(playerInfo[i].cards.get(x));

                                    for (int y = 0; y < playerInfo[i].cards.size(); y++){
                                        if (x != y){
                                            if (cardValue(playerInfo[i].cards.get(y)) == compare){
                                                splitPlayerInfo[i].cards.add(playerInfo[i].cards.get(y));
                                                playerInfo[i].cards.remove(y);

                                                y = playerInfo[i].cards.size() - 1; // Get Out Of nested for Loops
                                                x = playerInfo[i].cards.size() - 1;
                                            }
                                        }
                                    }
                                }

                                for (int card = 0; card < splitPlayerInfo[i].cards.size(); card++){
                                    System.out.println(playerInfo[i].playerName + " Split: " + 
                                            splitPlayerInfo[i].cards.get(card) + "   ");
                                }
                                
                                step = "h, sp";

                            }
                            // Run For Hit For Normal Decks That Have Splitted 
                            if (step.equals("h, sp")){
                                int stop = 0;
                                System.out.println(playerInfo[i].playerName + " : First Deck\n");

                                // Run Until Bust Or Stay
                                while (step.equals("h, sp") && stop == 0){
                                    playerInfo[i].cards.add(deck.randomCard());

                                    sum = Deck.valueOfCards(playerInfo[i].cards); 

                                    if (sum > 21){ // Bust
                                        System.out.println(playerInfo[i].playerName + " Has Busted.");

                                        stop = 1;
                                    } else { // Hit Or Stay
                                        System.out.println(playerInfo[i]);

                                        System.out.println(playerInfo[i].playerName + ": Hit(h) Or Stay(s)");
                                        step = console.nextLine().toLowerCase();

                                        // Make Sure step Is Valid
                                        while (!step.equals("h") && !step.equals("s")) {
                                            System.out.println("Invalid Input. " + playerInfo[i].playerName + ": Hit(h) Or Stay(s)");
                                            step = console.nextLine().toLowerCase();    
                                        }

                                        step = step + ", sp";
                                    }
                                }
                            }
                            // Run For Stay For Normal Decks That Have Splitted 
                            if (step.equals("s, sp")){
                                step = "h2, sp";
                            }

                            // Run For Hit For Split Decks
                            if (step.equals("h2, sp")){
                                int stop = 0;
                                System.out.println(playerInfo[i].playerName + " : Second Deck\n");

                                // Run Until Bust Or Stay
                                while (step.equals("h2, sp") && stop == 0){
                                    splitPlayerInfo[i].cards.add(deck.randomCard());

                                    sum = Deck.valueOfCards(splitPlayerInfo[i].cards); 

                                    if (sum > 21){ // Bust
                                        System.out.println(playerInfo[i].playerName + " Has Busted.");

                                        stop = 1;
                                    } else { // Hit Or Stay
                                        System.out.print(playerInfo[i].playerName + " : ");
                                        for (int cards = 0; cards < splitPlayerInfo[i].cards.size(); cards++){
                                            System.out.print(splitPlayerInfo[i].cards.get(cards) + "   ");
                                        }
                                        
                                        System.out.println();
                                        
                                        System.out.println(playerInfo[i].playerName + ": Hit(h) Or Stay(s)");
                                        step = console.nextLine().toLowerCase();

                                        // Make Sure step Is Valid
                                        while (!step.equals("h") && !step.equals("s")) {
                                            System.out.println("Invalid Input. " + playerInfo[i].playerName + ": Hit(h) Or Stay(s)");
                                            step = console.nextLine().toLowerCase();    
                                        }

                                        step = step + "2, sp";
                                    }
                                }
                            }
                            // Run For Stay For Split Decks 
                            if (step.equals("s2, sp")){
                            }

                            // Run For Surrender 
                            if (step.equals("x")){
                                // Clear Cards
                                playerInfo[i].cards.clear();
                                playerInfo[i].token += playerInfo[i].tokenBet;
                            }

                            // Print Out The Cards And Crazy (Split) Cards
                            System.out.println(playerInfo[i]);
                            if (step.equals("h, sp") || step.equals("s, sp") || step.equals("h2, sp") || step.equals("s2, sp")){
                                System.out.print(playerInfo[i].playerName + " Split: ");
                                for (int card = 0; card < splitPlayerInfo[i].cards.size(); card++){
                                    System.out.print(splitPlayerInfo[i].cards.get(card) + "   ");
                                }    
                            }

                        }

                        // Exactly 21 Case
                        for (int element = 0; element < playerInfo.length - 1; element++){
                            // First Deck
                            if (Deck.valueOfCards(playerInfo[element].cards) == 21){
                                System.out.println(playerInfo[element].playerName + ": Exactly 21. +1 Token.");

                                playerInfo[element].token++;

                                System.out.println(playerInfo[element]);
                            }
                            // Crazy (Split) Deck
                            if (Deck.valueOfCards(splitPlayerInfo[element].cards) == 21){
                                System.out.println(playerInfo[element].playerName + ": Exactly 21 in Second Deck. +1 Token.");

                                splitPlayerInfo[element].token++;

                                System.out.println(playerInfo[element]);
                                System.out.print(playerInfo[element].playerName + " Split: ");
                                for (int card = 0; card < splitPlayerInfo[element].cards.size(); card++){
                                    System.out.print(splitPlayerInfo[element].cards.get(card) + "   ");
                                }    
                            }
                        }

                        // h or s For Dealer
                        while (Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards) <= 16){
                            System.out.println("\nDealer Hits");

                            playerInfo[playerInfo.length - 1].cards.add(deck.randomCard());
                            System.out.println(playerInfo[playerInfo.length - 1]);

                        }
                        if (Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards) > 16){
                            System.out.println("\nDealer Stays");
                            System.out.println(playerInfo[playerInfo.length - 1]);
                        }

                        // Dealer Bust Case & Giving Tokens
                        if (Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards) > 21){
                            System.out.println("Dealer Has Busted.");

                            for (int a2 = 0; a2 < playerInfo.length - 1; a2++){
                                // First Deck - If You Win
                                if (Deck.valueOfCards(playerInfo[a2].cards) <= 21 && Deck.valueOfCards(playerInfo[a2].cards) != 0){
                                    playerInfo[a2].token += playerInfo[a2].tokenBet * 2;
                                }
                                
                                // Split Deck - If You Win
                                if (Deck.valueOfCards(splitPlayerInfo[a2].cards) <= 21 && Deck.valueOfCards(splitPlayerInfo[a2].cards) != 0){
                                    splitPlayerInfo[a2].token += playerInfo[a2].tokenBet * 2;
                                }
                                
                                // Print Out Tokens
                                System.out.println(playerInfo[a2].playerName + "'s Tokens: " + (playerInfo[a2].token + splitPlayerInfo[a2].token));            
                            }

                        } else {
                            // Dealer Does Not Bust Case
                            for (int b = 0; b < playerInfo.length - 1; b++){
                                // Fist Deck - If You Win
                                if (Deck.valueOfCards(playerInfo[b].cards) > Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards) 
                                        && Deck.valueOfCards(playerInfo[b].cards) <= 21){
                                    playerInfo[b].token += playerInfo[b].tokenBet * 2;    
                                } 
                                if (Deck.valueOfCards(playerInfo[b].cards) == Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards)){
                                    playerInfo[b].token = playerInfo[b].token + playerInfo[b].tokenBet;
                                }
                                
                                // Second Deck - If You Win
                                if (Deck.valueOfCards(splitPlayerInfo[b].cards) > Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards) 
                                        && Deck.valueOfCards(splitPlayerInfo[b].cards) <= 21){
                                    splitPlayerInfo[b].token += playerInfo[b].tokenBet * 2;    
                                } 
                                if (Deck.valueOfCards(splitPlayerInfo[b].cards) == Deck.valueOfCards(playerInfo[playerInfo.length - 1].cards)){
                                    splitPlayerInfo[b].token = splitPlayerInfo[b].token + playerInfo[b].tokenBet;
                                }

                                // Print Out Tokens
                                System.out.println(playerInfo[b].playerName + "'s Tokens: " + (playerInfo[b].token + splitPlayerInfo[b].token));
                            }
                        }

                        Deck.shuffle(); // Shuffle Cards

                        // Continue Or Not After A Game 
                        System.out.println("Continue? Y or N");
                        String input = console.nextLine().toLowerCase();

                        if (input.equals("n")){
                            System.out.println("\nThanks For Playing!");
                            for (int c = 0; c < playerInfo.length - 1; c++){
                                System.out.println(playerInfo[c].playerName + ": " + playerInfo[c].token + " tokens.");
                            }

                            ender++;
                        } else if (input.equals("y")){
                            System.out.println("\nContinuing.");
                        } else {
                            System.out.println("\nInvalid Input: Assumed 'Y'. Continuing.");
                        }

                        // Clear Cards
                        for (int a1 = 0; a1 < playerInfo.length; a1++){
                            playerInfo[a1].cards.clear();
                        }
                    }
                }
            }
        }
    }


    /*
     *  cardValue - Finds Value Of One Card
     *  
     *  @param - String card : Card Inputed To See Value
     *  
     *  @return - int value : Value Of card
     */
    public static int cardValue (String card){
        int value = 0;

        if (card.startsWith("Two")){
            value = 2;
        }
        if (card.startsWith("Three")){
            value = 3;
        }
        if (card.startsWith("Four")){
            value = 4;
        }
        if (card.startsWith("Five")){
            value = 5;
        }
        if (card.startsWith("Six")){
            value = 6;
        }
        if (card.startsWith("Seven")){
            value = 7;
        }
        if (card.startsWith("Eight")){
            value = 8;
        }
        if (card.startsWith("Nine")){
            value = 9;
        }
        if (card.startsWith("Ten")){
            value = 10;
        }
        if (card.startsWith("Jack")){
            value = 11;
        }
        if (card.startsWith("Queen")){
            value = 12;
        }
        if (card.startsWith("King")){
            value = 13;
        }
        if (card.startsWith("Ace")){
            value = 1;
        }

        return value;
    }
}
