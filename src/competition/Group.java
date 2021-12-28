package competition;
import java.util.*;

public class Group
{

	/**the group competitors*/
    private List<Competitor> competitors;

	/**
     * Constructor. Create a new group stage.
     * Create a new Group using a list of competitor.
     */
	public Group()
    {
        this.competitors = new ArrayList<Competitor>();
    }

	/**
	 * add a new competitor to the group.
	 * @param c {Competitor} a new competitor to add.
	 */
    public void addCompetitor(Competitor c)
    {
        this.competitors.add(c);
    }

	
    /**
     * allow to get all the competitor of the group
     * @return A list of the competitor of this Group
     */
    public List<Competitor> getCompetitors() 
    {
        return this.competitors;
    }
}
