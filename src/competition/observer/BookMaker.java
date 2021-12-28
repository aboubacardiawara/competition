package competition.observer;
import competition.match.*;
import java.util.Map;
import competition.Competitor;

import java.util.HashMap;
import competition.display.Displayer;
import competition.display.StdDisplayer;


/**
 * @author diawara
 * @author abdoulkader
 */
public class BookMaker extends CompetitionObserver
{
    private int max_cote;
    private int min_cote;

    private Map<Competitor, Integer> competitors;
    /**insert Journalist propertis here 
     * 
     * - Name ??? est ce necessaire.
     * - <equipe, cote>
     */
    public BookMaker(String name)
    {
    	super(name, new StdDisplayer());
        this.max_cote = 10; 
        this.min_cote = 1;
        this.competitors = new HashMap<>();
    }

    public BookMaker(String name, Displayer displayer)
    {
    	super(name, displayer);
        this.max_cote = 10; 
        this.min_cote = 1;
        this.competitors = new HashMap<>();
    }
    
    public void updateCotes(Competitor winner, Competitor looser)
    {
        
    	if (! this.competitors.containsKey(winner))
    	{
    		this.competitors.put(winner, (this.max_cote + this.min_cote)/2);    		
    	}
    	

        if (! this.competitors.containsKey(looser))
        {
        	this.competitors.put(looser, (this.max_cote + this.min_cote)/2);        	
        }
        

    	int winner_previous_odd = this.competitors.get(winner);
        int looser_previous_odd = this.competitors.get(looser);
        
        this.displayer.displayMsg(winner + "(" + winner_previous_odd + " -> " + winnerNewOdds(winner) + ")");
        this.displayer.displayMsg(looser + "(" + looser_previous_odd + " -> " + looserNewOdds(looser) + ")");
        
        
    }

    public void reactToMatch(MatchEvent e)
    {
        Competitor winner, looser;
        winner = e.getWinner();
      
        // connaitre le gagnant, le perdant
        if (winner == e.getCompetitor1()) looser = e.getCompetitor2();
        else looser = e.getCompetitor1();
        
        this.updateCotes(winner, looser);

    }

    public int winnerNewOdds(Competitor winner){

        int winner_previous_odd = this.competitors.get(winner);
        // la cote du gagnant diminue
        int winner_new_odd = Math.max(this.min_cote, winner_previous_odd-1);
        this.competitors.put(winner, winner_new_odd);
        return winner_new_odd;
    }

    public int looserNewOdds(Competitor looser){

        int looser_previous_odd = this.competitors.get(looser);
        // la cote du perdant augmente
        int looser_new_odd = Math.min(this.max_cote, looser_previous_odd+1);
        this.competitors.put(looser, looser_new_odd);

        return looser_new_odd;
    }

    public int getCompetitorOdds(Competitor c){
        return (int) this.competitors.get(c);
    }

}
