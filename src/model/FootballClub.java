package model;

import java.util.List;

public class FootballClub extends Club {
    private int goalForCount;
    private int goalAgainst;
    private int differentGoal;
    private int equal;
    private List<Play> plays;

    public FootballClub(String name, int plays,int winCount,int lossCount,int goalForCount,int goalAgainst,int differentGoal,double score) {
        super();
        this.setName(name);
        this.setPlays(plays);
        this.setScore(score);
        this.setWinCount(winCount);
        this.setLossCount(lossCount);
        this.goalForCount=goalForCount;
        this.goalAgainst=goalAgainst;
        this.differentGoal=differentGoal;
    }
    public FootballClub(String name, List<Play> plays) {
        super();
        super.setName(name);
        this.plays = plays;
    }
    public int getGoalForCount() {
        goalForCount = 0;
        for (int i = 0; i < plays.size(); i++) {
            goalForCount += plays.get(i).getGoalCountFirst();
        }
        return goalForCount;
    }

    public void setGoalForCount(int goalForCount) {
        this.goalForCount = goalForCount;
    }

    public int getGoalAgainst() {
        goalAgainst = 0;
        for (int i = 0; i < plays.size(); i++) {
            goalAgainst += plays.get(i).getGoalCountSecond();

        }
        return goalAgainst;
    }

    public void setGoalAgainst(int goalAgainst) {
        this.goalAgainst = goalAgainst;
    }

    @Override
    public int getWinCount() {
        int getWin = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getResult().equals("WIN"))
                getWin++;
        }
        return getWin;
    }

    @Override
    public int getLossCount() {
        int getLoss = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getResult().equals("LOST"))
                getLoss++;
        }
        return getLoss;
    }

    @Override
    public double getScore() {
        int score = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getResult().equals("WIN"))
                score += 3;
            else if (plays.get(i).getResult().equals("EQUAL"))
                score += 1;
        }
        return score;
    }

    public int getDifferentGoal() {
        return Math.abs(getGoalForCount() - getGoalAgainst());
    }

    public void setDifferentGoal(int differentGoal) {
        this.differentGoal = differentGoal;
    }

    public int getEqual() {
        int equal = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getResult().equals("EQUAL"))
                equal++;
        }
        return equal;
    }

    public void setEqual(int equal) {
        this.equal = equal;
    }

    @Override
    public int getPlays() {
        return plays.size();
    }
}
