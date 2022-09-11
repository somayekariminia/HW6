package repository;

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

}
