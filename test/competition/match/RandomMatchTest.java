package competition.match;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import competition.*;

public abstract class RandomMatchTest extends MatchTest {

    @Test
    public void OnlyOneCompetitorCanWin()
    {
        TypeOfMatch typeOfMatch = new RandomMatch();
		Competitor winner = typeOfMatch.play(this.c1, this.c2);
		if(winner == this.c1){
			assertNotSame(winner, this.c2);
		}
		else{
			assertNotSame(winner, this.c1);
		}
    }

}