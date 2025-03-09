import java.util.Scanner;

public class DailyTaskManager {
    private F_Array taskArray;
    private F_Stack taskStack;
    private F_LinkedList taskList;
    private Scanner scanner;

    public DailyTaskManager() {
        taskArray = new F_Array();
        taskStack = new F_Stack();
        taskList = new F_LinkedList();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== Daily Task Manager ===");
        System.out.println("1. View predefined tasks");
        System.out.println("2. Update predefined task");
        System.out.println("3. Mark task as completed");
        System.out.println("4. Undo task completion");
        System.out.println("5. Add task to dynamic list");
        System.out.println("6. Remove task from dynamic list");
        System.out.println("7. View dynamic task list");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    taskArray.displayTasks();
                    break;
                case 2:
                    updatePredefinedTask();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    undoTaskCompletion();
                    break;
                case 5:
                    addDynamicTask();
                    break;
                case 6:
                    removeDynamicTask();
                    break;
                case 7:
                    taskList.displayTasks();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private void updatePredefinedTask() {
        taskArray.displayTasks();
        System.out.print("Enter task index to update (1-" + taskArray.getTaskCount() + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new task: ");
        String newTask = scanner.nextLine();
        taskArray.updateTask(index, newTask);
    }

    private void markTaskCompleted() {
        taskArray.displayTasks();
        System.out.print("Enter task index to mark as completed (1-" + taskArray.getTaskCount() + "): ");
        int index = scanner.nextInt() - 1;
        
        if (taskArray.isCompleted(index)) {
            System.out.println("This task is already completed!");
            return;
        }

        String task = taskArray.getTask(index);
        if (task != null) {
            taskArray.markAsCompleted(index);
            taskStack.push(task);
            System.out.println("Task marked as completed: " + task);
        }
    }

    private void undoTaskCompletion() {
        String task = taskStack.pop();
        if (task != null) {
            // Find and unmark the task
            for (int i = 0; i < taskArray.getTaskCount(); i++) {
                if (task.equals(taskArray.getTask(i))) {
                    taskArray.markAsNotCompleted(i);
                    break;
                }
            }
            System.out.println("Undone task: " + task);
        }
    }

    private void addDynamicTask() {
        System.out.print("Enter new task: ");
        String task = scanner.nextLine();
        taskList.addTask(task);
        System.out.println("Task added successfully!");
    }

    private void removeDynamicTask() {
        System.out.print("Enter task to remove: ");
        String task = scanner.nextLine();
        if (taskList.removeTask(task)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    public static void main(String[] args) {
        DailyTaskManager manager = new DailyTaskManager();
        manager.run();
    }
}
