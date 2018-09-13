package FCapp;

import FCapp.FClogic.FileHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        FileHandler FH = new FileHandler("FH");

        System.out.print("Type path to original json file:");
        Scanner in = new Scanner(System.in);

        String FirstFileName;
        String SecondFileName;

        FirstFileName = in.nextLine();
        System.out.print("Type path to new json file:");

        SecondFileName = in.nextLine();

        FH.Work(FirstFileName,SecondFileName);
    }
}
