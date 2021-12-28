package competition.match;

import competition.Competitor;

/**
 * Contains data about a match.
 * - the opponents
 * - the winner.
 */
public class MatchEvent
{
    private Competitor c1;
    private Competitor c2;
    private Competitor winner;

    /** constructor
     * @param c1 the first competitor
     * @param c2 the second competitor
     * @param winner the match winner
     */
    public MatchEvent(Competitor c1, Competitor c2, Competitor winner)
    {
        this.c1 = c1;
        this.c2 = c2;
        this.winner = winner;
    }

    /**
     * @return the first competitor.
     */
    public Competitor getCompetitor1()
    {
        return this.c1;    
    }

    /**
     * @return the second competitor.
     */
    public Competitor getCompetitor2()
    {
        return this.c2;
    }

    /**
     * @return the match winner?
     */
    public Competitor getWinner()
    {
        return this.winner;  
    }
}