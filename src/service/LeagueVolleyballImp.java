package service;

import model.Club;
import model.FootballClub;
import model.Play;
import model.VolleyballClub;
import repository.PlaysVolleyballRepository;
import repository.VolleyballRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeagueVolleyballImp implements League {
    VolleyballRepository volleyballRepository=new VolleyballRepository();
    PlaysVolleyballRepository playsVolleyballRepository=new PlaysVolleyballRepository();
    List<Play>list=new ArrayList<>();

    @Override
    public void addClubToLeague(Club club) throws SQLException {
        volleyballRepository.insert((VolleyballClub)club);

    }
    @Override
    public void removeTheClubOfLeague(String name) throws SQLException {
          volleyballRepository.deleteVolleyballClub(name);
           playsVolleyballRepository.deletePlayVolleyball(name);
    }

    @Override
    public void addGamesBetweenTwoClub(Play play) throws SQLException {
        list=null;
        playsVolleyballRepository.insertPlayVolleyball(play);
        list = playsVolleyballRepository.getListOfPlays((play.getNameTeamFirst()));
        VolleyballClub club=new VolleyballClub(play.getNameTeamFirst(),list);
        if (volleyballRepository.isExist(play.getNameTeamFirst())) {
            volleyballRepository.updateVolleyballClub(club);
        } else {
            volleyballRepository.insert(club);
        }
       list=null;
        Play play1=new Play(play.getNameTeamSecond(), play.getNameTeamFirst(), play.getGoalCountSecond(),play.getGoalCountFirst());
        playsVolleyballRepository.insertPlayVolleyball(play1);
        list=playsVolleyballRepository.getListOfPlays(play.getNameTeamSecond());
       VolleyballClub club1=new VolleyballClub(play.getNameTeamSecond(),list);
        if (volleyballRepository.isExist(play.getNameTeamSecond()))
           volleyballRepository.updateVolleyballClub(club1);
        else
            volleyballRepository.insert(club1);
    }

    @Override
    public Club viewInformationClub(String name) throws SQLException {
       Club club=volleyballRepository.getClubByName(name);
       return club;
    }

    @Override
    public List seeTheLeagueTable() throws SQLException {
        return volleyballRepository.getListClubVolleyball();
    }
}
