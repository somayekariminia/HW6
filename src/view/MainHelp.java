package view;

import model.FootballClub;
import model.Play;
import model.VolleyballClub;
import service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHelp {
    Play play;
    FootballClub footballClub;
    VolleyballClub volleyballClub;
    LeagueFootballImp leagueFootballImp = new LeagueFootballImp();
    List<Play> plays = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    GameVolleyballImp gameVolleyballImp = new GameVolleyballImp();
    GameFootballImpl gameFootball = new GameFootballImpl();
    LeagueVolleyballImp leagueVolleyballImp = new LeagueVolleyballImp();

    public Play getNewPlayFootball() throws SQLException {
        System.out.println(" enter 'name' team first : ");
        String nameFirstTeam = scanner.nextLine();
        System.out.println(" enter 'name' team second : ");
        String nameSecondTeam = scanner.nextLine();
        System.out.println("enter count goal first team:");
        int goalsFirstTeam = Integer.parseInt(scanner.nextLine());
        System.out.println("enter count goal secound team:");
        int goalsSecondTeam = Integer.parseInt(scanner.nextLine());
        play = new Play(nameFirstTeam, nameSecondTeam, goalsFirstTeam, goalsSecondTeam);
        gameFootball.addPlayToTable(play);
        Play play1 = new Play(nameSecondTeam, nameFirstTeam, goalsSecondTeam, goalsFirstTeam);
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
        Play play1 = new Play(nameSecondTeam, nameFirstTeam, setsSecondTeam, setsFirstTeam);
        gameVolleyballImp.addPlayToTable(play1);
        return play;
    }

    public FootballClub getNewFootballClub() throws SQLException {
        System.out.println(" Enter Name club :");
        String name = scanner.nextLine();
        System.out.println(" Enter Number plays Team:");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            play = getNewPlayFootball();
            plays.add(play);
        }
        return footballClub = new FootballClub(name, plays);
    }

    public VolleyballClub getNewVolleyballClub() throws SQLException {
        System.out.println(" Enter Name club :");
        String name = scanner.nextLine();
        System.out.println(" Enter Number plays Team:");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            play = getNewPlayVolleyball();
            plays.add(play);
        }
        return volleyballClub = new VolleyballClub(name, plays);
    }

    public void leagueFootball() throws SQLException {
        System.out.println("----------------------------------------------------------------------");
       // System.out.println("                                                                       ");
        System.out.println(" 1:  addClub \n 2: deleteClub \n 3: addgameToLeage \n 4: seetheclub \n 5: seeTableClubs\n 6: exite");
        List<FootballClub> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("yes")) {
            System.out.println("enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    FootballClub footballClub1 = getNewFootballClub();
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
                    Play play1 = getNewPlayFootball();
                    leagueFootballImp.addGamesBetweenTwoClub(play1);
                    break;
                case 4:
                    System.out.println(" enter name team will view ");
                    String name1 = scanner.next();
                    FootballClub club = (FootballClub) leagueFootballImp.viewInformationClub(name1);
                    System.out.println(club.toString());
                    break;
                case 5:
                    list = null;
                    list = leagueFootballImp.seeTheLeagueTable();
                    for (FootballClub football : list) {
                        System.out.println(football.toString());
                    }
                    break;
                default:
                    System.out.println("enter yes");
                    answer = scanner.next();
            }
        }
    }

    public void leagueVolleyball() throws SQLException {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                                                       ");
        // System.out.println("1: add \n 2: delet \n 3: addgame \n 4: seetheclub \n 5: seeTableClubs\n 6: exite");
        List<VolleyballClub> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("yes"))
        {
            System.out.println("1: addclub \n 2: deleteClub \n 3: addgameToLeague\n 4: seetheclub \n 5: seeTableClubs\n 6: exite");
            System.out.println("enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    VolleyballClub volleyballClub1 = getNewVolleyballClub();
                    leagueVolleyballImp.addClubToLeague(volleyballClub1);
                    System.out.println(" add theclub ");
                }
                case 2 -> {
                    System.out.println(" enter name will delete team");
                    String name = scanner.next();
                    leagueVolleyballImp.removeTheClubOfLeague(name);
                    System.out.println("delete the club");
                }
                case 3 -> {
                    Play play1 = getNewPlayVolleyball();
                    leagueVolleyballImp.addGamesBetweenTwoClub(play1);
                }
                case 4 -> {
                    System.out.println(" enter name team will view ");
                    String name1 = scanner.next();
                    VolleyballClub club = (VolleyballClub) leagueVolleyballImp.viewInformationClub(name1);
                    System.out.println(club.toString());
                }
                case 5 -> {
                    list = null;
                    list = leagueVolleyballImp.seeTheLeagueTable();
                    for (VolleyballClub volleyballClub2 : list) {
                        System.out.println(volleyballClub2.toString());
                    }
                }
                default -> {
                    answer="yes";
                }
            }
        }
    }
}


