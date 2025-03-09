import java.util.Scanner;
import java.util.LinkedList;

/**
 * DailyTaskManager - A task management system with dual implementation (Array/LinkedList)
 * Features:
 * - Task creation, updating, and deletion
 * - Task completion tracking
 * - Undo functionality for completed tasks
 * - Flexible data structure selection
 */
public class DailyTaskManager {
    // ===== Class Fields =====
    private F_Array taskArray;          // Array-based implementation
    private F_Stack taskStack;          // Stack for undo operations
    private Scanner scanner;            // User input handler
    private LinkedList<String> taskList;        // LinkedList-based implementation
    private LinkedList<Boolean> completedList;  // Completion status for LinkedList impl
    private boolean isArrayBased;       // Flag for current implementation type

    // ===== Constructor and Initialization =====
    public DailyTaskManager() {
        scanner = new Scanner(System.in);
        selectDataStructure();
    }

    /**
     * Handles the selection of data structure implementation
     * Allows user to choose between Array and LinkedList
     */
    private void selectDataStructure() {
        System.out.println("==============================");
        System.out.println("Which menu do you want to see?");
        System.out.println("(0 to exit)");
        System.out.println("1. Array");
        System.out.println("2. Linked List");
        System.out.println("==============================");
        System.out.print("Please enter : ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 0) {
            System.exit(0);
        }
        
        isArrayBased = (choice == 1);
        if (isArrayBased) {
            taskArray = new F_Array();
            taskStack = new F_Stack();
        } else {
            taskList = new LinkedList<>();
            completedList = new LinkedList<>();
            taskStack = new F_Stack();
        }
        cls();
    }

    // ===== Menu and Control Methods =====
    /**
     * Displays the main menu interface
     * Shows all available operations and current data structure
     */
    public void displayMenu() {
        System.out.println("******************************");
        System.out.println("Welcome to Daily Task Manager!");
        System.out.println("******************************");
        System.out.println("\n=== Menu Options ===");
        System.out.println("1. View tasks");
        System.out.println("2. Update task");
        System.out.println("3. Add new task");
        System.out.println("4. Delete task");
        System.out.println("5. Mark task as completed");
        System.out.println("6. Undo task completion");
        System.out.println("7. Check if all tasks are completed");
        System.out.println("8. Change data structure");
        System.out.println("9. Exit");
        System.out.print("\nWhat would you like to do?: ");
    }

    /**
     * Main program loop
     * Handles user input and routes to appropriate operations
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            cls();

            switch (choice) {
                case 1:
                    displayTasks();
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
                        displayTasks();
                    }
                    pauseExecution();
                    break;
                case 8:
                    selectDataStructure();
                    break;
                case 9:
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

    // ===== Task Operation Methods =====
    /**
     * Displays all tasks with their completion status
     * Format differs based on implementation (Array/LinkedList)
     */
    private void displayTasks() {
        if (isArrayBased) {
            taskArray.displayTasks();
        } else {
            System.out.println("\nPredefined Tasks:");
            for (int i = 0; i < taskList.size(); i++) {
                String status = completedList.get(i) ? "[Done]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + taskList.get(i));
            }
        }
    }

    /**
     * Handles adding new tasks to the system
     * Supports continuous addition with confirmation
     */
    private void addNewTask() {
        boolean continueAdding = true;
        while (continueAdding) {
            displayTasks();
            System.out.print("\nEnter new task: ");
            String newTask = scanner.nextLine();
            
            if (isArrayBased) {
                taskArray.addTask(newTask);
            } else {
                taskList.add(newTask);
                completedList.add(false);
                System.out.println("Task added successfully!");
            }
            
            displayTasks();
            
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

    /**
     * Handles deletion of existing tasks
     * Validates index and updates data structure accordingly
     */
    private void deleteExistingTask() {
        boolean continueDeleting = true;
        while (continueDeleting) {
            displayTasks();
            int maxTasks = isArrayBased ? taskArray.getTaskCount() : taskList.size();
            System.out.print("Enter task index to delete (1-" + maxTasks + "): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (isArrayBased) {
                taskArray.deleteTask(index);
            } else {
                if (index >= 0 && index < taskList.size()) {
                    taskList.remove(index);
                    completedList.remove(index);
                    System.out.println("Task deleted successfully!");
                } else {
                    System.out.println("Invalid index!");
                }
            }
            
            displayTasks();
            
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

    /**
     * Handles updating existing task descriptions
     * Maintains completion status while updating content
     */
    private void updatePredefinedTask() {
        boolean continueUpdating = true;
        while (continueUpdating) {
            displayTasks();
            int maxTasks = isArrayBased ? taskArray.getTaskCount() : taskList.size();
            System.out.print("Enter task index to update (1-" + maxTasks + "): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new task: ");
            String newTask = scanner.nextLine();
            
            if (isArrayBased) {
                taskArray.updateTask(index, newTask);
            } else {
                if (index >= 0 && index < taskList.size()) {
                    taskList.set(index, newTask);
                    System.out.println("Task updated successfully!");
                } else {
                    System.out.println("Invalid index!");
                }
            }
            
            displayTasks(); // Display updated tasks
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

    // ===== UI Helper Methods =====
    /**
     * Displays operation-specific sub-menus
     * @param action Current operation type (add/update/delete/complete)
     */
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

    // ===== Task Status Management =====
    /**
     * Handles marking tasks as completed
     * Updates completion status and adds to undo stack
     */
    private void markTaskCompleted() {
        boolean continueMarking = true;
        while (continueMarking) {
            displayTasks();
            int maxTasks = isArrayBased ? taskArray.getTaskCount() : taskList.size();
            System.out.print("Enter task index to mark as completed (1-" + maxTasks + "): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            
            if (isArrayBased) {
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
                        displayTasks();
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                }
            } else {
                if (index >= 0 && index < taskList.size()) {
                    if (completedList.get(index)) {
                        System.out.println("This task is already completed!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        String task = taskList.get(index);
                        completedList.set(index, true);
                        taskStack.push(task);
                        System.out.println("Task \"" + task + "\" completed!");
                        displayTasks();
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
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

    /**
     * Handles undoing the most recent task completion
     * Uses stack to track completion history
     */
    private void undoTaskCompletion() {
        String task = taskStack.pop();
        if (task != null) {
            if (isArrayBased) {
                for (int i = 0; i < taskArray.getTaskCount(); i++) {
                    if (task.equals(taskArray.getTask(i))) {
                        taskArray.markAsNotCompleted(i);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < taskList.size(); i++) {
                    if (task.equals(taskList.get(i))) {
                        completedList.set(i, false);
                        break;
                    }
                }
            }
            System.out.println("Undone task: " + task);
            displayTasks(); // Display updated tasks
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

    /**
     * Checks completion status of all tasks
     * @return true if all tasks are completed, false otherwise
     */
    private boolean allTaskCompleted() {
        if (isArrayBased) {
            for (int i = 0; i < taskArray.getTaskCount(); i++) {
                if (!taskArray.isCompleted(i)) {
                    return false;
                }
            }
        } else {
            for (Boolean completed : completedList) {
                if (!completed) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Utility Methods =====
    /**
     * Clears the console screen
     * Uses ANSI escape codes for clearing
     */
    private static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Handles program termination
     * Displays exit message and performs cleanup
     */
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

    /**
     * Pauses execution until user input
     * Used for better UI flow control
     */
    private void pauseExecution() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        cls();
    }

    /**
     * Program entry point
     * Initializes manager and starts main loop
     */
    public static void main(String[] args) {
        DailyTaskManager manager = new DailyTaskManager();
        manager.run();
    }
}
