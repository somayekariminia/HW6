package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class playFootballRepository {
    public void creatTablePlay() throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("CREATE table play(id  SERIAL PRIMARY KEY NOT NULL,team1 varchar(50),team2 varchar(50),count_team1 int,count_team2 int,state varchar(10))");
        preparedStatement.executeUpdate();
    }

}
