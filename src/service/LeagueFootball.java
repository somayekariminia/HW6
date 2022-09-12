package service;

import model.Club;
import model.FootballClub;
import model.Play;
import repository.FootballRepository;
import repository.PlayFootballRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeagueFootball implements League {
    FootballRepository footballRepository=new FootballRepository();
    PlayFootballRepository playFootballRepository=new PlayFootballRepository();
    List<Play> plays=new ArrayList<>();
    List<FootballClub> footballClubList=new ArrayList<FootballClub>();
    @Override
    public void addClubToLeague(Club club) throws SQLException {
        footballRepository.insert((FootballClub) club);
    }

    @Override
    public void removeTheClubOfLeague(String name) throws SQLException {
            footballRepository.delete(name);
    }

    @Override
    public void addGamesBetweenTwoClub(Play play) throws SQLException {
        plays = playFootballRepository.select((play.getNameTeamFirst()));
        Club club=new FootballClub(play.getNameTeamSecond(), plays);
         if (footballRepository.isExist(play.getNameTeamFirst()))
             footballRepository.update((FootballClub) club);

          else
              footballRepository.insert((FootballClub) club);
           plays=null;
        plays=playFootballRepository.select(play.getNameTeamFirst());
        Club club1=new FootballClub(play.getNameTeamSecond(), plays);
        if (footballRepository.isExist(play.getNameTeamSecond()))
           footballRepository.update((FootballClub) club1);
        else
            footballRepository.insert((FootballClub) club1);
    }
    @Override
    public Club viewInformationClub(String name) throws SQLException {
        Club footballClub;
       footballClub=footballRepository.selectByname("name");
       return footballClub;
    }

    @Override
    public List<FootballClub> seeTheLeagueTable() throws SQLException {
       footballClubList =footballRepository.select();
        return  footballClubList;
    }
}
