package model;

public class VolleyballClub extends Club  {
    private int setWinCount;
    private int setLossCount;

    public VolleyballClub(String name, int plays, double score, int winCount, int lossCount) {
        super(name, plays, score, winCount, lossCount);
    }

    public int getSetWinCount() {
        return setWinCount;
    }

    public void setSetWinCount(int setWinCount) {
        this.setWinCount = setWinCount;
    }

    public int getSetLossCount() {
        return setLossCount;
    }

    public void setSetLossCount(int setLossCount) {
        this.setLossCount = setLossCount;
    }
}
