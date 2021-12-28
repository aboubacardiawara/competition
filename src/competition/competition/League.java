package competition.competition;

import java.util.*;
import competition.match.*;
import competition.display.*;
import competition.*;
import competition.exception.*;
import competition.observer.*;

/**
 * League is a subclass of Competition that simulates a competition where each
 * competitor plays against the others (home-and-away).
 *
 */
public class League extends Competition{

	public static final int VICTORY_POINT = 3;

	public League(List<Competitor> competitors, TypeOfMatch typeOfMatch, Displayer displayer, List<CompetitionObserver> observers){
		super(competitors, typeOfMatch, displayer, observers);
	}

	/** performs all the round of the League..
	 * each Competitor have to play with others Competitor.
	 * @param competitors {List<Competitor>} a list of competitors to play.
	*/
	public void play(List<Competitor> competitors){
		for (Competitor competitor1 : competitors) {
			for (Competitor competitor2 : competitors) {
				if(competitor1 != competitor2){
					playMatch(competitor1, competitor2);
				}
			}
		}
	}

}
