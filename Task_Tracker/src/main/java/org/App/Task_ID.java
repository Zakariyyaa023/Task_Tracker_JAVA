package org.App;

import java.util.Scanner;
/** Getting Task id ,used for Adding,updating or deleting a task **/
public class Task_ID {
    private String TaskId;

    public Task_ID(Scanner user_data) {
//        A while loop is used until a id is given for a task.
        while (true){
        System.out.println("id of task?: ");
        System.out.print("Your choice: ");

        String userInput = user_data.nextLine();

        if (userInput.isEmpty()) {
            System.out.println("Task id cannot be empty.");
        } else {
            setTaskid(userInput);
            break;
        }}
    }

    public String getTaskid() {
        return TaskId;
    }

    public void setTaskid(String user_taskid) {
        this.TaskId = user_taskid;
    }
}
