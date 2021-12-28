package competition.competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import competition.competition.*;
import competition.*;
import competition.exception.*;

public class TournamentTest extends CompetitionTest
{		

	private int number_of_match(int number_of_team) {
		int nbr = 0;
		for (int i=0; i<(int) (Math.log(number_of_team) / Math.log(2)); i++) {
			nbr += Math.pow(2, i);
		}
		return nbr;
	}

	@BeforeEach
	public void init() throws NumberOfCompetitorException
	{
		this.initCompetitor();
		this.competition = (Tournament) new TournamentBuilder().setCompetitors(this.competitors).build();
	}

	
	@Test
	public void totalPointCheking() 
	{

		int numberOfMatch = this.number_of_match(this.competitors.size()); // log(8, base=2)
		int expectedTotalPoint = numberOfMatch * this.competition.victoryPoints();
		int totalPoints = 0;
		this.competition.play();
		for (Competitor competitor : this.competitors) {
			totalPoints += competitor.getPoint();
		}

		assertEquals(totalPoints, expectedTotalPoint);
	}

	@Test
	public void winnerTotalPointCheking(){
		//int numberOfMatch = this.number_of_match(this.competitors.size()); // log(8, base=2)
		int numberOfRound = (int) (Math.log(this.competitors.size()) / Math.log(2));
		int expectedTotalPoint = numberOfRound * this.competition.victoryPoints();
		this.competition.play();
		assertEquals(this.competition.getWinner().getPoint(), expectedTotalPoint);
	}
 
	@Test
	public void numberOfCompetitorsChecking(){

		List<Competitor> competitorsList = new ArrayList<>(); /**empty list of competitors */
		/**Competition competition2 = new League(competitorsList); */
		assertThrows(
			NumberOfCompetitorException.class,
			() -> {
				this.competition = (Tournament) new TournamentBuilder().setCompetitors(competitorsList).build();
				
			});
		competitorsList.add(new Competitor("REAL")); /** 1 competitor added to the list. */

		assertThrows(
			NumberOfCompetitorException.class,
			() -> {
				this.competition = (Tournament) new TournamentBuilder().setCompetitors(competitorsList).build();
			});

		
	}

}
