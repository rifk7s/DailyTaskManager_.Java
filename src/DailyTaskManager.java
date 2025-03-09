import java.util.Scanner;

public class DailyTaskManager {
    private F_Array taskArray;
    private F_Stack taskStack;
    private Scanner scanner;

    public DailyTaskManager() {
        taskArray = new F_Array();
        taskStack = new F_Stack();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("******************************");
        System.out.println("Welcome to Daily Task Manager!");
        System.out.println("******************************");
        System.out.println("\n=== Menu Options ===");
        System.out.println("1. View predefined tasks");
        System.out.println("2. Update predefined task");
        System.out.println("3. Add new task");
        System.out.println("4. Delete task");
        System.out.println("5. Mark task as completed");
        System.out.println("6. Undo task completion");
        System.out.println("7. Check if all tasks are completed");
        System.out.println("8. Exit");
        System.out.print("\nWhat would you like to do?: ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            cls();

            switch (choice) {
                case 1:
                    taskArray.displayTasks();
                    pauseExecution();
                    break;
                case 2:
                    updatePredefinedTask();
                    break;
                case 3:
                    addNewTask();
                    break;
                case 4:
                    deleteExistingTask();
                    break;
                case 5:
                    markTaskCompleted();
                    break;
                case 6:
                    undoTaskCompletion();
                    break;
                case 7:
                    if (allTaskCompleted()) {
                        System.out.println("Congratulations! All tasks are completed!");
                    } else {
                        System.out.println("You still have incomplete tasks.");
                        taskArray.displayTasks();
                    }
                    pauseExecution();
                    break;
                case 8:
                    if (allTaskCompleted()) {
                        System.out.println("Thank you for using Daily Task Manager!");
                        System.out.println("Exiting Program . . .");
                        exitProgram();
                    } else {
                        System.out.print("Do you want to exit anyway? (yes/no): ");
                        String confirm = scanner.nextLine().trim();
                        if (confirm.equalsIgnoreCase("yes")) {
                            System.out.println("Warning: You still have incomplete tasks!");
                            exitProgram();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private void addNewTask() {
        boolean continueAdding = true;
        while (continueAdding) {
            taskArray.displayTasks();
            System.out.print("\nEnter new task: ");
            String newTask = scanner.nextLine();
            taskArray.addTask(newTask);
            taskArray.displayTasks();
            
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            showSubMenu("add");
            int subChoice = scanner.nextInt();
            scanner.nextLine();
            
            if (subChoice == 2) {
                continueAdding = false;
            }
            cls();
        }
    }

    private void deleteExistingTask() {
        boolean continueDeleting = true;
        while (continueDeleting) {
            taskArray.displayTasks();
            System.out.print("Enter task index to delete (1-" + taskArray.getTaskCount() + "): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            taskArray.deleteTask(index);
            taskArray.displayTasks();
            
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            showSubMenu("delete");
            int subChoice = scanner.nextInt();
            scanner.nextLine();
            
            if (subChoice == 2) {
                continueDeleting = false;
            }
            cls();
        }
    }

    private void updatePredefinedTask() {
        boolean continueUpdating = true;
        while (continueUpdating) {
            taskArray.displayTasks();
            System.out.print("Enter task index to update (1-" + taskArray.getTaskCount() + "): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new task: ");
            String newTask = scanner.nextLine();
            taskArray.updateTask(index, newTask);
            taskArray.displayTasks(); // Display updated tasks
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            showSubMenu("update");
            int subChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (subChoice == 2) {
                continueUpdating = false;
            }
            cls();
        }
    }

    private void showSubMenu(String action) {
        System.out.println("\nWhat would you like to do next?");
        String actionText;
        switch (action) {
            case "update":
                actionText = "Update";
                break;
            case "delete":
                actionText = "Delete";
                break;
            case "add":
                actionText = "Add";
                break;
            default:
                actionText = "Complete";
                break;
        }
        System.out.println("1. " + actionText + " another task");
        System.out.println("2. Back to main menu");
        System.out.print("Your choice: ");
    }

    private void markTaskCompleted() {
        boolean continueMarking = true;
        while (continueMarking) {
            taskArray.displayTasks();
            System.out.print("Enter task index to mark as completed (1-" + taskArray.getTaskCount() + "): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            
            if (taskArray.isCompleted(index)) {
                System.out.println("This task is already completed!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                String task = taskArray.getTask(index);
                if (task != null) {
                    taskArray.markAsCompleted(index);
                    taskStack.push(task);
                    System.out.println("Task \"" + task + "\" completed!");
                    taskArray.displayTasks();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }

            showSubMenu("complete");
            int subChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (subChoice == 2) {
                continueMarking = false;
            }
            cls();
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
            taskArray.displayTasks(); // Display updated tasks
            try {
                Thread.sleep(1500); // Increased sleep time for better readability
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for user confirmation
            cls();
        } else {
            System.out.println("No tasks to undo!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private boolean allTaskCompleted() {
        for (int i = 0; i < taskArray.getTaskCount(); i++) {
            if (!taskArray.isCompleted(i)) {
                return false;
            }
        }
        return true;
    }

    private static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void exitProgram() {
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        cls();
        System.out.println("Have a nice rest!!!");
        System.exit(0);
    }

    private void pauseExecution() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        cls();
    }

    public static void main(String[] args) {
        DailyTaskManager manager = new DailyTaskManager();
        manager.run();
    }
}
