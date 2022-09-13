package model;

import java.util.ArrayList;
import java.util.List;

public class VolleyballClub extends Club {
    private int setsWinCount;
    private int setsLossCount;
    private List<Play> plays = new ArrayList<>();

    public VolleyballClub(String name, int plays, int winCount, int lossCount, int setsWinCount, int setsLossCount, double score ) {
        super();
        this.setName(name);
        this.setPlays(plays);
        this.setWinCount(winCount);
        this.setLossCount(lossCount);
        this.setsWinCount=setsWinCount;
        this.setsLossCount=setsLossCount;
        this.setScore(score);
    }
public VolleyballClub(String name,List<Play> plays)
{
    this.setName(name);
    this.plays=plays;
}
    public int getSetsWinCount() {
        for (Play play:plays)
        {
         setsWinCount +=play.getGoalCountFirst();
        }
        return setsWinCount;
    }

    public void setSetsWinCount(int setsWinCount) {
        this.setsWinCount = setsWinCount;
    }

    public int getSetsLossCount() {
        for (Play play:plays)
        {
         setsLossCount +=play.getGoalCountSecond();
        }
        return setsLossCount;
    }

    @Override
    public double getScore() {
        return getScoreVolleyball();
    }
    private double getScoreVolleyball() {
        double score = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getGoalCountFirst() - plays.get(i).getGoalCountSecond() > 1)
                score += 3;
            else if (plays.get(i).getGoalCountFirst() - plays.get(i).getGoalCountSecond() == 1)
                score += 2;
            else if (plays.get(i).getGoalCountFirst() - plays.get(i).getGoalCountSecond() == -1)
                score += 1;
        }
        return score;
    }

    public void setSetsLossCount(int setsLossCount) {
        this.setsLossCount = setsLossCount;
    }

    @Override
    public int getWinCount() {
        int winCount=0;
        for (Play play:plays) {
            if(play.getResult().equals(Result.WIN))
                winCount++;
        }
        return winCount;

}
    @Override
    public int getLossCount() {
        int lossCount=0;
        for (Play play:plays) {
            if(play.getResult().equals(Result.LOST))
                lossCount++;
        }
        return lossCount;
    }

    }
