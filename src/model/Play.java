package model;

public class Play {
    private String nameTeamFirst;
    private String nameTeamSecond;
    private int goalCountFirst;
    private int goalCountSecond;
    private Result result;

    public Play(String nameTeamFirst, String nameTeamSecond, int goalCountFirst, int goalCountSecond, Result result) {
        this.nameTeamFirst = nameTeamFirst;
        this.nameTeamSecond = nameTeamSecond;
        this.goalCountFirst = goalCountFirst;
        this.goalCountSecond = goalCountSecond;
        this.result = result;
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
}
