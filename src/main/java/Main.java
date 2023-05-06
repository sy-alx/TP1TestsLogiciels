public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        TaskManager taskManager = new TaskManager(taskList);
        taskManager.handleUserInput();
    }
}