package competition.rule;
import java.util.*;
import competition.*;
import competition.exception.*;
import competition.util.*;

/**
 * these rules corresponds to competition where we have 24 competitors. 
 * They will be divided into 3 groups of 8 competitors .
 * For the final stage, the 2 top competitor of each group will be selected 
 * and the 2 best thirds of all group combined. 
 */
public class MasterRule24 implements MasterRule {

    /** Generate the groups from a list of competitors depending
		on the selection rule
	@param A list of 24 competitors
	@return A list of 3 Groups of 8 competitors
	*/
    public List<Group> generateGroups(List<Competitor> competitors) throws NumberOfCompetitorException
    {
        List<Group> groups = new ArrayList<Group>();
        // the number of competitors should be exactly 24.
        if (competitors.size() != 24)
        {
            throw new NumberOfCompetitorException("the number of competitors should be exactly 24.");
        }

        Iterator<Competitor> iter_competitors = competitors.iterator();
        for(int i=0; i<3; i++)
        {
            Group group = new Group();
            for(int j=0; j<8; j++)
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
        return 24;
    }

    /** Give the competitors who are selected for the final phase
	 	of the Master Competition depending on the selection rule
	@param List of the groups of this master Competition
	@return the selected Competitor for the final phase
	*/
	public List<Competitor> getFinalist(List<Group> groups)
    {   
        
        List<Competitor> finalist = new ArrayList<Competitor>();

        /** A list of the third competitor of each group */
        List<Competitor> thirdCompetitors = new ArrayList<Competitor>(); 
        
        for(Group group: groups)
        {   
            List<Competitor> topCompetitors = new ArrayList<Competitor>();
            topCompetitors= bestNcompetitors(group.getCompetitors(), 3);
            for(int i=0; i<2; i++){
                finalist.add(topCompetitors.get(i));
            }

            thirdCompetitors.add(topCompetitors.get(2)); /**Third of this group */

        }

        List<Competitor> thirdtop2Competitors = new ArrayList<Competitor>();
        thirdtop2Competitors= bestNcompetitors(thirdCompetitors, 2);
        for(int i=0; i<2; i++){
            finalist.add(thirdtop2Competitors.get(i));
        }
        return finalist;
    	
    }

    /**
	 * return the number of competitors of the final stage.
	 * @return
	 */
	public int getNbOfFinalist()
    {
        return 8;
    }

    /** Give the top n of a list of competitors(top 2 or top3 ..)
    */
    public List<Competitor> bestNcompetitors(List<Competitor> competitors, int n)
    {
        Map<Competitor, Integer> competitors_points = new HashMap<>();
        Map<Competitor, Integer> competitors_descending_point = new HashMap<>(); 
        List<Competitor> finalist = new ArrayList<Competitor>();

        for (Competitor competitor : competitors) {
            competitors_points.put(competitor, competitor.getPoint());
        }
            
        /** Competitors are  sorted with their number of points*/
         competitors_descending_point = MapUtil.sortByDescendingValue(competitors_points);
    
         for(int i=0; i<n; i++){
            /** select the top n of this group */

            Competitor finalist_competitor; /** One of the finalist competitor */
            finalist_competitor = (Competitor) competitors_descending_point.keySet().toArray()[i];
            finalist.add(finalist_competitor);
        }
        return finalist;
    }
}