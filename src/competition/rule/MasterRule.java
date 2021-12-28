package competition.rule;
import java.util.*;
import competition.*;
import competition.exception.*;

public interface MasterRule {

	/** Generate the groups from a list of competitor depending
	 * on the selection rule
	 * @param A list of all the competitors
	 * @return A list of created Group
	*/
    public List<Group> generateGroups(List<Competitor> competitors) throws NumberOfCompetitorException;


	/** 
	 * Give the competitors who are selected for the final phase
	 * of the Master Competition depending on the selection rule
	 * @param List of the groups of this master Competition
	 * @return the selected Competitor for the final phase
	*/
	public List<Competitor> getFinalist(List<Group> groups);

	/**
	 * return the number of team per group.
	 * @return
	 */
	public int getGroupSize();

	/**
	 * return the number of competitors of the final stage.
	 * @return
	 */
	public int getNbOfFinalist();
	
}