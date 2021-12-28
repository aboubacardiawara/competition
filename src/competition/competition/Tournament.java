package competition.competition;

import java.util.*;
import competition.match.*;
import competition.*;
import competition.display.Displayer;
import competition.exception.*;
import competition.observer.*;
/**
 * Tournament is a subclass of Competition that simulates a competition where only
 * typeOfMatch winner can play the next round. Loosers being eliminated.
 */
public class Tournament extends Competition{

	public static final int VICTORY_POINT = 3;

	/** constructor
	 * 
	*/

	public Tournament(List<Competitor> competitors, TypeOfMatch typeOfMatch, Displayer displayer, List<CompetitionObserver> observers) throws NumberOfCompetitorException{
		super(competitors, typeOfMatch, displayer, observers);

		int numberOfCompetitor = this.competitors.size();
		if (! this.isPowerOfTwo(numberOfCompetitor) )
		{
			throw new NumberOfCompetitorException("the number of competitor must be a power of 2 ");
		}
	}

	/**
	 * check if the giving value is a power of 2.
	 */
	private boolean isPowerOfTwo(int numberOfCompetitor)
	{
		double sqrt_number_of_competitor =  Math.log(numberOfCompetitor) / Math.log(2);
		return (int) sqrt_number_of_competitor == sqrt_number_of_competitor;
	}



	/** performs one round of the Tournament..
	 * @param competitors {List<Competitor>} a list of competitors to play.
	*/
	public void play(List<Competitor> competitors){


		Competitor competitor1;
		Competitor competitor2;
		List<Competitor> nextRoundCompetitors;

		if(competitors.size() == 1){ /*The Tournament is finished, we have found the winner*/
			//
		}
		else{
			nextRoundCompetitors = new ArrayList <Competitor>();
			Collections.shuffle(competitors); /* Randomly mix the Competitors list*/
			int numberOfteam = competitors.size();
			for(int i=0; i<numberOfteam; i+=2){
				competitor1 = competitors.get(i);
				competitor2 = competitors.get(i+1);
				playMatch(competitor1, competitor2);

				if (competitor1.getPoint() > competitor2.getPoint()){
					nextRoundCompetitors.add(competitor1);
				}
				else{
					nextRoundCompetitors.add(competitor2);
				}
			}
			play(nextRoundCompetitors);
		}
	}
}
