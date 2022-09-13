package repository;

import model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayFootballRepository {

    public void insert(Play play) throws SQLException {
        String str = "insert into playsFootball values(?,?,?,?,?)";
        Connection connection = GetConnection.getConnection();
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
    }
    public List<Play> select(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from playsFootball inner join football on playsFootball.team1=football.name");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Play> list = new ArrayList<>();
        while (resultSet.next()) {
            Play play = new Play(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5),resultSet.getString(6));
            list.add(play);
        }
        return list;
    }

}
