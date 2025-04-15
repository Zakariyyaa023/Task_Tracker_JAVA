package org.App;

import java.util.Scanner;
/** getting the current progress of a task and there are only 3 valid options */
public class Task_Status {
    public String  task_status;
    public Task_Status(Scanner user_status){
        while (true){
        System.out.println("What is the current status of the Task: (eg:1).");
        System.out.println("1: Not Started");
        System.out.println("2: In progress");
        System.out.println("3: Done");
        System.out.print("Your choice: ");

        String userInput = user_status.nextLine().replace(" ","");

            switch (userInput.trim().toLowerCase()) {
                case "1":
                    setTaskstatus("Not Started");
                    return;
                case "2":
                    setTaskstatus("In progress");
                    return;
                case "3":
                    setTaskstatus("Done");
                    return;
                case "notstarted":
                    setTaskstatus("Not Started");
                    return;
                case "inprogress":
                    setTaskstatus("in progress");
                    return;
                case "done":
                    setTaskstatus("Done");
                    return;
                default:
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    System.out.println();
            }
        }
    }

    public String getTaskstatus(){
        return task_status;
    }

    public void setTaskstatus(String user_task_status){
        this.task_status = user_task_status;
    }
}
