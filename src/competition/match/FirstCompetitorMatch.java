/**
 * 
 */
package competition.match;

import competition.Competitor;
import competition.util.Aleatoire;

/**
 * @author diawara
 *
 */
public class FirstCompetitorMatch implements TypeOfMatch {

	/** manage a typeOfMatch beetwen two competitors.
	 * its return randomly one team which will represents the typeOfMatch's winner.
	 * We have necessarily one winner.
	 * @param c1 {Competitor}, a competitor.
 	 * @param c2 {Competitor}, a competitor.
	 * @return {Competitor} the winner
	*/
	public Competitor play(Competitor c1, Competitor c2){
		return c1;
	}

}
