package competition.observer;
import competition.display.Displayer;
import competition.match.*;

/**
 * @author diawara
 * @author abdoulkader
 */
public abstract class CompetitionObserver 
{
	protected String name;
    protected Displayer displayer;
	
	public CompetitionObserver(String name)
	{
		this.name = name;
	}

	public CompetitionObserver(String name, Displayer displayer)
	{
		this.name = name;
		this.displayer = displayer;
	}


	
    public abstract void reactToMatch(MatchEvent e);

    public String toString()
    {
    	return this.name;
    }
}
