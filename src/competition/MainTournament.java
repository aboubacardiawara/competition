package competition;
import java.util.*;
import competition.match.*;
import competition.competition.*;
import competition.exception.*;
import competition.display.*;
import competition.observer.*;
/**
 * MainCompetition
 */
public class MainTournament {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: java -jar Tournament [competitors]...\n/!\\ the number of competitors should be a power of 2");
			System.exit(-1);
		}
		
		List<Competitor> competitors = new ArrayList<>();
		String name;
		Competition competition;

		for(int i=0; i<args.length; i++){
			name = args[i];
			competitors.add(new Competitor(name));
		}

		try {
			competition =(Tournament) new TournamentBuilder()
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
