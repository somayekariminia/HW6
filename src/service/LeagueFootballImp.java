package service;

import model.Club;
import model.FootballClub;
import model.Play;
import repository.FootballRepository;
import repository.PlaysFootballRepository;

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
        plays=null;
        playsFootballRepository.insert(play);
        plays = playsFootballRepository.select((play.getNameTeamFirst()));
        FootballClub club=new FootballClub(play.getNameTeamFirst(), plays);
         if (footballRepository.isExist(play.getNameTeamFirst()))
             footballRepository.update(club);
          else
              footballRepository.insert(club);
           plays=null;
           Play play1=new Play(play.getNameTeamSecond(), play.getNameTeamFirst(), play.getGoalCountSecond(),play.getGoalCountFirst());
           playsFootballRepository.insert(play1);
        plays= playsFootballRepository.select(play.getNameTeamSecond());
       FootballClub club1=new FootballClub(play.getNameTeamSecond(), plays);
        if (footballRepository.isExist(play.getNameTeamSecond()))
           footballRepository.update(club1);
        else
            footballRepository.insert(club1);
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
