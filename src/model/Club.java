package model;

public class Club {
    private String name;
    private int plays;
    private double score;
    private int winCount;
    private int lossCount;
    public Club(String name, int plays, double score, int winCount, int lossCount) {
        this.name = name;
        this.plays = plays;
        this.score = score;
        this.winCount = winCount;
        this.lossCount = lossCount;
    }

    public Club() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public void setLossCount(int lossCount) {
        this.lossCount = lossCount;
    }
}
