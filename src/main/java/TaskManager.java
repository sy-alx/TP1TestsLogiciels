import java.util.Scanner;

public class TaskManager {
    private TaskList taskList;

    public TaskManager(TaskList taskList) {
        this.taskList = taskList;
    }

    // Afficher le menu
    public void displayMenu() {
        System.out.println("Menu :");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Marquer une tâche comme terminée");
        System.out.println("3. Supprimer une tâche");
        System.out.println("4. Afficher la liste des tâches");
        System.out.println("5. Quitter");
        System.out.print("Entrez le numéro de l'action souhaitée : ");
    }

    // Gérer les entrées de l'utilisateur
    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Entrez la description de la tâche : ");
                    String description = scanner.nextLine();
                    Task newTask = new Task(taskList.getTasks().size() + 1, description);
                    taskList.addTask(newTask);
                    System.out.println("Tâche ajoutée.");
                    break;
                case 2:
                    System.out.print("Entrez l'ID de la tâche à marquer comme terminée : ");
                    int completedId = scanner.nextInt();
                    if (taskList.markTaskAsCompleted(completedId)) {
                        System.out.println("Tâche marquée comme terminée.");
                    } else {
                        System.out.println("Tâche introuvable.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'ID de la tâche à supprimer : ");
                    int deletedId = scanner.nextInt();
                    if (taskList.deleteTask(deletedId)) {
                        System.out.println("Tâche supprimée.");
                    } else {
                        System.out.println("Tâche introuvable.");
                    }
                    break;
                case 4:
                    taskList.displayTasks();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option du menu.");
            }
        }
        scanner.close();
    }
}