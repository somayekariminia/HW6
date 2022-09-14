package ir.maktab.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        MainHelp mainHelp=new MainHelp();
        System.out.println(" ");
        System.out.println("1: leagueFootball\n2: leagueVolleyball \n3: exit");
        int choice = scanner.nextInt();
        String answer = "";
        while (!answer.equals("exit")) {
            switch (choice) {
                case 1 -> {
                mainHelp.leagueFootball();
                }
                case 2 -> {
                 mainHelp.leagueVolleyball();
                }
                default -> {

                }
            }
        }
    }

}