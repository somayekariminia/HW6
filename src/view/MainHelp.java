package view;

import model.FootballClub;
import model.Play;
import model.VolleyballClub;
import service.GameFootballImpl;
import service.GameVolleyballImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHelp {
Play play;
FootballClub footballClub;
VolleyballClub volleyballClub;
List<Play> plays=new ArrayList<>();
Scanner scanner=new Scanner(System.in);
GameVolleyballImp gameVolleyballImp=new GameVolleyballImp();
GameFootballImpl gameFootball=new GameFootballImpl();
 public Play getNewPlayFootball() throws SQLException {
     System.out.println(" enter 'name' team first : ");
     String nameFirstTeam=scanner.nextLine();
     System.out.println(" enter 'name' team second : ");
     String nameSecondTeam=scanner.nextLine();
     System.out.println("enter count goal first team:");
     int goalsFirstTeam=Integer.parseInt(scanner.nextLine());
     System.out.println("enter count goal secound team:");
     int goalsSecondTeam=Integer.parseInt(scanner.nextLine());
     play=new Play(nameFirstTeam,nameSecondTeam,goalsFirstTeam,goalsSecondTeam);
     gameFootball.addPlayToTable(play);
     Play play1=new Play(nameSecondTeam,nameFirstTeam,goalsSecondTeam,goalsFirstTeam);
     gameFootball.addPlayToTable(play1);
     return play;
 }
    public Play getNewPlayVolleyball() throws SQLException {
        System.out.println(" Enter 'Name' First Team : ");
        String nameFirstTeam = scanner.nextLine();
        System.out.println(" Enter 'Name' team second : ");
        String nameSecondTeam = scanner.nextLine();
        System.out.println("Enter Count Sets First Team:");
        int setsFirstTeam = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Count Sets Secound Team:");
        int setsSecondTeam = Integer.parseInt(scanner.nextLine());
        play = new Play(nameFirstTeam, nameSecondTeam, setsFirstTeam, setsSecondTeam);
        gameVolleyballImp.addPlayToTable(play);
        Play play1=new Play(nameSecondTeam,nameFirstTeam,setsSecondTeam,setsFirstTeam);
        gameVolleyballImp.addPlayToTable(play1);
        return play;
    }
    public FootballClub getNewFootballClub() throws SQLException {
        System.out.println(" Enter Name club :");
        String name=scanner.nextLine();
        System.out.println(" Enter Number plays Team:");
        int count=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <=count ; i++) {
            play=getNewPlayFootball();
            plays.add(play);
        }
        return footballClub=new FootballClub(name,plays);
    }
    public FootballClub getNewVolleyballClub() throws SQLException {
        System.out.println(" Enter Name club :");
        String name=scanner.nextLine();
        System.out.println(" Enter Number plays Team:");
        int count=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <=count ; i++) {
            play=getNewPlayVolleyball();
            plays.add(play);
        }
        return footballClub=new FootballClub(name,plays);
    }
}
