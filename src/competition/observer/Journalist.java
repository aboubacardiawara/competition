package competition.observer;

import competition.Competitor;
import competition.display.Displayer;
import competition.display.StdDisplayer;
import competition.match.MatchEvent;

/**
 * @author diawara
 * @author abdoulkader
 */
public class Journalist extends CompetitionObserver
{

    private String name;

    public Journalist(String name)
    {
    	super(name, new StdDisplayer());
    }

    public Journalist(String name, Displayer displayer)
    {
    	super(name, displayer);
    }

    public void reactToMatch(MatchEvent e)
    {
        Competitor c1, c2, w;
        c1 = e.getCompetitor1();
        c2 = e.getCompetitor2();
        w = e.getWinner();

        this.displayer.displayMsg(c1 + " vs " + c2 + " -> " + w + "(" + this.name + ")");
    }
}
