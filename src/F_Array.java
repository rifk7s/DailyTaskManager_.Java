/**
 * F_Array - Array implementation for task management
 * Manages tasks and their completion status using parallel arrays
 */
public class F_Array {
    private String[] tasks;      // Store task descriptions
    private boolean[] completed; // Track completion status

    /**
     * Constructor - Initializes with default tasks
     */
    public F_Array() {
        tasks = new String[]{ //default tasks
            "Contoh1",
            "Contoh2",
            "Contoh3",
            "Contoh4",
            "Contoh5"
        };
        completed = new boolean[tasks.length]; // Initialize all tasks as not completed
    }

    // ============ Task Display Methods ============
    
    /**
     * Displays all tasks with their completion status
     */
    public void displayTasks() {
        System.out.println("\nPredefined Tasks:");
        for (int i = 0; i < tasks.length; i++) {
            String status = completed[i] ? "[Done]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + tasks[i]);
        }
    }

    // ============ Task Status Methods ============

    /**
     * Marks a task as completed
     * @param index The index of the task to mark as completed
     */
    public void markAsCompleted(int index) {
        if (index >= 0 && index < tasks.length) {
            completed[index] = true;
        }
    }

    /**
     * Marks a task as not completed
     * @param index The index of the task to mark as not completed
     */
    public void markAsNotCompleted(int index) {
        if (index >= 0 && index < tasks.length) {
            completed[index] = false;
        }
    }

    /**
     * Checks if a task is completed
     * @param index The index of the task to check
     * @return true if the task is completed, false otherwise
     */
    public boolean isCompleted(int index) {
        if (index >= 0 && index < tasks.length) {
            return completed[index];
        }
        return false;
    }

    /**
     * Updates the description of a task
     * @param index The index of the task to update
     * @param newTask The new description of the task
     */
    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.length) {
            tasks[index] = newTask;
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    /**
     * Gets the total number of tasks
     * @return The number of tasks
     */
    public int getTaskCount() {
        return tasks.length;
    }

    /**
     * Gets the description of a task
     * @param index The index of the task to get
     * @return The description of the task, or null if the index is invalid
     */
    public String getTask(int index) {
        if (index >= 0 && index < tasks.length) {
            return tasks[index];
        }
        return null;
    }

    /**
     * Adds a new task
     * @param newTask The description of the new task
     */
    public void addTask(String newTask) {
        String[] newTasks = new String[tasks.length + 1];
        boolean[] newCompleted = new boolean[tasks.length + 1];
        
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        System.arraycopy(completed, 0, newCompleted, 0, completed.length);
        
        newTasks[tasks.length] = newTask;
        tasks = newTasks;
        completed = newCompleted;
        System.out.println("Task added successfully!");
    }

    /**
     * Deletes a task
     * @param index The index of the task to delete
     */
    public void deleteTask(int index) {
        if (index < 0 || index >= tasks.length) {
            System.out.println("Invalid index!");
            return;
        }

        String[] newTasks = new String[tasks.length - 1];
        boolean[] newCompleted = new boolean[tasks.length - 1];
        
        System.arraycopy(tasks, 0, newTasks, 0, index);
        System.arraycopy(tasks, index + 1, newTasks, index, tasks.length - index - 1);
        
        System.arraycopy(completed, 0, newCompleted, 0, index);
        System.arraycopy(completed, index + 1, newCompleted, index, completed.length - index - 1);
        
        tasks = newTasks;
        completed = newCompleted;
        System.out.println("Task deleted successfully!");
    }
}
