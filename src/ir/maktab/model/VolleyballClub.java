package ir.maktab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        int countWin = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getResult().equals("WIN"))
                countWin++;
        }
        return countWin;
}
    @Override
    public int getLossCount() {
        int countLost = 0;
        for (int i = 0; i < plays.size(); i++) {
            if (plays.get(i).getResult().equals("LOST"))
                countLost++;
        }
        return countLost;
    }

    @Override
    public int getPlays() {
        return plays.size();
    }

    @Override
    public String toString() {
        return " club " + getName()+
                "  countPlays " +super.getPlays()+
                "  setsWinCount " + setsWinCount +
                "  setsLossCount " + setsLossCount +
                "  winCount " + super.getWinCount()+
                "  lossCount "  + super.getLossCount()+
                "  score " + super.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VolleyballClub volleyballClub = (VolleyballClub) o;
        return getSetsWinCount() ==volleyballClub.getSetsWinCount() &&
                getSetsLossCount() == volleyballClub.getSetsLossCount() &&
                Objects.equals(getPlays(), volleyballClub.getPlays());
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSetsWinCount(), getSetsLossCount(), getPlays());
    }
}
