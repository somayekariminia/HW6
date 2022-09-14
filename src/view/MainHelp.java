package view;

import model.FootballClub;
import model.Play;
import model.VolleyballClub;
import service.GameFootballImpl;
import service.GameVolleyballImp;
import service.League;
import service.LeagueFootballImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHelp {
Play play;
FootballClub footballClub;
VolleyballClub volleyballClub;
LeagueFootballImp leagueFootballImp=new LeagueFootballImp();
List<Play> plays=new ArrayList<>();
Scanner scanner=new Scanner(System.in);
GameVolleyballImp gameVolleyballImp=new GameVolleyballImp();
GameFootballImpl gameFootball=new GameFootballImpl();
List<FootballClub>list=new ArrayList<>();
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
    public void leagueFootball() throws SQLException {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                                                       ");
        System.out.println("1: add \n 2: delet \n 3: addgame \n 4: seetheclub \n 5: seeTableClubs\n 6: exite");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String answer = "";
        while (!answer.equals("exit")) {
            switch (choice) {
                case 1:
                   FootballClub footballClub1=getNewFootballClub();
                   leagueFootballImp.addClubToLeague(footballClub1);
                    System.out.println(" add theclub ");
                    break;
                case 2:
                    System.out.println(" enter name will delete team");
                    String name = scanner.next();
                   leagueFootballImp.removeTheClubOfLeague(name);
                    System.out.println("delete the club");
                    break;
                case 3:
                   Play play1=getNewPlayFootball();
                   leagueFootballImp.addGamesBetweenTwoClub(play);
                    break;
                case 4:
                    System.out.println(" enter name team will view ");
                    String name1 = scanner.next();
                    FootballClub club= (FootballClub) leagueFootballImp.viewInformationClub(name1);
                    System.out.println(club.toString());
                    break;
                case 5:
                    list=null;
                    list=leagueFootballImp.seeTheLeagueTable();
                    for (FootballClub football:list) {
                        System.out.println(football.toString());
                    }
                    break;
                default:
                    System.out.println("for exite enter exit");
                    answer = scanner.next();
                    break;
            }
        }
    }
}
