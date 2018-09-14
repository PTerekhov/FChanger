package FCapp;

import FCapp.FClogic.FileHandler_json;
import FCapp.FClogic.FileHandler_xlsx;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int i=0;
        boolean b = true;
        Scanner in = new Scanner(System.in);

        String FirstFileName;
        String SecondFileName;


        while(b == true){


            System.out.print("Choose the type of file, you want to change: \n" + "1 - json \n" + "2 - xlsx \n" );

            i = getInt();

            if (i < 3) {

                switch (i) {
                    case 1:

                        FileHandler_json FHJ = new FileHandler_json();
                        System.out.print("Path to original json file:");
                        FirstFileName = in.nextLine();
                        System.out.print("Path to new json file:");
                        SecondFileName = in.nextLine();
                        FHJ.Work(FirstFileName, SecondFileName);
                        b = false;
                        break;

                    case 2:

                        FileHandler_xlsx FHX = new FileHandler_xlsx();
                        System.out.print("Path to original xlsx file:");
                        FirstFileName = in.nextLine();
                        System.out.print("Path to new xlsx file:");
                        SecondFileName = in.nextLine();
                        FHX.Work(FirstFileName, SecondFileName);
                        b = false;
                        break;

                    default:
                        break;

                }
            }
            System.out.println("Error. Please try again. \n");
        }


    }

    public static int getInt(){
        System.out.println("Write number:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Error. Please try again. \n");
            scanner.next();
            num = getInt();
        }
        return num;
    }

}
