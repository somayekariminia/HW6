package view;

import model.FootballClub;
import model.Play;
import model.VolleyballClub;
import repository.CreateTables;
import service.League;
import service.LeagueFootballImp;
import service.LeagueVolleyballImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
       CreateTables createTables = new CreateTables();
//        createTables.creatTablePlay();
//        createTables.creat();
       // createTables.creatVolleyballTable();
      //  createTables.creatPlaysVolleyballTable();
        List<FootballClub> leagues1=new ArrayList<>();
        List<VolleyballClub> volleyballClubs=new ArrayList<>();
        Play play = new Play("iran", "japan", 2, 2);
        League leagueFootballImp = new LeagueFootballImp();
        Play playv=new Play("iran","italy",2,3);
        leagueFootballImp.addGamesBetweenTwoClub(play);
        League league=new LeagueVolleyballImp();
        league.addGamesBetweenTwoClub(playv);
       // leagueFootballImp.removeTheClubOfLeague(play.getNameTeamFirst());
        //league.removeTheClubOfLeague(playv.getNameTeamFirst());
        leagues1=leagueFootballImp.seeTheLeagueTable();
        for (FootballClub football:leagues1) {
            System.out.println("---------------------------------------------------------");
            System.out.println(football.toString());
            System.out.println("----------------------------------------------------------");
        }
        System.out.println("****************************************************************");
volleyballClubs=league.seeTheLeagueTable();
        for (VolleyballClub volleyball:volleyballClubs) {
            System.out.println("---------------------------------------------------------");
            System.out.println(volleyball.toString());
            System.out.println("                 ");
            System.out.println("--------------------------------------------------------");
        }
}
}
