package ir.maktab.service;

import ir.maktab.model.Play;
import ir.maktab.repository.FootballRepository;
import ir.maktab.model.Club;
import ir.maktab.model.FootballClub;
import ir.maktab.repository.PlaysFootballRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeagueFootballImp implements League {
    FootballRepository footballRepository=new FootballRepository();
    PlaysFootballRepository playsFootballRepository =new PlaysFootballRepository();
    List<Play> plays=new ArrayList<>();
    List<FootballClub> footballClubList=new ArrayList<FootballClub>();
    @Override
    public void addClubToLeague(Club club) throws SQLException {
        footballRepository.insert((FootballClub) club);
    }

    @Override
    public void removeTheClubOfLeague(String name) throws SQLException {
            footballRepository.delete(name);
            playsFootballRepository.delete(name);
    }

    @Override
    public void addGamesBetweenTwoClub(Play play) throws SQLException {
        plays = playsFootballRepository.select((play.getNameTeamFirst()));
        FootballClub club=new FootballClub(play.getNameTeamFirst(), plays);
         if (footballRepository.isExist(play.getNameTeamFirst()))
             footballRepository.update(club);
          else
              footballRepository.insert(club);
           plays=null;
        plays= playsFootballRepository.select(play.getNameTeamSecond());
       FootballClub club1=new FootballClub(play.getNameTeamSecond(), plays);
        if (footballRepository.isExist(play.getNameTeamSecond()))
           footballRepository.update(club1);
        else
            footballRepository.insert(club1);
    }
    @Override
    public FootballClub viewInformationClub(String name) throws SQLException {
        Club footballClub;
       footballClub=footballRepository.selectByname(name);
       return (FootballClub) footballClub;
    }

    @Override
    public List<FootballClub> seeTheLeagueTable() throws SQLException {
       footballClubList =footballRepository.select();
        return  footballClubList;
    }
}
