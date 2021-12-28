package competition.match;

import competition.*;
/**
 * This class competition provides a skeletal implementation of the TypeOfMatch class.
 */
public interface TypeOfMatch {
	/** manage a typeOfMatch beetwen two competitors.
	 * We have necessarily one winner.
	 * @param c1 {Competitor}, a competitor.
 	 * @param c2 {Competitor}, a competitor.
	 * @return {Competitor} the winner
	*/
	public Competitor play(Competitor c1, Competitor c2);

}
