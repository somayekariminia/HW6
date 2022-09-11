package model;

import java.util.List;

public class FootballClub extends Club {
private int goalForCount;
private int goalAgainst;
private int differentGoal;
private int equal;
private List<Play>plays;
    public FootballClub(String name, int plays, double score, int winCount, int lossCount, int anInt, int resultSetInt, int setInt, double aDouble) {
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

    public int getDifferentGoal() {
        return getGoalForCount()-getGoalAgainst();
    }

    public void setDifferentGoal(int differentGoal) {
        this.differentGoal = differentGoal;
    }

    public int getEqual() {
        return equal;
    }

    public void setEqual(int equal) {
        this.equal = equal;
    }
}
