//Assig3_2 Guy Levi 209439306 and Gal Suissa 316581180
package assig3_2;

public class Gamer extends Thread {
	private int goodFlipsCounter;
    private final GamePlay gamePlay;
    
    // Constructor to initialize the player with the game
    public Gamer(GamePlay gamePlay) {
    	this.goodFlipsCounter = 0;
    	this.gamePlay = gamePlay;
    }
    
    // Method for the player to play the game
    public void play(){ 
    	while (!isInterrupted() && gamePlay.getNumOfRounds()< 10) { // Continuously play the game until interrupted or until 10 rounds are completed
    		if (gamePlay.flipCoin()) {
    			goodFlipsCounter++;
    		}
    		try {
    			Thread.sleep(1000); // Sleep for 1 second between flips
    		}
    		catch (InterruptedException e) {
    			interrupt();// Interrupted while sleeping
    			System.out.println(e);
			}
    	}
    }
    
 // Method to get the player's score
    public int getScore() {
    	return goodFlipsCounter;
    }
    //Run method to start playing the game
    public void run() {
    	play();
    }
}
