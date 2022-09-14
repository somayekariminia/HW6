package view;

import model.FootballClub;
import model.Play;
import model.VolleyballClub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHelp {
Play play;
FootballClub footballClub;
VolleyballClub volleyballClub;
List<Play> plays=new ArrayList<>();
Scanner scanner=new Scanner(System.in);
 public Play getNewPlayFootball(){
     System.out.println(" enter 'name' team first : ");
     String nameFirstTeam=scanner.nextLine();
     System.out.println(" enter 'name' team second : ");
     String nameSecondTeam=scanner.nextLine();
     System.out.println("enter count goal first team:");
     int goalsFirstTeam=Integer.parseInt(scanner.nextLine());
     System.out.println("enter count goal secound team:");
     int goalsSecondTeam=Integer.parseInt(scanner.nextLine());
     play=new Play(nameFirstTeam,nameSecondTeam,goalsFirstTeam,goalsSecondTeam);
     return play;
 }
    public Play getNewPlayVolleyball() {
        System.out.println(" Enter 'Name' First Team : ");
        String nameFirstTeam = scanner.nextLine();
        System.out.println(" Enter 'Name' team second : ");
        String nameSecondTeam = scanner.nextLine();
        System.out.println("Enter Count Sets First Team:");
        int goalsFirstTeam = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Count Sets Secound Team:");
        int goalsSecondTeam = Integer.parseInt(scanner.nextLine());
        play = new Play(nameFirstTeam, nameSecondTeam, goalsFirstTeam, goalsSecondTeam);
        return play;
    }
    public FootballClub getNewFootballClub(){
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
}
