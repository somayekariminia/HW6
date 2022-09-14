package ir.maktab.model;

import java.util.Objects;

public class Club {
    private String name;
    private int plays;
    private double score;
    private int winCount;
    private int lossCount;

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

    @Override
    public String toString() {
        return "" +
                "name='" + name +
                ", plays=" + plays +
                ", score=" + score +
                ", winCount=" + winCount +
                ", lossCount=" + lossCount ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return plays == club.plays && Double.compare(club.score, score) == 0 && winCount == club.winCount && lossCount == club.lossCount && club.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, plays, score, winCount, lossCount);
    }
}
