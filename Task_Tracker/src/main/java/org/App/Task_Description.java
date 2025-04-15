package org.App;

import java.util.Scanner;

public class Task_Description {
    protected String userDiscription;
    public Task_Description(Scanner user_data) {
//        A while loop is used until a id is given for a task.
        while (true){
            System.out.println("Description of task?: ");
            System.out.print("Your choice: ");
            String userInput = user_data.nextLine();

            if (userInput.isEmpty()) {
                System.out.println("Task Description cannot be empty.");
            } else {
                setTaskDiscription(userInput);
                break;
            }}
    }

    public String getTaskDiscription() {
        return userDiscription;
    }

    public void setTaskDiscription(String user_taskid) {
        this.userDiscription = user_taskid;
    }
}
