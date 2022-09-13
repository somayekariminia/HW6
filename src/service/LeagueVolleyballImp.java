package service;

import model.Club;
import model.FootballClub;
import model.Play;
import model.VolleyballClub;
import repository.VolleyballRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeagueVolleyballImp implements League {
    VolleyballRepository volleyballRepository=new VolleyballRepository();
    List<Play>list=new ArrayList<>();
    @Override
    public void addClubToLeague(Club club) throws SQLException {
        volleyballRepository.insert((VolleyballClub)club);

    }
    @Override
    public void removeTheClubOfLeague(String name) throws SQLException {
           removeTheClubOfLeague(name);
    }

    @Override
    public void addGamesBetweenTwoClub(Play play) throws SQLException {
        plays=null;
        playFootballRepository.insert(play);
        plays = playFootballRepository.select((play.getNameTeamFirst()));
        FootballClub club=new FootballClub(play.getNameTeamFirst(), plays);
        if (footballRepository.isExist(play.getNameTeamFirst()))
            footballRepository.update(club);
        else
            footballRepository.insert(club);
        plays=null;
        Play play1=new Play(play.getNameTeamSecond(), play.getNameTeamFirst(), play.getGoalCountSecond(),play.getGoalCountFirst());
        playFootballRepository.insert(play1);
        plays=playFootballRepository.select(play.getNameTeamSecond());
        FootballClub club1=new FootballClub(play.getNameTeamSecond(), plays);
        if (footballRepository.isExist(play.getNameTeamSecond()))
            footballRepository.update(club1);
        else
            footballRepository.insert(club1);
    }
    }

    @Override
    public Club viewInformationClub(String name) throws SQLException {
        return null;
    }

    @Override
    public List seeTheLeagueTable() throws SQLException {
        return null;
    }
}
