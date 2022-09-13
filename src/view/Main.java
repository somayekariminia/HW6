package view;

import model.Play;
import service.LeagueFootballImp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        CreateTables createTables = new CreateTables();
//        createTables.creatTablePlay();
//        createTables.creat();
        Play play = new Play("iran", "emrica", 2, 2);
        LeagueFootballImp leagueFootballImp = new LeagueFootballImp();
        leagueFootballImp.addGamesBetweenTwoClub(play);
    }
}
