package service;

import model.Club;
import model.FootballClub;
import model.Play;

import java.sql.SQLException;
import java.util.List;

public interface League {
    public void addClubToLeague(Club club) throws SQLException;
    public void removeTheClubOfLeague(String name) throws SQLException;
    public  void addGamesBetweenTwoClub(Play play) throws SQLException;
    public Club viewInformationClub( String name) throws SQLException;
    public List seeTheLeagueTable() throws SQLException;
}
