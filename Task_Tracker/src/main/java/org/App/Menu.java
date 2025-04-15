package org.App;

import java.util.Scanner;

public class Menu {
    public Menu(Scanner option){
        while (true){
            System.out.println("What would you like to do choose a option from below.");
            System.out.println("1: Add to your task board.");
            System.out.println("2: Update your task board.");
            System.out.println("3: delete a task from your task board.");
            System.out.println("4: Change status of task.");
            System.out.println("5: List all tasks");
            System.out.println("6: List all tasks that are done");
            System.out.println("7: List all tasks that are Not Started");
            System.out.println("8: List all tasks that are In progress");
            System.out.println("-----------------------------------------");
            System.out.print("Your choice: ");

            String userInput = option.nextLine().replace(" ","");
            switch (userInput.toLowerCase().trim()){
                case "add":
                    new Options().addDetails(option);
                    break;
                case "update":
                    new Options().updateDetails(option);
                    break;
                case "delete":
                    new Options().deleteDetails(option);
                    break;
                case "1":
                    new Options().addDetails(option);
                    break;
                case "2":
                    new Options().updateDetails(option);
                    break;
                case "3":
                    new Options().deleteDetails(option);
                    break;
                case "changestatus":
                    new Options().gettingStatusDetials(option);
                    break;
                case "4":
                    new Options().gettingStatusDetials(option);
                    break;
                case "5":
                    new Options().listAllTasks();
                    break;
                case "list":
                    new Options().listAllTasks();
                    break;
                case "6":
                    new Options().listDoneTasks();
                    break;
                case "done":
                    new Options().listDoneTasks();
                    break;
                case "7":
                    new Options().listNotStartTasks();
                    break;
                case "notstarted":
                    new Options().listNotStartTasks();
                    break;
                case "8":
                    new Options().listInProgressTasks();
                    break;
                case "inprogress":
                    new Options().listInProgressTasks();
                    break;
                default:
                    System.out.println("you have to enter a number");
            }
        }
    }

}
