import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    // Ajouter une tâche
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Supprimer une tâche
    public boolean deleteTask(int id) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            return true;
        } else {
            return false;
        }
    }

    // Marquer une tâche comme terminée
    public boolean markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    // Afficher la liste des tâches
    public String displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche à afficher.");
        } else {
            for (Task task : tasks) {
                String status = task.isCompleted() ? "Terminée" : "En cours";
                System.out.println(task.getId() + ". " + task.getDescription() + " - " + status);
            }
        }
        return null;
    }

    // Retourner la liste des tâches
    public List<Task> getTasks() {
        return tasks;
    }


}