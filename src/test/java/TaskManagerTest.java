import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testFonction1() {
        String input = "1\nTester la tâche\n2\n1\n4\n5\n";
        ByteArrayInputStream inputContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputContent);

        TaskList taskList = new TaskList();
        TaskManager taskManager = new TaskManager(taskList);
        taskManager.handleUserInput();

        String output = outContent.toString();
        assertTrue(output.contains("Tâche ajoutée."));
        assertTrue(output.contains("Tâche marquée comme terminée."));
        assertTrue(output.contains("1. Tester la tâche - Terminée"));
    }
    @Test
    public void testAjoutEtSupp() {
        String input = "1\nTâche à supprimer\n3\n1\n4\n5\n";
        ByteArrayInputStream inputContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputContent);

        TaskList taskList = new TaskList();
        TaskManager taskManager = new TaskManager(taskList);
        taskManager.handleUserInput();

        String output = outContent.toString();
        assertTrue(output.contains("Tâche ajoutée."));
        assertTrue(output.contains("Tâche supprimée."));
        assertTrue(output.contains("Aucune tâche à afficher."));
    }


}
