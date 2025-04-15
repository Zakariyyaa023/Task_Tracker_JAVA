package org.App;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class Test_File_System {
    final File json_file = new File("data.json");
    final Changes_json json_file_exists = new Changes_json();



    @Test
    void Test_File_exist(){
        json_file_exists.createJsonStorage();
        assertTrue(json_file.exists(), "The file should exist.");
    }
    @Test
    void Test_save_Delete_json_data() throws IOException {
        json_file_exists.addTask("Name", LocalDate.now().toString(), "in Progress","this is a short des");
        String content = new String(Files.readAllBytes(Paths.get(json_file.getPath())), StandardCharsets.UTF_8);
        assertTrue(content.contains("Name"), "The file should contain 'Name'.");
        assertTrue(content.contains(LocalDate.now().toString()), "The file should contain 'yyyy-mm-dd'.");
        assertTrue(content.contains("status"), "The file should contain 'status'.");
        assertTrue(content.contains("this is a short des"), "The file should contain 'this is a short des'.");
        assertTrue(content.contains("last updated"), "The file should contain 'yyyy-mm-dd'.");
        json_file_exists.deleteTask("Name", LocalDate.now().toString());


    }
    @Test
    void Test_edit_Delete_json_data() throws IOException {
        json_file_exists.addTask("Name", "2025-01-01", "Not Started","this is a short des");
        json_file_exists.updateTask("Name","game", "In Progress","this is a short des");
        String content = new String(Files.readAllBytes(Paths.get(json_file.getPath())), StandardCharsets.UTF_8);
        assertTrue(content.contains("game"), "The file should contain 'Name'.");
        assertTrue(content.contains("2025-01-01"), "The file should contain '2025-01-01'.");
        assertTrue(content.contains("status"), "The file should contain 'Progress'.");
        assertTrue(content.contains("last updated"),"The file should contain 'last updated'.");
        json_file_exists.deleteTask("game", "2025-01-01");
    }
    @Test
    void Testing_Marking_Done()throws IOException{
        json_file_exists.addTask("Name", "2100-12-10", "Not started","this is a short des");
        json_file_exists.markAsDone("Name", "In progress");
        String content = new String(Files.readAllBytes(Paths.get(json_file.getPath())), StandardCharsets.UTF_8);
        assertTrue(content.contains("In progress"), "The file should contain 'In progress'.");
        json_file_exists.deleteTask("Name", "2100-12-10");

    }

}
