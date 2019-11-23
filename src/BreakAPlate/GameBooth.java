package BreakAPlate;
/**
 * GameBooth class.
 */

import java.lang.Math;

public class GameBooth {
	private double cost;
	private String FIRSTPRIZE, CONSOLATIONPRIZE;


	/**
	 * constructor
	 * pre: none
	 * post: A GameBooth object created.
	 * The cost and prizes are set.
	 */
	public GameBooth(double charge, String p1, String p2) {
		cost = charge;
		FIRSTPRIZE = p1;
		CONSOLATIONPRIZE = p2;
	}


	/**
	 * Game is played and prize awarded.
	 * pre: none
	 * post: Player had three tries. Player successful all
	 * three times received the first prize. A consolation
	 * prize has been awarded otherwise.
	 */
	public String start() {
		int toss;
		int successes = 0;

	 	/* play game */
	 	for (int i = 0; i < 3; i++) {	//player gets three tries
	 		toss = (int)(2 * Math.random() + 1);
	 		if (toss == 1) {
	 			successes += 1;			//1 is a successful toss
	 		}
	 	}

	 	/* award prize */
	 	if (successes == 3) {
	 		return(FIRSTPRIZE);
	 	} else {
	 		return(CONSOLATIONPRIZE);
	 	}
	}


	/**
	 * Returns the cost to play the game.
	 * pre: none
	 * post: Cost of the game has been returned.
	 */
	public double getCost() {
	 	return(cost);
	}
}