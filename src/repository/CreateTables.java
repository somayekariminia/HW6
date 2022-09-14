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
                " countwin int,countloss int," +
                " countequal int ,score decimal)");
        preparedStatement.executeUpdate();
    }
    public void creatTablePlayFootball() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE table playsFootball(id  SERIAL PRIMARY KEY NOT NULL," +
                "team1 varchar(50),team2 varchar(50)," +
                "count_team1 int,count_team2 int," +
                "result varchar(10))");
        preparedStatement.executeUpdate();
    }
    public void creatVolleyballTable() throws SQLException, SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE volleyball( id  SERIAL PRIMARY KEY NOT NULL," +
                "name VARCHAR(50) unique not null ," +
                " countPlay int," +
                " setsWin int," +
                " setsLoss int," +
                " countWin int," +
                "countLoss int," +
                "score decimal)");
        preparedStatement.executeUpdate();
    }
   public void creatPlaysVolleyballTable() throws SQLException {
       Connection connection = GetConnection.getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement("CREATE table playvolleyball(id  SERIAL PRIMARY KEY NOT NULL," +
               "team1 varchar(50),team2 varchar(50)," +
               "countSetsteam1 int,countSetsteam2 int," +
               "result varchar(10))");
       preparedStatement.executeUpdate();
   }
   }

