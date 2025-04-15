package org.App;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;

/**
 * Manages tasks stored in a JSON file (add, update, delete).
 */
public class Changes_json {
    private final File file = new File("data.json");

    public Changes_json() {
        if (!file.exists()) {
            createJsonStorage();
        } else {
            System.out.println("Loading file to write/read your data");
        }
    }

    protected void createJsonStorage() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create JSON file.", e);
        }
    }

    public void addTask(String id, String date, String status,String description) {
        JSONArray taskList = loadTasks();

        JSONObject task = new JSONObject();
        task.put("Task id", id);
        task.put("Task created", date);
        task.put("Task status", status);
        task.put("description",description);
        task.put("last updated",date);

        taskList.add(task);
        saveTasks(taskList);
        System.out.println("Task added successfully!");
    }
    public void markAsDone(String id,String newstatus){
        boolean taskexist = false;
        JSONArray taskList = loadTasks();
        for (Object obj : taskList) {
            JSONObject task = (JSONObject) obj;
            if (id.equals(task.get("Task id"))) {
                task.put("Task status", newstatus);
                saveTasks(taskList);
                taskexist = true;
                break;
            }
        }
        if (!taskexist){
            System.out.println("task does not exist");
        }
    }

    public void updateTask(String oldId, String newId,String newstatus,String description) {
        JSONArray taskList = loadTasks();
        boolean found = false;
        for (Object obj : taskList) {
            JSONObject task = (JSONObject) obj;
            if (oldId.equals(task.get("Task id"))) {
                task.put("Task id", newId);
                task.put("Task id", newId);
                task.put("Task status", newstatus);
                task.put("last updated", LocalDate.now().toString());
                task.put("description", description);
                found = true;
                break;
            }
        }

        if (found) {
            saveTasks(taskList);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task with the specified id not found.");
        }
    }

    public void deleteTask(String id, String date) {
        JSONArray taskList = loadTasks();

        for (int i = 0; i < taskList.size(); i++) {
            JSONObject task = (JSONObject) taskList.get(i);
            if (id.equals(task.get("Task id")) && date.equals(task.get("Task created"))) {
                taskList.remove(i);
                saveTasks(taskList);
                System.out.println("Task deleted successfully!");
                return;
            }

        }

        System.out.println("Task not found.");
    }

    private JSONArray loadTasks() {
        JSONArray tasks = new JSONArray();

        if (file.exists() && file.length() > 0) {
            try (FileReader reader = new FileReader(file)) {
                tasks = (JSONArray) new JSONParser().parse(reader);
            } catch (IOException | ParseException e) {
                System.out.println("Failed to load tasks: " + e.getMessage());
            }
        }

        return tasks;
    }
    private void saveTasks(JSONArray tasks) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(tasks.toJSONString());
        } catch (IOException e) {
            System.out.println("Failed to save tasks: " + e.getMessage());
        }
    }

    protected void listTasks() {
        JSONArray taskList = loadTasks();
        System.out.println("Task Details:");
        for (Object obj : taskList) {
            JSONObject task = (JSONObject) obj;
            System.out.println("  ID           : " + task.get("Task id"));
            System.out.println("  Status       : " + task.get("Task status"));
            System.out.println("  Created      : " + task.get("Task created"));
            System.out.println("  Last Updated : " + task.get("last updated"));
            System.out.println("  Description  : " + task.get("description"));
            System.out.println();
        }
    }
    protected void listTasksDone() {
        JSONArray taskList = loadTasks();
        System.out.println("Tasks marked as 'done':");

        for (Object obj : taskList) {
            JSONObject task = (JSONObject) obj;

            // Check for "done" status using correct key
            if ("done".equals(task.get("Task status"))) {
                System.out.println("  ID           : " + task.get("Task id"));
                System.out.println("  Status       : " + task.get("Task status"));
                System.out.println("  Created      : " + task.get("Task created"));
                System.out.println("  Last Updated : " + task.get("last updated"));
                System.out.println("  Description  : " + task.get("description"));
                System.out.println();
            }
        }
    }
    protected void listTasksNotSarted() {
        JSONArray taskList = loadTasks();
        System.out.println("Tasks marked as 'Not Started':");

        for (Object obj : taskList) {
            JSONObject task = (JSONObject) obj;

            // Check for "done" status using correct key
            if ("not-started".equals(task.get("Task status"))) {
                System.out.println("  ID           : " + task.get("Task id"));
                System.out.println("  Status       : " + task.get("Task status"));
                System.out.println("  Created      : " + task.get("Task created"));
                System.out.println("  Last Updated : " + task.get("last updated"));
                System.out.println("  Description  : " + task.get("description"));
                System.out.println();
            }
        }
    }
    protected void listTasksInProgress() {
        JSONArray taskList = loadTasks();
        System.out.println("Tasks marked as 'In Progress':");

        for (Object obj : taskList) {
            JSONObject task = (JSONObject) obj;

            // Check for "done" status using correct key
            if ("in-progress".equals(task.get("Task status"))) {
                System.out.println("  ID           : " + task.get("Task id"));
                System.out.println("  Status       : " + task.get("Task status"));
                System.out.println("  Created      : " + task.get("Task created"));
                System.out.println("  Last Updated : " + task.get("last updated"));
                System.out.println("  Description  : " + task.get("description"));
                System.out.println();
            }
        }
    }

}
