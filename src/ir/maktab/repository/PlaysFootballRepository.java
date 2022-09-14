package ir.maktab.repository;

import ir.maktab.model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaysFootballRepository {

    public void insert(Play play) throws SQLException {
        Connection connection = GetConnection.getConnection();
        String str = "insert into playsfootball(team1,team2,count_team1,count_team2,result) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setString(1, play.getNameTeamFirst());
        preparedStatement.setString(2, play.getNameTeamSecond());
        preparedStatement.setInt(3, play.getGoalCountFirst());
        preparedStatement.setInt(4, play.getGoalCountSecond());
        preparedStatement.setString(5, play.getResult());
        preparedStatement.executeUpdate();
    }
    public void delete(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from playsFootball where team1=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
    public List<Play> select(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from playsfootball where team1=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Play> list = new ArrayList<>();
        while (resultSet.next()) {
            Play play = new Play(resultSet.getString("team1"),
                    resultSet.getString("team2"),
                    resultSet.getInt("count_team1"),
                    resultSet.getInt("count_team2"),
                    resultSet.getString("result"));
            list.add(play);
        }
        return list;
    }

}
