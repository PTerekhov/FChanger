package FCapp;

import FCapp.FClogic.FH.FH_json.FileHandler_json;
import FCapp.FClogic.FH.FH_xlsx.FileHandler_xlsx;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        String FirstFileName;
        String SecondFileName;

        System.out.print("Path to file:");
        FirstFileName = in.nextLine();
        System.out.print("Path to new file:");
        SecondFileName = in.nextLine();

        if(FirstFileName.contains(".json")) {
            FileHandler_json FH = new FileHandler_json();
            FH.Work(FirstFileName,SecondFileName);
        }
        else if(FirstFileName.contains(".xlsx")){
            FileHandler_xlsx FH = new FileHandler_xlsx();
            FH.Work(FirstFileName,SecondFileName);
        }

    }


}
