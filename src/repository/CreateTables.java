package repository;

import model.Play;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {
    public void creat() throws SQLException, SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE clup( id  SERIAL PRIMARY KEY NOT NULL," +
                "name VARCHAR(50) unique ," +
                " countPlay int," +
                " goalAgainst int," +
                " goalForCount int," +
                " diffgoal int," +
                " countWin int,countLoss int," +
                " countEqual int ,score decimal)");
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
}
