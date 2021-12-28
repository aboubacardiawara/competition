package competition;
import java.util.*;
import competition.match.*;
import competition.competition.*;
import competition.display.StdDisplayer;
import competition.exception.*;
import competition.observer.*;
/**
 * MainCompetition
 */
public class MainLeague {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: java -jar League [competitors]...");
			System.exit(-1);
		}
		
		List<Competitor> competitors = new ArrayList<>();
		String name;
		Competition competition;
		// adding competitors
		for(int i=0; i<args.length; i++){
			name = args[i];
			competitors.add(new Competitor(name));
		}

		// adding journalists


		// adding bookmakers

		try {
			competition = (League) new LeagueBuilder()
					     					.setCompetitors(competitors)
					     					.setTypeOfMatch(new RandomMatch())
					     					.setDisplayer(new StdDisplayer())
					     					.build();
			
            competition.addObserver(new Journalist("Abdo"));
			competition.addObserver(new BookMaker("someBookemaker1"));
			competition.play();
		} catch (NumberOfCompetitorException e) {
			System.out.println(e.getMessage());
		}
	}
				
}
