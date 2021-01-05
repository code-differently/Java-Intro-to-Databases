package com.codedifferently;

import com.codedifferently.database.DataBase;
import com.codedifferently.database.DataBaseConnectionException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private DataBase dataBase;
    private static Scanner scanner;

    private ArrayList<String> menu;
    public Main() throws DataBaseConnectionException {
        dataBase = new DataBase();
        scanner = new Scanner(System.in);
        initMenuOption();
    }

    private void initMenuOption(){
        menu = new ArrayList<>();
        menu.add("Exit");
        /**
         * Add your menu items here
         */
    }

    public Integer displayMenu(){
        int option = 0;
        for(int i = 0; i < menu.size(); i++){
            String menuOption = String.format("Press %d for %s", i, menu.get(i));
            System.out.println(menuOption);
        }
        option = scanner.nextInt();
        return option;
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            Boolean endProgram = false;
            System.out.println("Welcome to address book");
            while (!endProgram) {
                /* Your code goes here */
                int menuOption = main.displayMenu();

                switch(menuOption){
                    case 0:
                        System.out.println("Goodbye!!");
                        endProgram = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (DataBaseConnectionException e) {
            System.out.println("Your database could not be connected to.");
        }
    }
}
