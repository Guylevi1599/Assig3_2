//Assig3_2 Guy Levi 209439306 and Gal Suissa 316581180
package assig3_2;

import java.util.Random;

public class GamePlay {
	private boolean coin_available_;
    private int rounds_counter_;
    
 // Constructor to initialize the gameplay
    public GamePlay () { 
    	coin_available_=false;
    	rounds_counter_=0;
    }
    
 // Method to make the coin available or unavailable
    public synchronized void makeCoinAvail(boolean val) {
    	if (val) {
    		notifyAll(); // Notifies all waiting threads and sets the coin available
    		coin_available_=true;	
    	}
    	else {
    		coin_available_=false; // Sets the coin unavailable
		}
    }
    
 // Method to flip the coin
    public synchronized boolean flipCoin() {
    	while (!coin_available_) {
    		try {
    			System.out.println(Thread.currentThread().getName() + " is waiting for coin");
                wait(); // Waits until the coin becomes available
    		}
    		catch (InterruptedException e) {
				System.out.println(e);		
				}
    	}
    	
    	System.out.println(Thread.currentThread().getName() + " is flipping coin");
    	coin_available_=false; // Sets the coin unavailable during flipping
    	rounds_counter_++;  // Increments the rounds counter
    	Random random = new Random();
        boolean result = random.nextBoolean();
        makeCoinAvail(true); // Makes the coin available again
        
        return result;
    }
 // Method to get the number of rounds
    public int getNumOfRounds() {
        return rounds_counter_;
    }
}
