package repository;

import model.Club;
import model.FootballClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootballRepository {
    public void insert(FootballClub clup) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into football(name,countplay,goalAgainst,goalForCount,diffgoal, countWin,countLoss,countEqual,score ) values(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, clup.getName());
        preparedStatement.setInt(2, clup.getPlays());
        preparedStatement.setInt(3, clup.getGoalAgainst());
        preparedStatement.setInt(4, clup.getGoalForCount());
        preparedStatement.setInt(5, clup.getDifferentGoal());
        preparedStatement.setInt(6, clup.getWinCount());
        preparedStatement.setInt(7, clup.getLossCount());
        preparedStatement.setInt(8, clup.getEqual());
        preparedStatement.setDouble(9, clup.getScore());
        preparedStatement.executeUpdate();
    }
    public void delete(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from football where name=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
    public void update(FootballClub club) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update  football" + " set countplay=?,diffgoal=?,goalAgainst=?,goalForCount=?,countWin=?,countLoss=?,countEqual=?,score=? " + " where name=?");
        preparedStatement.setInt(1, club.getPlays());
        preparedStatement.setInt(2,club.getDifferentGoal());
        preparedStatement.setInt(3, club.getGoalAgainst());
        preparedStatement.setInt(4, club.getGoalForCount());
        preparedStatement.setInt(5, club.getWinCount());
        preparedStatement.setInt(6, club.getLossCount());
        preparedStatement.setInt(7, club.getEqual());
        preparedStatement.setDouble(8, club.getScore());
        preparedStatement.setString(9, club.getName());
        preparedStatement.executeUpdate();
    }
    public List<FootballClub> select() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from football order by score desc ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<FootballClub> list = new ArrayList<>();
        while (resultSet.next()) {
           FootballClub club= new FootballClub(
                    resultSet.getString("name"),
                    resultSet.getInt("countplay"),
                   resultSet.getInt("countwin"),
                   resultSet.getInt("countLoss"),
                   resultSet.getInt("countEqual"),
                   resultSet.getInt("goalforcount"),
                    resultSet.getInt("goalagainst"),
                    resultSet.getInt("diffgoal"),
                    resultSet.getDouble("score"));
            list.add(club);
        }
        return list;
    }
    public boolean isExist(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from football where name=? ");
        preparedStatement.setString(1, name);
        boolean flage = false;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (!resultSet.getString(1).equals(null))
                flage = true;
        }
        return flage;
    }
    public FootballClub selectByname(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from football where name =? ");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
       FootballClub club=null;
        while (resultSet.next()) {
             club = new FootballClub(
                    resultSet.getString("name"),
                    resultSet.getInt("countplay"),
                     resultSet.getInt("countwin"),
                     resultSet.getInt("countloss"),
                     resultSet.getInt("countequal"),
                     resultSet.getInt("goalforcount"),
                     resultSet.getInt("goalagainst"),
                    resultSet.getInt("diffgoal"),
                    resultSet.getDouble("score"));
        }
        return club;
    }

}
