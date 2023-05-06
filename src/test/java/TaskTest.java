import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {

    @Test
    public void TestCreationTask() {
        int id = 1;
        String description = "Tâche de test";
        Task task = new Task(id, description);

        assertEquals(id, task.getId(), "L'identifiant de la tâche doit correspondre à celui fourni.");
        assertEquals(description, task.getDescription(), "La description de la tâche doit correspondre à celle fournie.");
        assertFalse(task.isCompleted(), "L'état de la tâche doit être 'non terminée' par défaut.");
    }

    @Test
    public void TestTermineTask() {
        int id = 1;
        String description = "Tâche de test";
        Task task = new Task(id, description);

        task.setCompleted(true);

        assertTrue(task.isCompleted(), "L'état de la tâche doit être 'terminée' après avoir été défini comme tel.");
    }

    @Test
    public void TestIdUnique() {
        String description = "Tâche de test";
        Task task1 = new Task(1, description);
        Task task2 = new Task(2, description);

        assertNotEquals(task1.getId(), task2.getId(), "Les identifiants des deux tâches doivent être différents.");
    }

    @Test
    public void TestDescrp() {
        int id = 1;
        String description = "Tâche de test";
        String newDescription = "Nouvelle description de la tâche";
        Task task = new Task(id, description);

        task.setDescription(newDescription);

        assertEquals(newDescription, task.getDescription(), "La description de la tâche doit correspondre à la nouvelle description fournie.");
    }
}
