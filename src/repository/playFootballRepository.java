package repository;

import model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class playFootballRepository {
    public void creatTablePlay() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE table play(id  SERIAL PRIMARY KEY NOT NULL,team1 varchar(50),team2 varchar(50),count_team1 int,count_team2 int,state varchar(10))");
        preparedStatement.executeUpdate();
    }
    public void insert(Play play) throws SQLException {
        String str = "insert into play values(id,?,?,?,?,?)";
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setString(1, play.getNameTeamFirst());
        preparedStatement.setString(2, play.getNameTeamSecond());
        preparedStatement.setInt(3, play.getGoalCountFirst());
        preparedStatement.setInt(4, play.getGoalCountSecond());
        preparedStatement.setString(5, play.getResult());
        preparedStatement.executeUpdate();
    }


}
