package repository;

import model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {
    public void creat() throws SQLException, SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE football( id  SERIAL PRIMARY KEY NOT NULL," +
                "name VARCHAR(50) unique not null ," +
                " countPlay int," +
                " goalAgainst int," +
                " goalForCount int," +
                " diffgoal int," +
                " countWin int,countLoss int," +
                " countEqual int ,score decimal)");
        preparedStatement.executeUpdate();
    }
    public void creatTablePlay() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE table playsFootball(id  SERIAL PRIMARY KEY NOT NULL," +
                "team1 varchar(50),team2 varchar(50)," +
                "count_team1 int,count_team2 int," +
                "result varchar(10))");
        preparedStatement.executeUpdate();
    }
    public void creatVolleyballTable() throws SQLException, SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE football( id  SERIAL PRIMARY KEY NOT NULL," +
                "name VARCHAR(50) unique not null ," +
                " countPlay int," +
                " setWin int," +
                " setLoss int," +
                " countWin int,countLoss int," +
                "score decimal)");
        preparedStatement.executeUpdate();
    }
}
