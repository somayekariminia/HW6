package service;

import model.Play;
import repository.PlaysVolleyballRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameVolleyballImp implements Game {
    PlaysVolleyballRepository playsVolleyballRepository=new PlaysVolleyballRepository();
    Play play;
    List<Play> playList=new ArrayList<>();
    @Override
    public void addPlayToTable(Play play) throws SQLException {
     playsVolleyballRepository.insertPlayVolleyball(play);
    }

    @Override
    public void deletePlayOfTable(String name) throws SQLException {
        playsVolleyballRepository.deletePlayVolleyball(name);
    }
    @Override
    public List<Play> getPlaysOfTable(String name) throws SQLException {
        playList=playsVolleyballRepository.getListOfPlays(name);
        return playList;
    }
}
