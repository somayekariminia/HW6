package service;

import model.Play;
import repository.PlaysFootballRepository;
import repository.PlaysVolleyballRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameFootballImpl implements Game{
PlaysFootballRepository playsFootballRepository=new PlaysFootballRepository();
    List<Play> plays=new ArrayList<>();
    @Override
    public void addPlayToTable(Play play) throws SQLException {
      playsFootballRepository.insert(play);
    }

    @Override
    public void deletePlayOfTable(String name) throws SQLException {
     playsFootballRepository.delete(name);
    }

    @Override
    public List<Play> getPlaysOfTable(String name) throws SQLException {
         return plays=playsFootballRepository.select(name);

    }
}
