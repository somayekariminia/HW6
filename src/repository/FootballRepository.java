package repository;

import model.FootballClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
