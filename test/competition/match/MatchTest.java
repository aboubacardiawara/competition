package competition.match;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import competition.*;

public abstract class MatchTest {
	protected Competitor c1;
	protected Competitor c2;

	@BeforeEach
	void init()
	{
		this.c1 = new Competitor("Losc");
		this.c2 = new Competitor("Psg");
	}

    @Test
    public abstract void OnlyOneCompetitorCanWin();

}
