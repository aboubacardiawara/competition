package competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.competition.*;
import competition.rule.*;
import competition.*;
import competition.exception.*;

public class MasterRule24Test extends MasterRuleTest
{   
    public void initMasterRule()
    {
        this.rule = new MasterRule24();
    }

    @Test
    public void numberOfGroupsTest()
    {
        addCompetitors();
        // pour un effectif de 24, constituer 3 poules, 8 par poule.

        // precondition
        assertEquals(24, this.competitors.size());
        assertEquals(0, this.groups.size());

        // envoie de message.
        this.rule = new MasterRule24();
        try {
            this.groups = this.rule.generateGroups(this.competitors);
        } catch (Exception e) {
            //do nothing
        }

        // expection
        assertEquals(3, this.groups.size());
        assertEquals(24, this.competitors.size());
        assertEquals(8, this.rule.getFinalist(this.groups).size()); /** 8 = top 2 competitors of 3 groups
        and top 2 of third of each group */
       
    }
    /**
     * Add 8 competitors to the list of competitors.
     */
    private void addCompetitors(){
        String name;
        String[] competitorsName = {
			"calais",
			"strasbourg",
			"limoge",
            "Dijon",
            "montpellier",
            "brest",
            "lorient",
            "clermont"
        };

         // Adding of competitors 
		for (int i=0; i<competitorsName.length; i++) {
			name = competitorsName[i];
			this.competitors.add(new Competitor(name));
		}
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
