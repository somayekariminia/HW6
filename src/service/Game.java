package service;

import model.Play;

public interface Game {
    void addPlayToTable(Play play);
    void deletePlayOfTable(String name);
    void getPlaysOfTable(String name);


}
