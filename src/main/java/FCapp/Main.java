package FCapp;

import FCapp.FClogic.FileHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("Type name of file:");
        Scanner in = new Scanner(System.in);
        String filename;
        filename = in.nextLine();
        FileHandler FH = new FileHandler("FH");
        FH.Work(filename);
    }
} ///Users/pterekhov/TestProjects/Quest1/small.json
