package competition.rule;
import java.util.*;


import competition.*;
import competition.exception.*;

/**
 * This rule concern master with only 4 competitors.
 * The best competitor of each group will play the final stage.  
 */
public class MasterRule4 implements MasterRule {
      /** Generate the groups from a list of competitor depending
	 * on the selection rule
	 * @param A list of all the competitors
	 * @return A list of created Group
	*/
    public List<Group> generateGroups(List<Competitor> competitors) throws NumberOfCompetitorException
    {
        int expectedSize = 4;
        int nbOfCompetitorsPerGroup = 2;
        List<Group> groups = new ArrayList<Group>();
        // the number of competitors should be exactly 4.
        if (competitors.size() != expectedSize)
        {
            throw new NumberOfCompetitorException("the number of competitors should be exactly " + expectedSize);
        }
        Iterator<Competitor> iter_competitors = competitors.iterator();
        for(int i=0; i<(int) expectedSize / nbOfCompetitorsPerGroup; i++)
        {
            Group group = new Group();
            for(int j=0; j<nbOfCompetitorsPerGroup; j++)
            {
                group.addCompetitor(iter_competitors.next());
            }
            groups.add(group);
        }

        return groups;
    }


	/** 
	 * Give the competitors who are selected for the final phase
	 * of the Master competition. In each group, only one competitor will
     * be selected. The one with the highest point. 
	 * @param List of the groups of this master Competition
	 * @return the selected Competitor for the final phase
	*/
	public List<Competitor> getFinalist(List<Group> groups)
    {
        List<Competitor> finalist = new ArrayList<>();
        List<Competitor> groupCompetitors;
        for (Group group : groups)
        {
            groupCompetitors = group.getCompetitors();
            Competitor competitor1 = groupCompetitors.get(0);
            Competitor competitor2 = groupCompetitors.get(1);
            if (competitor1.getPoint() > competitor2.getPoint()) 
                finalist.add(competitor1);
            else 
                finalist.add(competitor2);
        }

        return finalist;
    }

    /**
	 * return the number of team per group.
	 * @return
	 */
	public int getGroupSize()
    {
        return 4;
    }

    /**
	 * return the number of competitors of the final stage.
	 * @return
	 */
	public int getNbOfFinalist()
    {
        return 2;
    }
}
