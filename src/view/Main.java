package view;

import model.Play;
import repository.CreateTables;
import service.LeagueFootball;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CreateTables createTables=new CreateTables();
//        createTables.creatTablePlay();
//        createTables.creat();
        Play play=new Play("iran","japan",2,0);
        LeagueFootball leagueFootball=new LeagueFootball();
        leagueFootball.addGamesBetweenTwoClub(play);
    }
}
