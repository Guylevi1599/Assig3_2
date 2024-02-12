//Assig3_2 Guy Levi 209439306 and Gal Suissa 316581180
package assig3_2;

public class Judge extends Thread {
	private final GamePlay gamePlay;

	// Constructor to initialize the judge with the game
	public Judge(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
    }
	// Run method to simulate the judge's actions
	public void run() {
		while(!isInterrupted()) { // Continuously execute judge's actions until interrupted
			synchronized (gamePlay) {
				gamePlay.makeCoinAvail(false); // Make the coin unavailable for 1 second
				try {
					Thread.sleep(1000); 
					gamePlay.makeCoinAvail(true); // Makes the coin available for half a second
					Thread.sleep(500);  
				} catch (InterruptedException e) {
					interrupt();
				}
			}
		}
	}
}
