package competition.competition;
import java.util.*;
import competition.match.*;
import competition.observer.BookMaker;
import competition.observer.CompetitionObserver;
import competition.observer.Journalist;
import competition.*;
import competition.util.*;
import competition.display.*;
import competition.exception.*;

public abstract class CompetitionBuilder 
{
    
    /** allows to display a messgae*/
	protected Displayer displayer = new FakeDisplayer();//new StdDisplayer();
	/**typeOfMatch (randomWinner,...)*/
	protected TypeOfMatch typeOfMatch = new RandomMatch();;
	/**a list of competition's compitetors */
	protected List<Competitor> competitors = new ArrayList<>();
	/**Competition listeners */
    protected List<CompetitionObserver> observers = new ArrayList<>();
    
    /** constructor
	 * @param competitors {List<Competitor>} a list of competitors.
     * @throws NumberOfCompetitorException if the numbers of competitors is not adapted to the competition,
	 * an error will occur;
    */
    public CompetitionBuilder setCompetitors(List<Competitor> competitors)  throws NumberOfCompetitorException {
        if (competitors.size() < 2) {
			throw new NumberOfCompetitorException("The number of team must be at least 2");
		}
        this.competitors = competitors;
        return this;
    }

    public CompetitionBuilder setDisplayer(Displayer displayer) {
        this.displayer = displayer;
        return this;
    }

    /**
     * @param typeOfMatch {TypeOfMatch} a competition typeOfMatch type.
     * @return
     */
    public CompetitionBuilder setTypeOfMatch(TypeOfMatch typeOfMatch) {
        this.typeOfMatch = typeOfMatch;
        return this;
    }

    public CompetitionBuilder setObservers(List<CompetitionObserver> observers) {
        this.observers = observers;
        return this;
    }
    /**
     * Competition builder
     * @return
     */
    public abstract Competition build();
}