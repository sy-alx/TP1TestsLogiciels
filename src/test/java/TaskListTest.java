import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskListTest {

    @Test
    public void testTaskListOperations() {
        TaskList taskList = new TaskList();

        // Ajouter des tâches à la liste
        Task task1 = new Task(1, "Tâche 1");
        Task task2 = new Task(2, "Tâche 2");
        taskList.addTask(task1);
        taskList.addTask(task2);

        // Vérifier que les tâches ont été ajoutées correctement
        assertEquals(2, taskList.getTasks().size(), "Le nombre de tâches ajoutées est incorrect.");

        // Marquer la deuxième tâche comme terminée
        assertTrue(taskList.markTaskAsCompleted(2), "La tâche n'a pas été marquée comme terminée.");
        assertTrue(task2.isCompleted(), "La tâche devrait être marquée comme terminée.");

        // Supprimer la première tâche
        assertTrue(taskList.deleteTask(1), "La tâche n'a pas été supprimée.");
        assertEquals(1, taskList.getTasks().size(), "Le nombre de tâches après suppression est incorrect.");
    }


}
