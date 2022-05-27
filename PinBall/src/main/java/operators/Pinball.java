package operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pinball {

	/** LOGGER */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * MÉTODO PARA COMENZAR EL JUEGO
	 * 
	 * @return
	 */

	public static int launchBall(int repeats) {

		int points = 0;

		for (int i = 0; i < repeats; i++) {

			LOGGER.trace("Interación del bucle: {}", i);

			int random = (int) (Math.random() * 10 + 1);

			LOGGER.trace("Número random: {}", random);

			if (random == 1) {
				points += 10;
			} else if (random == 2) {
				points += 20;
			} else if (random == 3) {
				points += 30;

			} else if (random == 4) {
				points += 40;
			} else if (random == 5) {
				points += 50;

			} else if (random == 6) {
				points += 60;
			} else if (random == 7) {
				points += 70;
			} else if (random == 8) {
				points -= 20;
			} else if (random == 9) {
				points = 0;
			} else if (random == 10) {
				points -= 50;
			} else {
				points += 0;
			}
			
			generateInfo(points, i);

		}

		return points;

	}

	/**
	 * @param points
	 * @param i
	 */
	private static void generateInfo(int points, int i) {

		System.out.println("----------------------------");
		System.out.println("* NUMERO DE TIRADA: " + (i + 1));
		System.out.println("* PUNTOS: " + points);
		System.out.println("----------------------------");
	}

}
