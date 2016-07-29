package black_jack;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author atdp-11 Alyssa Lo
 *
 */
public class BlackJackPlayer {
    // fields
    public int token;
    public ArrayList <String> cards = new ArrayList <String>();
    public String playerName;
    public int tokenBet;

    /*
     *  BlackjackPlayer - Constructor Method That Prints Out Player's Statuses
     *  
     *  @param - name : Name Of Player
     *          cardsIn : Cards That Player Has
     *  
     *  @return - none 
     */
    public BlackJackPlayer(String name, int token) {

        // field playerName = name 
        playerName = name;

        // field token = token
        this.token = token;
    }

    /*
     *  BlackjackPlayer - Constructor Method That Prints Out Dealer's Statuses
     *  
     *  @param - name : Dealer
     *          cardsIn : Cards That Dealer Has
     *  
     *  @return - none 
     */
    public BlackJackPlayer(String name) {

        // field playerName = name 
        playerName = name;

    }

    /*
     *    BlackjackPlayer - Constructor Method for Split Player
     *  
     *  @param - none
     *  
     *  @return - none  
     */
    public BlackJackPlayer(){
        token = 0;
    }

    /*
     *  toString - Method That Tells How To Print BlackJackPlayer Objects
     * 
     *  @param - none
     *  
     *  @return - format : format Of How Object Is Printed
     */
    public String toString() {
        String format = playerName + " (" + token + ")" + " : ";

        for(int i = 0; i < cards.size(); i++){
            format = format + cards.get(i) + "   ";
        }

        return format;
    }

}
