package competition.competition;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import competition.competition.*;
import competition.*;
import competition.exception.*;
import competition.rule.*;

class MasterTest extends CompetitionTest
{
    private MasterRule masterRule;

    @BeforeEach
	public void init() throws NumberOfCompetitorException 
    {
		this.initCompetitor();
        this.masterRule = new MasterRule16();
		this.competition = (Master) new MasterBuilder().setMasterRule(this.masterRule).setCompetitors(this.competitors).build();
	}

    private int groupStageTotalExpectedPoints()
    {
        int numberOfGroup  = ((Master) this.competition).getGroups().size();
        int numberOfCompetitorsPerGroup = 4;
		int oneGroupExceptedPoint = (numberOfCompetitorsPerGroup-1) * numberOfCompetitorsPerGroup * this.competition.victoryPoints() ;
        int expectedTotalPoints = oneGroupExceptedPoint * numberOfGroup;
		
		return expectedTotalPoints;
    }

    private int finalStageTotalExpectedPoints()
    {
        
        int nbOfCompetitors = this.masterRule.getNbOfFinalist();
        int numberOfMatch = this.number_of_match(nbOfCompetitors);
        int expectedTotalPoints = numberOfMatch * this.competition.victoryPoints();
		
		return expectedTotalPoints;
    }

    private int totalPoints()
    {
        int totalPoints = 0;
        
		for (Competitor competitor : this.competitors) {
			totalPoints += competitor.getPoint();
		}
        return totalPoints;
    }

    private int number_of_match(int number_of_team) {
		int nbr = 0;
		for (int i=0; i<(int) (Math.log(number_of_team) / Math.log(2)); i++) {
			nbr += Math.pow(2, i);
		}
		return nbr;
	}

    

    @Test
    public void totalPointCheking()
    {
        int expectedGroupStagePoint = this.groupStageTotalExpectedPoints();
        int expectedFinalStagePoint = this.finalStageTotalExpectedPoints();
        int expectedPoint = expectedFinalStagePoint + expectedGroupStagePoint;

        int points = this.totalPoints();
        // precondition
        assertEquals(0, points); // no typeOfMatch has been playing yet.

        // play the complete competition
		this.competition.play();
        points = this.totalPoints();

        // final condition
        assertEquals(expectedPoint, points);
    }

    @Test
    public void groupStageTotalPointCheking()
    {
        int expectedPoint = this.groupStageTotalExpectedPoints();
        int points = this.totalPoints();
        // precondition
        assertEquals(0, points); // no typeOfMatch has been playing yet.

        // play group stage
		((Master) this.competition).playGroupStage();
        points = this.totalPoints();

        // final condition
        assertEquals(expectedPoint, points);
    }

    @Test
	public void numberOfCompetitorsChecking(){

		List<Competitor> competitorsList = new ArrayList<>(); /**empty list of competitors */
		/**Competition competition2 = new League(competitorsList); */
		assertThrows(
			NumberOfCompetitorException.class,
			() -> {
				this.competition = (Master) new MasterBuilder().setCompetitors(competitorsList).build();
			});
		competitorsList.add(new Competitor("REAL")); /** 1 competitor added to the list. */

		assertThrows(
			NumberOfCompetitorException.class,
			() -> {
				this.competition = (Master) new MasterBuilder().setCompetitors(competitorsList).build();
			});

		
	}

}