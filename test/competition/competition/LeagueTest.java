package competition.competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.competition.*;
import competition.*;
import competition.exception.*;

public class LeagueTest extends CompetitionTest
{

	@BeforeEach
	public void init() throws NumberOfCompetitorException{
		this.initCompetitor();
		this.competition = (League) new LeagueBuilder().setCompetitors(this.competitors).build();
            
	}


	@Test
	public void totalPointCheking(){
		
		int totalPoints = 0;
		int numberOfCompetitors = this.competitors.size();
		int expectedTotalPoints = (numberOfCompetitors-1) * numberOfCompetitors * this.competition.victoryPoints() ; // the sum of points of every competitor.
		this.competition.play();
		for (Competitor competitor : this.competitors) {
			totalPoints += competitor.getPoint();
		}

		assertEquals(totalPoints, expectedTotalPoints);
	}

	@Test
	public void numberOfCompetitorsChecking(){

		List<Competitor> competitorsList = new ArrayList<>(); /**empty list of competitors */
		/**Competition competition2 = new League(competitorsList); */
		assertThrows(
			NumberOfCompetitorException.class,
			() -> {
				this.competition = (League) new LeagueBuilder().setCompetitors(competitorsList).build();
			});
		competitorsList.add(new Competitor("REAL"));
		assertThrows(
			NumberOfCompetitorException.class,
			() -> {
				this.competition = (League) new LeagueBuilder().setCompetitors(competitorsList).build();
			});

		
	}

}
