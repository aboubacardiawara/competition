package competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import competition.rule.*;
import competition.exception.*;

public class MasterRule16Test extends MasterRuleTest
{
    public void initMasterRule()
    {
        this.rule = new MasterRule16();
    }

    @Test
    public void numberOfGroupsTest()
    {
        // pour un effectif de 16, constituer 4 poules, 4 par poule.
        
        // precondition
        assertEquals(16, this.competitors.size());
        assertEquals(0, this.groups.size());

        // envoie de message.
        try {
            this.groups = this.rule.generateGroups(this.competitors);
        } catch (Exception e) {
            //do nothing
        }

        // expection
        assertEquals(4, this.groups.size());
        assertEquals(16, this.competitors.size());

        assertEquals(8, this.rule.getFinalist(this.groups).size()); /** 8 = top 2 competitors of 4 groups*/
    }

    @Test
	public void theNumberOfCompetitorsShouldBeRespected()
	{
		List<Competitor> competitors = this.competitors;
        competitors.add(new Competitor("retardateur"));
        int acceptedNumber = 16;
        assertTrue(competitors.size() != acceptedNumber);

        assertThrows(
            NumberOfCompetitorException.class,
            () -> {
                this.rule.generateGroups(competitors);
            }
        );
	}

}
