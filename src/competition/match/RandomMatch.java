package competition.match;

import competition.*;
import competition.util.*;

/** perform a random typeOfMatch
 * @author Aboubacar DIAWARA and AbdoulKder MOUSSA MOHAMED.
 * @version 1.1
 */
public class RandomMatch implements TypeOfMatch {

	/** manage a typeOfMatch beetwen two competitors.
	 * its return randomly one team which will represents the typeOfMatch's winner.
	 * We have necessarily one winner.
	 * @param c1 {Competitor}, a competitor.
 	 * @param c2 {Competitor}, a competitor.
	 * @return {Competitor} the winner
	*/
	public Competitor play(Competitor c1, Competitor c2){
		// c1 id is 1, c2 id is 2.
		int inf=1, sup=2;
		int winnerId = Aleatoire.genererInt(inf, sup);

		if (winnerId == 1)
			return c1;
		return c2;
	}
}
