package competition.competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.exception.*;
import competition.competition.*;
import competition.*;

public abstract class CompetitionTest {
    protected List<Competitor> competitors;
	protected Competition competition;

	protected void initCompetitor(){
		this.competitors = new ArrayList<>();
		String name;
		String[] competitorsName = {
			"losc",
			"psg",
			"nantes",
			"marseille",
			"nice",
			"lyon",
			"reines",
			"lens",
			
			"ajaccio",
			"Troyes",
			"toulouse",
			"sochaux",
			"valencienne",
			"rennes",
			"reins",
			"nimes"
		};
		// creation of competitors
		for (int i=0; i<competitorsName.length; i++) {
			name = competitorsName[i];
			this.competitors.add(new Competitor(name));
		}

	}

    @Test
	public void matchWinnerShouldEarnVictoryPoints(){
        int victory_point = 3;
		Competitor competitor1 = this.competitors.get(0);
		Competitor competitor2 = this.competitors.get(1);
		int competitor1CurrentPoints = competitor1.getPoint();
		int competitor2CurrentPoints = competitor2.getPoint();

		// competitor1 and competitor2playMatch
		this.competition.playMatch(competitor1, competitor2);

		if (competitor1.getPoint() == competitor1CurrentPoints)
			assertEquals(competitor2.getPoint(), competitor2CurrentPoints + victory_point);
		else
			assertEquals(competitor2.getPoint(), competitor2CurrentPoints);
	}

    @Test
    public abstract void totalPointCheking();

	public abstract void numberOfCompetitorsChecking();
}
