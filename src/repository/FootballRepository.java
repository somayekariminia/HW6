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
    public void creat() throws SQLException, SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE clup( id  SERIAL PRIMARY KEY NOT NULL," +
                "nameClup VARCHAR(50) unique ," +
                "countPlay int," +
                "draw int," +
                "forgoal int," +
                "diffgoal int," +
                "countWin int,countLoss int," +
                "countEqual int ,score decimal)");
        preparedStatement.executeUpdate();
    }
    public void insert(FootballClub clup) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into football values(id,?,?,?,?,?,?,?,?,?) ");
        preparedStatement.setString(1, clup.getName());
        preparedStatement.setInt(2, clup.getPlays());
        preparedStatement.setInt(3, clup.getGoalForCount());
        preparedStatement.setInt(4, clup.getGoalAgainst());
        preparedStatement.setInt(5, clup.getDifferentGoal());
        preparedStatement.setInt(6, clup.getWinCount());
        preparedStatement.setInt(7, clup.getLossCount());
        preparedStatement.setInt(8, clup.getEqual());
        preparedStatement.setDouble(9, clup.getScore());
        preparedStatement.executeUpdate();
    }

    public void delete(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from football where nameclup=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
    public void update(FootballClub club) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update  football" + " set countplay=?,draw=?,forgoal=?,countWin=?,countLoss=?,countEqual=?,score=? " + " where nameClup=?");
        preparedStatement.setInt(1, club.getPlays());
        preparedStatement.setInt(2, club.getGoalForCount());
        preparedStatement.setInt(3, club.getGoalAgainst());
        preparedStatement.setInt(4, club.getWinCount());
        preparedStatement.setInt(5, club.getLossCount());
        preparedStatement.setInt(6, club.getEqual());
        preparedStatement.setDouble(7, club.getScore());
        preparedStatement.setString(8, club.getName());
        preparedStatement.executeUpdate();
    }
    public List<FootballClub> select() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from football order by score desc ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<FootballClub> list = new ArrayList<>();
        while (resultSet.next()) {
           FootballClub club= new FootballClub(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8),
                    resultSet.getDouble(9));
            list.add((club);
        }
        return list;
    }
    public boolean isExist(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from football where nameClup=? ");
        preparedStatement.setString(1, name);
        boolean flage = false;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (!resultSet.getString(1).equals(""))
                flage = true;
        }
        return flage;
    }
    public FootballClub selectByname(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from football where nameclub=? ");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
       FootballClub club=null;
        while (resultSet.next()) {
             club = new FootballClub(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8),
                    resultSet.getDouble(9));
        }
        return club;
    }

}
