import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    public void testDisplayTasks() {
        TaskList taskList = new TaskList();

        // Ajouter des tâches à la liste
        Task task1 = new Task(1, "Tâche 1");
        Task task2 = new Task(2, "Tâche 2");
        taskList.addTask(task1);
        taskList.addTask(task2);

        // Marquer la deuxième tâche comme terminée
        task2.setCompleted(true);

        // Appeler la méthode displayTasks
        String taskListDisplay = taskList.displayTasks();

        // Construire la chaîne de caractères attendue
        String expectedDisplay = "1. Tâche 1 - En cours\n" +
                "2. Tâche 2 - Terminée";

        // Vérifier que la chaîne de caractères générée correspond à ce que nous attendons
        assertEquals(expectedDisplay, taskListDisplay,
                String.format("Le format d'affichage de la liste des tâches est incorrect. Attendu : '%s', Obtenu : '%s'", expectedDisplay, taskListDisplay));
    }

}
