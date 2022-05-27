package fpdualeveris;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import operators.Pinball;

/**
 * 
 * -- PINBALL TALLER JAVA
 * 
 * @author Pablo Alvarez Alvarez
 *
 */
public class FPDual {

	/** LOGGER */
	final static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * -- MÉTODO PRINCIPAL
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean carryOn = false;
		int points;

		
		System.out.println("-- PINBALL --");
		System.out.println("Instrucciones: \r\n" + "** 1€ -> 2 tiradas\r\n" + "** 2€ -> 5 tiradas\r\n" + "** 3€ -> 10 tiradas\r\n" + "** 5€ -> 15 tiradas\r\n"
		        + "-------------------\r\n" + "** OBJETIVO GANAR 100 PUNTOS! ");

		do {

			int repeats = 0;
			int money = 0;
			boolean stop1 = false;

			while (stop1 == false) {

				System.out.println("-- Para volver a jugar introduzca el dinero: ");

				
				try {
					money = escaner.nextInt();
					if (money == 1 || money == 2 || money == 3 || money == 5) {
						stop1 = true;
					} else {
						System.out.println("Cantidad erronea, vuelva a introducir la cantidad exacta: ");
					}

				} catch (InputMismatchException exception) {
					System.out.println("Valor no valido: " + exception);
				}
			}

			repeats = checkMoney(money);

			/*
			 * Guardamos los puntos en una variable
			 */
			points = Pinball.launchBall(repeats);

			/*
			 * Comprobamos si tiene suficientes puntos para ganar
			 */
			check(points);

			System.out.println("¿VUELVES A JUGAR?");
			String answer = sc.nextLine();

			if (answer.equalsIgnoreCase("Si")) {
				carryOn = true;
			} else if (answer.equalsIgnoreCase("No")) {
				carryOn = false;
				System.out.println("FIN DEL JUEGO");
			}

		} while (points <= 100 && carryOn == true);

	}

	/**
	 * Comprobamos cuantas tiradas tiene con el dinero introducido
	 * 
	 * @return repeat
	 */
	private static int checkMoney(int money) {
		int repeats = 0;

		if (money == 1) {
			repeats = 2;
		} else if (money == 2) {
			repeats = 5;

		} else if (money == 3) {
			repeats = 10;
		} else if (money == 5) {
			repeats = 15;
		}

		return repeats;
	}

	/**
	 * Comprobamos si tiene los puntos para ganar
	 * 
	 * @param points
	 */
	private static void check(int points) {

		// Condiciones para ganar
		if (points >= 100) {

			LOGGER.info("PUNTOS: {}", points);

			System.out.println("HA CONSEGUIDO EL OBJETIVO PINBALL!!");

		} else {

			LOGGER.info("PUNTOS: {}", points);
			System.out.println("FIN DEL JUEGO");
		}
	}

}
