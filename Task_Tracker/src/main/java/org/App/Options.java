package org.App;

import java.time.LocalDate;
import java.util.Scanner;
/** Handling adding,updating,deleting data collecting and sending it where needed*/
public class Options {
    private String id;
    private String description;
    private LocalDate date;
    private String status;
    private String oldid;
    private String[] changingstatus;

    public Options() {
        // Constructor left empty — logic moved to methods
    }

    public void addDetails(Scanner userInput) {
        collectTaskDetails(userInput);
        new Changes_json().addTask(id, date.toString(), status,description);
    }

    public void updateDetails(Scanner userInput) {
        System.out.print("What is the current id of the task you wish to update: ");
        this.oldid = userInput.nextLine().trim();
        if (!this.oldid.isEmpty()){
            System.out.print("What would the new id be?: \n");
            collectTaskDetails(userInput);
            new Changes_json().updateTask(this.oldid, this.id, this.status,this.description);
        }
        else{
            System.out.print("id cannot be empty \n");
        }

    }

    public void deleteDetails(Scanner userInput) {
        System.out.print("What is the current id of the task you wish to delete: ");
        this.id = new Task_ID(userInput).getTaskid();
        this.date = new Task_Date(userInput).getTaskDate();
        this.status = new Task_Status(userInput).getTaskstatus();

        new Changes_json().deleteTask(id, date.toString());
    }
    public void gettingStatusDetials(Scanner userinput){
        System.out.println("What is the id and what is the status you want it to be: ");
        System.out.println("There are only 3 states of the status (Not-Started,In-progress , Done)");
        System.out.println("ect-- moving In-progress ");
        System.out.println("Your choice: ");
        this.changingstatus = userinput.nextLine().split(" ");
        String changedtoString = changingstatus[1].toString().toLowerCase();
        if (changedtoString.equals("not-started") || changedtoString.equals("in-progress") || changedtoString.equals("done")){
            this.id = changingstatus[0].toString();
            this.status = changingstatus[1].toString();
            new Changes_json().markAsDone(id, this.status.toLowerCase());
        }
        else{
            System.out.println("Wrong input please try again");
        }

    }

    /**
     * Helper method to collect task id, date, and status.
     */
    private void collectTaskDetails(Scanner userInput) {
        this.id = new Task_ID(userInput).getTaskid();
        this.date = new Task_Date(userInput).getTaskDate();
        this.status = new Task_Status(userInput).getTaskstatus();
        this.description = new Task_Description(userInput).getTaskDiscription();
    }
    public void listAllTasks(){
       new Changes_json().listTasks();

    }
    public void listDoneTasks(){
        new Changes_json().listTasksDone();

    }
    public void listNotStartTasks(){
        new Changes_json().listTasksNotSarted();

    }
    public void listInProgressTasks(){
        new Changes_json().listTasksInProgress();

    }
}
