package repository;

import model.FootballClub;
import model.VolleyballClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VolleyballRepository {
    public void insert(VolleyballClub club) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into volleyball (name,countplay,setWin,setLoss, countWin,countLoss,score ) values(?,?,?,?,?,?,?)");
        preparedStatement.setString(1, club.getName());
        preparedStatement.setInt(2, club.getPlays());
        preparedStatement.setInt(3, club.getSetWinCount());
        preparedStatement.setInt(4, club.getSetLossCount());
        preparedStatement.setInt(5, club.getWinCount());
        preparedStatement.setInt(6, club.getLossCount());
        preparedStatement.setDouble(7, club.getScore());
        preparedStatement.executeUpdate();
    }

    public void deleteVolleyballClub(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from volleyball where nameclup=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
    public void updateVolleyballClub(VolleyballClub club) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update  volleyball" + " set countplay=?,setwincount=?,setLosscount=?,countWin=?,countLoss=?,countEqual=?,score=? " + " where name=?");
        preparedStatement.setInt(1, club.getPlays());
        preparedStatement.setInt(2,club.getSetWinCount());
        preparedStatement.setInt(3, club.getSetLossCount());
        preparedStatement.setInt(4, club.getLossCount());
        preparedStatement.setDouble(5, club.getScore());
        preparedStatement.setString(6, club.getName());
        preparedStatement.executeUpdate();
    }
    public List<FootballClub> getListClubVolleyball() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from volleyball order by score desc ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<FootballClub> list = new ArrayList<>();
        while (resultSet.next()) {
            FootballClub club= new FootballClub(
                    resultSet.getString("name"),
                    resultSet.getInt("countplay"),
                    resultSet.getInt("goalagainst"),
                    resultSet.getInt("goalforcount"),
                    resultSet.getInt("diffgoal"),
                    resultSet.getInt("countWin "),
                    resultSet.getInt("countLoss"),
                    resultSet.getInt("countEqual"),
                    resultSet.getDouble("score"));
            list.add(club);
        }
        return list;
    }
    public boolean isExist(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from volleyballgit where name=? ");
        preparedStatement.setString(1, name);
        boolean flage = false;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (!resultSet.getString(1).equals(null))
                flage = true;
        }
        return flage;
    }

}
