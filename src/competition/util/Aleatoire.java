package competition.util;

import java.util.Random;

/**
 * generate a random integer from a certain intervalle.
 * @author Diawara
 *
 */
public class Aleatoire {
	/**
	 * allow to give a random integer beetween inf and sup.
	 * Be carreful, inf and sup are included. [inf, sup]
	 * @param inf the left born of the interval
	 * @param sup the right born
	 * @return a random interger.
	 */
	public static int genererInt(int inf, int sup) {
		Random random = new Random();
		int randomInt = inf + random.nextInt(sup-inf+1);

		return randomInt;
	}

}
