package competition.competition;

import java.util.*;
import competition.match.*;
import competition.observer.*;
import competition.*;
import competition.util.*;
import competition.display.*;
import competition.exception.*;

public class TournamentBuilder extends CompetitionBuilder
{
    /**
     * Competition builder
     * @return
     */
    public Competition build() {
        try{
            Competition competition = new Tournament(this.competitors, this.typeOfMatch, this.displayer, this.observers);
            return competition;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
            return null;
        }
    }
}