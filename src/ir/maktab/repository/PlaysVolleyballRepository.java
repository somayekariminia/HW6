package ir.maktab.repository;

import ir.maktab.model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaysVolleyballRepository {

    public void insertPlayVolleyball(Play play) throws SQLException {
        Connection connection = GetConnection.getConnection();
        String str = "insert into playvolleyball(team1,team2,countsetsteam1,countsetsteam2,result) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setString(1, play.getNameTeamFirst());
        preparedStatement.setString(2, play.getNameTeamSecond());
        preparedStatement.setInt(3, play.getGoalCountFirst());
        preparedStatement.setInt(4, play.getGoalCountSecond());
        preparedStatement.setString(5, play.getResult());
        preparedStatement.executeUpdate();
    }
    public void deletePlayVolleyball(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from playvolleyball where team1=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }
    public List<Play> getListOfPlays(String name) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from playvolleyball where team1=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Play> list = new ArrayList<>();
        while (resultSet.next()) {
            Play play = new Play(resultSet.getString("team1"),
                    resultSet.getString("team2"),
                    resultSet.getInt("countsetsteam1"),
                    resultSet.getInt("countsetsteam2"),
                    resultSet.getString("result"));
            list.add(play);
        }
        return list;
    }
}
