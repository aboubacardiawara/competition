package competition.observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.Competitor;
import competition.match.*;

public class BookMakerTest
{
    private MatchEvent e;
    private BookMaker bookMaker;
    private Competitor winner;
    private Competitor looser;

    @BeforeEach
    public void before()
    {
        try{
            this.bookMaker = new BookMaker("bookmaker1");
            // competitors
            this.winner = new Competitor("Wini");
            this.looser = new Competitor("Looo");
            // match event
            this.e = new MatchEvent(this.winner, this.looser, this.winner);
            
        }catch(Exception e){
            System.out.println("Error BookMakerTest.java");
        }
       
    }

    @Test
    public void updateCotesTests()
    {
    	int minOdds = 1;
    	int maxOdds = 10;
    	int defaultOdds = (minOdds+maxOdds)/2;
    	// 1ere confrontation
        this.bookMaker.reactToMatch(this.e);
        int winnerOdds = this.bookMaker.getCompetitorOdds(this.winner);
        int looserOdds = this.bookMaker.getCompetitorOdds(this.looser);
        
        assertTrue(winnerOdds == defaultOdds-1);
        assertTrue(looserOdds == defaultOdds+1);
        
        // 2e confrontation
        this.bookMaker.reactToMatch(this.e);
        winnerOdds = this.bookMaker.getCompetitorOdds(this.winner);
        looserOdds = this.bookMaker.getCompetitorOdds(this.looser);
        
        assertTrue(winnerOdds == defaultOdds-2);
        assertTrue(looserOdds == defaultOdds+2);
        
        // 3e confrontation
        this.bookMaker.reactToMatch(this.e);
        winnerOdds = this.bookMaker.getCompetitorOdds(this.winner);
        looserOdds = this.bookMaker.getCompetitorOdds(this.looser);
        
        assertTrue(winnerOdds == defaultOdds-3);
        assertTrue(looserOdds == defaultOdds+3);
    }
 
}
