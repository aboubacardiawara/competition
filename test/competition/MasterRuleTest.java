package competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.competition.*;
import competition.rule.*;
import competition.*;

public abstract class MasterRuleTest {
    protected List<Competitor> competitors;
    protected List<Group> groups;
	protected MasterRule rule;
    /**
     * initialize the list of competitors.
     */
	@BeforeEach
	protected void initCompetitorAndGroups(){
		this.competitors = new ArrayList<>();
		String name;
		String[] competitorsName = {
			"losc",
			"psg",
			"nantes",
			"marseille",
			"nice",
			"lyon",
			"arras",
			"lens",
			
			"ajaccio",
			"Troyes",
			"toulouse",
			"sochaux",
			"valencienne",
			"rennes",
			"reims", 
			"nimes"
		};
        // creation of competitors
		for (int i=0; i<competitorsName.length; i++) {
			name = competitorsName[i];
			this.competitors.add(new Competitor(name));
		}
		this.initMasterRule();
		this.groups = new ArrayList<Group>();
    }
	public abstract void initMasterRule();

    @Test
    public abstract void numberOfGroupsTest();

	@Test
	public abstract void theNumberOfCompetitorsShouldBeRespected();
     
}
