package model;

import java.util.Objects;

public class Play {
    private String nameTeamFirst;
    private String nameTeamSecond;
    private int goalCountFirst;
    private int goalCountSecond;
    private Result result;
    public Play(String nameTeamFirst, String nameTeamSecond, int goalCountFirst, int goalCountSecond,String result) {
        this.nameTeamFirst = nameTeamFirst;
        this.nameTeamSecond = nameTeamSecond;
        this.goalCountFirst = goalCountFirst;
        this.goalCountSecond = goalCountSecond;
        this.result = Result.valueOf(result);
    }


    public Play(String nameTeamFirst, String nameTeamSecond, int goalCountFirst, int goalCountSecond) {
        this.nameTeamFirst = nameTeamFirst;
        this.nameTeamSecond = nameTeamSecond;
        this.goalCountFirst = goalCountFirst;
        this.goalCountSecond = goalCountSecond;
    }

    public String getNameTeamFirst() {
        return nameTeamFirst;
    }

    public void setNameTeamFirst(String nameTeamFirst) {
        this.nameTeamFirst = nameTeamFirst;
    }

    public String getNameTeamSecond() {
        return nameTeamSecond;
    }

    public void setNameTeamSecond(String nameTeamSecond) {
        this.nameTeamSecond = nameTeamSecond;
    }

    public int getGoalCountFirst() {
        return goalCountFirst;
    }

    public void setGoalCountFirst(int goalCountFirst) {
        this.goalCountFirst = goalCountFirst;
    }

    public int getGoalCountSecond() {
        return goalCountSecond;
    }

    public void setGoalCountSecond(int goalCountSecond) {
        this.goalCountSecond = goalCountSecond;
    }

    public String getResult() {
        return getResultTeam();
    }

    public void setResult(Result result) {
        this.result = result;
    }

    private String getResultTeam() {
        if (goalCountFirst > goalCountSecond) return String.valueOf(Result.WIN);
        else if (goalCountFirst < goalCountSecond) return  String.valueOf(Result.LOST);
        else return String.valueOf(Result.EQUAL);
    }

    @Override
    public String toString() {
        return "Play" +
                "nameTeamFirst='" + nameTeamFirst  +
                " nameTeamSecond='" + nameTeamSecond +
                " goalCountFirst=" + goalCountFirst +
                " goalCountSecond=" + goalCountSecond +
                " result=" + result ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play = (Play) o;
        return getGoalCountFirst() == play.getGoalCountFirst() &&
                getGoalCountSecond() == play.getGoalCountSecond() &&
               getNameTeamFirst().equals(play.getNameTeamFirst()) &&
               getNameTeamSecond().equals(play.getNameTeamSecond()) &&
                getResult() == play.getResult();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameTeamFirst(), getNameTeamSecond(), getGoalCountFirst(), getGoalCountSecond(), getResult());
    }
}
