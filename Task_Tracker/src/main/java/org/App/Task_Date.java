package org.App;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
/** getting a date from a user that is used for Adding,updating and deleting a task */
public class Task_Date {
    public LocalDate finalDate;
    public Task_Date(Scanner user_date){
//        A while loop is used to check if the format is correct.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            // Try to parse the input string into a LocalDate
            LocalDate date = LocalDate.parse(LocalDate.now().toString(), formatter);
            setTaskDate(date);

        } catch (DateTimeParseException e) {
            // If the input is not a valid date, catch the exception
            System.out.println(e);

        }
    }


    public LocalDate getTaskDate(){
        return this.finalDate;
    }
    public void setTaskDate(LocalDate user_TaskDate){
        this.finalDate = user_TaskDate;
    }
}
