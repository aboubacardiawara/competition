package competition.competition;
import java.util.*;
import competition.match.*;
import competition.observer.*;
import competition.*;
import competition.util.*;
import competition.display.*;
import competition.exception.*;

/**
 * This class competition provides a skeletal implementation of the Competition class.
 */
public abstract class Competition 
{
	/** allows to display a messgae*/
	protected Displayer displayer;
	/**typeOfMatch (randomWinner,...)*/
	protected TypeOfMatch typeOfMatch;
	/**a list of competition's compitetors */
	protected final List<Competitor> competitors;
	/**Competition listeners */
	protected List<CompetitionObserver> observers;

	public Competition(List<Competitor> competitors, TypeOfMatch typeOfMatch, Displayer displayer, List<CompetitionObserver> observers){
		this.competitors = competitors;
		this.typeOfMatch = typeOfMatch;
		this.displayer = displayer;
		this.observers = observers;
	}

	public List<Competitor> getCompetitors() {
		return this.competitors;
	}

	public void addObserver(CompetitionObserver o)
	{
		this.observers.add(o);
	}

	public void removeObserver(CompetitionObserver o)
	{
		this.observers.remove(o);
	}

	/** manage the progress of all matches of the competition.
	*/
	public void play() {
		this.play(this.competitors);
		this.display(); 
	}

	/**
	 * return the victory points corresponding to the competition.
	 * when two competitor play a match, the winner will earn vicotory points.
	 * @return {int} the victory points.
	 */
	protected int victoryPoints() {
		return 3;	
	}

	/** performs one round of the Competition..
	 * @param competitors {List<Competitor>} a list of competitors to play.
	*/
	protected abstract void play(List<Competitor> competitors);

	/**manage the progress of a typeOfMatch beetwen two competitor
	 * @param c1 {Competitor}, a competitor.
	 * @param c2 {Competitor}, a competitor.
    */
	public void playMatch(Competitor c1, Competitor c2)
	{
		Competitor winner = this.typeOfMatch.play(c1,c2);
		winner.addPoint(this.victoryPoints());
		MatchEvent e = new MatchEvent(c1, c2, winner);
		Iterator<CompetitionObserver> iterOberver = this.observers.iterator();
		while (iterOberver.hasNext())
		{
			iterOberver.next().reactToMatch(e);
		}
	}

	/** return the ranking of competition's competitors.
	 * @return {Map} teams classified according
	 * to their points.
	*/
	public Map<Competitor, Integer> ranking()
	{
		Map<Competitor, Integer> competitors_points = new HashMap<>();
		for (Competitor competitor : this.competitors) {
			competitors_points.put(competitor, competitor.getPoint());
		}

		return MapUtil.sortByDescendingValue(competitors_points);
	}

	/** return the competition winner.
	 * the winner has the highest points at the end of competition.
	 * @return {competitor} competition's winner
	*/
	public  Competitor getWinner() {
		Competitor winner;
		winner = (Competitor) this.ranking().keySet().toArray()[0];
		return winner;
	}

	private void display() {
		Map<Competitor, Integer> competitors_points;

		competitors_points = this.ranking();
		this.displayer.displayMsg("+ Ranking");
		int rank = 0;
		for (Competitor competitor : competitors_points.keySet()) {
			this.displayer.displayMsg((++rank) + ") " + competitor + " -> " + competitor.getPoint());
		}

		this.displayer.displayMsg("\n");
	}

}
