package competition.competition;

import java.util.*;
import competition.match.*;
import competition.observer.*;
import competition.*;
import competition.util.*;
import competition.display.*;
import competition.exception.*;
import competition.rule.*;

public class MasterBuilder extends CompetitionBuilder
{  
    private MasterRule masterRule = new MasterRule16();

    /**
     * @param typeOfMatch {TypeOfMatch} a competition typeOfMatch type.
     * @return
     */
    public CompetitionBuilder setMasterRule(MasterRule masterRule) {
        this.masterRule = masterRule;
        return this;
    }


    /**
     * Competition builder
     * @return
     */
    public Competition build(){
        try{
            Competition master = new Master(this.competitors, this.typeOfMatch, this.displayer, this.observers, this.masterRule);
            return master;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
            return null;
        }
        
    }
}