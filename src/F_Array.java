public class F_Array {
    private String[] tasks;
    private boolean[] completed; // Track completion status

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

    public void displayTasks() {
        System.out.println("\nPredefined Tasks:");
        for (int i = 0; i < tasks.length; i++) {
            String status = completed[i] ? "[Done]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + tasks[i]);
        }
    }

    // Add method to mark task as completed
    public void markAsCompleted(int index) {
        if (index >= 0 && index < tasks.length) {
            completed[index] = true;
        }
    }

    // Add method to mark task as not completed
    public void markAsNotCompleted(int index) {
        if (index >= 0 && index < tasks.length) {
            completed[index] = false;
        }
    }

    // Add method to check if task is completed
    public boolean isCompleted(int index) {
        if (index >= 0 && index < tasks.length) {
            return completed[index];
        }
        return false;
    }

    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.length) {
            tasks[index] = newTask;
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public int getTaskCount() {
        return tasks.length;
    }

    public String getTask(int index) {
        if (index >= 0 && index < tasks.length) {
            return tasks[index];
        }
        return null;
    }
}
