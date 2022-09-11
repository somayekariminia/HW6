package model;

public class FootballClub extends Club {
private int goalForCount;
private int goalAgainst;
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
}
