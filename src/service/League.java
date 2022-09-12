package service;

import model.Club;

import java.sql.SQLException;
public interface League {
    public void addClubToLeague(Club club) throws SQLException;
    public void removeTheClubOfLeague(String name) throws SQLException;
    public  void addGamesBetweenTwoClub() throws SQLException;
    public void viewInformationClub( String name) throws SQLException;
    public void seeTheLeagueTable() throws SQLException;
}
