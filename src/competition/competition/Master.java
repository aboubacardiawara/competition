package competition.competition;
import java.util.*;
import competition.match.*;
import competition.rule.*;
import competition.*;
import competition.display.*;
import competition.exception.*;
import competition.observer.*;

public class Master extends Competition{
    public static final int VICTORY_POINT = 3;

    protected List<Group> groups;
    protected MasterRule masterRule;

    /**
     * constructor. Create a new master.
     * Create a new Master using a list of competitor.
     */
    public Master(List<Competitor> competitors, TypeOfMatch typeOfMatch, Displayer displayer, List<CompetitionObserver> observers ,MasterRule masterRule) throws NumberOfCompetitorException
    {   
        super(competitors, typeOfMatch, displayer, observers);
        this.masterRule = masterRule;
        this.groups = this.masterRule.generateGroups(competitors);
        
        
        
    }

    public List<Group> getGroups()
    {
        return this.groups;
    }

    /** performs all the round of the Master.
     * The first step is a group stage.
     * the second one is a tournament.
	 * @param competitors {List<Competitor>} a list of competitors to play.
	*/
    public void play(List<Competitor> competitors)
    {
        this.displayer.displayMsg(">>> MASTER COMPETITION <<<");
        this.displayer.displayMsg(">> GROUPS STAGE <<<");
        playGroupStage();
        this.displayer.displayMsg(">> FINAL STAGE <<<");
        playFinalStages();
    }

    public void playGroupStage(){
        League league;
        Iterator<Group> iter_groups = this.groups.iterator();
        Group group;
        int group_id = 1;
        while (iter_groups.hasNext()) 
        {
            group = iter_groups.next();
            try {
                league =(League) new LeagueBuilder().setCompetitors(group.getCompetitors()).setTypeOfMatch(this.typeOfMatch).setDisplayer(this.displayer).setObservers(this.observers).build();
                this.displayer.displayMsg("> GROUP " + group_id++);
                league.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void playFinalStages()
    {
        Tournament tournament;
        try{
            tournament =(Tournament) new TournamentBuilder().setCompetitors(this.masterRule.getFinalist(this.groups)).setTypeOfMatch(this.typeOfMatch).setDisplayer(this.displayer).setObservers(this.observers).build();
            tournament.play();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}
