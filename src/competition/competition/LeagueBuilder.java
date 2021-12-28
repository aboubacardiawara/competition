package competition.competition;

import java.util.*;
import competition.match.*;
import competition.observer.BookMaker;
import competition.observer.CompetitionObserver;
import competition.observer.Journalist;
import competition.*;
import competition.util.*;
import competition.display.*;
import competition.exception.*;

public class LeagueBuilder extends CompetitionBuilder
{
    /**
     * Competition builder
     * @return
     */
    public Competition build() {
        return new League(this.competitors, this.typeOfMatch, this.displayer, this.observers);
    }
}