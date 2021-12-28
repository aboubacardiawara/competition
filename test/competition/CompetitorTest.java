package competition;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CompetitorTest {

	@Test
	public void addPointShouldIncreaseCompetitorPoints(){
		Competitor competitor = new Competitor("Losc");
		// precondition
		assertTrue(competitor.getPoint() == 0);

		// add point
		competitor.addPoint(12);
		assertEquals(competitor.getPoint(), 12);

		competitor.addPoint(16);
		assertEquals(competitor.getPoint(), 12+16);
	}

}
