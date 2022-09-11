package model;

import java.util.List;

public class FootballClub extends Club {
private int goalForCount;
private int goalAgainst;
private List<Play>plays;
    public FootballClub(String name, int plays, double score, int winCount, int lossCount) {
        super(name, plays, score, winCount, lossCount);
    }

    public int getGoalForCount() {
        return goalForCount;
    }

    public void setGoalForCount(int goalForCount) {
        this.goalForCount = goalForCount;
    }

    public int getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(int goalAgainst) {
        this.goalAgainst = goalAgainst;
    }

    @Override
    public double getScore() {
        int score=0;
        for (Play play:plays)
        {
         if(play.getResult().equals(Result.WIN))
             score+=3;
         else if (play.getResult().equals(Result.EQUAL))
             score+=1;
        }
        return score;
    }
}
