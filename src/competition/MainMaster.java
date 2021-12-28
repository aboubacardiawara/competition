package competition;
import java.util.*;
import competition.match.*;
import competition.rule.*;
import competition.competition.*;
import competition.exception.*;
import competition.display.*;
import competition.observer.*;
/**
 * MainCompetition
 */
public class MainMaster {

	public static void main(String[] args) {
		MasterRule masterRule;
		int masterRuleId;

        if (args.length < 1) {
			System.out.println("usage: java -jar Master '<MasterRuleID>' [competitors]...");
			System.out.println("<MasterRuleID> :");
			System.out.println("-1: strategie with 16 competitors divided into 4 groups. The best 2 competitor of each group are selected for the final stage");
			System.out.println("-2: strategie with 24 competitors divided into 3 groups of 8 competitors. For the final stage, the 2 top competitor of each group will be selected and the 2 best thirds of all group combined");
			System.out.println("-3: strategie with 4 competitors divided into 2 groups. The best competitor of each group participates to the final stage.");
			System.exit(-1);
		}
        
        
        masterRuleId = Integer.parseInt(args[0]);
        masterRule = MasterRuleFactory.getMasterRule(masterRuleId);
        
        if (masterRule == null){
			System.out.println("any Master selection corresponds to id " + masterRuleId);
			System.exit(-1);
        }

        
        List<Competitor> competitors = new ArrayList<>();
		String name;
		Competition competition;

		for(int i=1; i<args.length; i++){
			name = args[i];
			competitors.add(new Competitor(name));
		}

		try {
			competition = (Master) new MasterBuilder()
					                     .setMasterRule(masterRule)
					                     .setCompetitors(competitors)
					                     .setTypeOfMatch(new RandomMatch())
					                     .setDisplayer(new StdDisplayer())
					                     .build();
			
			competition.addObserver(new Journalist("Abdo"));
			competition.addObserver(new BookMaker("bookemaker1"));
			competition.play();
		} catch (NumberOfCompetitorException e) {
			System.out.println(e.getMessage());
		}
		
	}

    
}
