package competition.rule;
import java.util.*;
import competition.*;
import competition.exception.*;

/**
 * these rules corresponds to competition where we select the top 2 competitor
 * of each group. They will participate to the final stage. 
 * Also, each group include 4 teams of 4 competitors.
 */
public class MasterRule16 implements MasterRule {
    
    /** Generate the groups from a list of competitor depending
	 * on the selection rule
	 * @param A list of 16 the competitors
	 * @return A list of 4 Groups of 4 competitors
	*/
    public List<Group> generateGroups(List<Competitor> competitors) throws NumberOfCompetitorException
    {
        List<Group> groups = new ArrayList<Group>();
        // the number of competitors should be exactly 16.
        if (competitors.size() != 16)
        {
            throw new NumberOfCompetitorException("the number of competitors should be exactly 16");
        }
        Iterator<Competitor> iter_competitors = competitors.iterator();
        for(int i=0; i<4; i++)
        {
            Group group = new Group();
            for(int j=0; j<4; j++)
            {
                group.addCompetitor(iter_competitors.next());
            }
            groups.add(group);
        }

        return groups;
    }

    /**
	 * return the number of team per group.
	 * @return
	 */
	public int getGroupSize()
    {
        return 16;
    }

    /**
	 * return the number of competitors of the final stage.
	 * @return
	 */
	public int getNbOfFinalist()
    {
        return 2*4;
    }

	/** Give the competitors who are selected for the final phase
	 	of the Master Competition depending on the selection rule
	@param List of the groups of this master Competition
	@return the selected Competitor for the final phase
	*/
	public List<Competitor> getFinalist(List<Group> groups)
    {
        List<Competitor> finalist_competitors = new ArrayList<>();
        List<Competitor> group_top_competitors;
        for (Group group : groups)
        {
            group_top_competitors = this.topCompetitors(group);
            for (Competitor c: group_top_competitors)
            {
                finalist_competitors.add(c);
            }
        }
        
        return finalist_competitors;
    }

    /**
     * @param g
     * @return
     */
    private List<Competitor> topCompetitors(Group g)
    {
        Iterator<Competitor> iter_competitors = g.getCompetitors().iterator();
        List<Competitor> top_competitors = new ArrayList<Competitor>();
        Competitor first_top_competitor = iter_competitors.next();
        Competitor second_top_competitor = iter_competitors.next();
        if (second_top_competitor.getPoint() > first_top_competitor.getPoint() )
        {
            Competitor competitor_temp = first_top_competitor;
            first_top_competitor = second_top_competitor;
            second_top_competitor = competitor_temp;
        }
        Competitor current_competitor;

        // look for the 2 competitor with the highest score.

        while (iter_competitors.hasNext())
        {
            current_competitor = iter_competitors.next();
            if (current_competitor.getPoint() > first_top_competitor.getPoint())
            {
                second_top_competitor = first_top_competitor;
                first_top_competitor = current_competitor;
            }
            else if (current_competitor.getPoint() > second_top_competitor.getPoint())
            {
                second_top_competitor = current_competitor;
            }
        }
        
        top_competitors.add(first_top_competitor);
        top_competitors.add(second_top_competitor);
        return top_competitors;
    }
}
