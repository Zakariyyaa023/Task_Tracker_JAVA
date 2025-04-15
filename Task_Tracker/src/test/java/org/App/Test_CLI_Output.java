package org.App;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Test_CLI_Output {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));

    }

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);

    }
    /** Testing user Task name input */
    @Test
    void Testing_task_id(){
        String simulatedInput = "Name\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        Task_ID taskDate = new Task_ID(scanner);
        String expectedOutput = "id of task?: \r\n"+
                "Your choice: ";;
        assertEquals(expectedOutput, outputStream.toString());
    }
    @Test
    void Testing_task_id_invalid(){
        String simulatedInput = "\nname";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        Task_ID taskDate = new Task_ID(scanner);
        String expectedOutput = "id of task?: \r\n"+
                "Your choice: "+
                "Task id cannot be empty.\r\n" +
                "id of task?: \r\n"+
                "Your choice: ";

        assertEquals(expectedOutput, outputStream.toString());

    }
    /** Test the user description */
    @Test
    void Testing_discription(){
        String simulatedInput = "this is a short one\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        Task_Description desription = new Task_Description(scanner);
        String expectedOutput = "Description of task?: \r\n"+
                "Your choice: ";
        assertEquals(expectedOutput, outputStream.toString());
    }
    @Test
    void Testing_empty_task_des(){
        String simulatedInput = "\nname";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        Task_Description taskDate = new Task_Description(scanner);
        String expectedOutput = "Description of task?: \r\n"+
                "Your choice: "+
                "Task Description cannot be empty.\r\n" +
                "Description of task?: \r\n"+
                "Your choice: ";
        assertEquals(expectedOutput, outputStream.toString());

    }


    @Test
    void Testing_User_status(){
        String simulatedInput = "1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        Task_Status status = new Task_Status(scanner);
        String expectedOutput = "What is the current status of the Task: (eg:1).\r\n" +
                "1: Not Started\r\n"+
                "2: In progress\r\n"+
                "3: Done\r\n"+
                "Your choice: ";
        assertEquals(expectedOutput, outputStream.toString());
    }

}