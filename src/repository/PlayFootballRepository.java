package repository;

import model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class playFootballRepository {
    public void creatTablePlay() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE table playsFootball(id  SERIAL PRIMARY KEY NOT NULL," +
                "team1 varchar(50),team2 varchar(50)," +
                "count_team1 int,count_team2 int," +
                "state varchar(10)," +
                "id_football int," +
                "foreign key (id_football) references playsFootball(id))");
        preparedStatement.executeUpdate();
    }
    public void insert(Play play) throws SQLException {
        String str = "insert into playsFootball values(id,?,?,?,?,?)";
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
    public List<Play> select() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from playsFootball inner join fooball on playsFootball.id=football.id");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Play> list = new ArrayList<>();
        while (resultSet.next()) {
            Play play = new Play(resultSet.getInt(1),resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),resultSet.getString(5));
            list.add(play);
        }
        return list;
    }
}
