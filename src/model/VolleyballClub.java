package model;

import java.util.ArrayList;
import java.util.List;

public class VolleyballClub extends Club {
    private int setWinCount;
    private int setLossCount;
    private List<Play> plays = new ArrayList<>();

    public VolleyballClub(String name, int plays, double score, int winCount, int lossCount) {
        super(name, plays, score, winCount, lossCount);
    }

    public int getSetWinCount() {
        for (Play play:plays)
        {
         setWinCount+=play.getGoalCountFirst();
        }
        return setWinCount;
    }

    public void setSetWinCount(int setWinCount) {
        this.setWinCount = setWinCount;
    }

    public int getSetLossCount() {
        for (Play play:plays)
        {
         setLossCount+=play.getGoalCountSecond();
        }
        return setLossCount;
    }

    public void setSetLossCount(int setLossCount) {
        this.setLossCount = setLossCount;
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
