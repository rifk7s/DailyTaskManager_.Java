/**
 * F_Stack - Stack implementation for undo functionality
 * Used to track completed tasks for potential undo operations
 */
public class F_Stack {
    private String[] stack;              // Array to store stack elements
    private int top;                     // Index of top element
    private static final int MAX_SIZE = 100;  // Maximum stack size

    /**
     * Constructor - Initializes empty stack
     */
    public F_Stack() {
        stack = new String[MAX_SIZE];
        top = -1;
    }

    /**
     * Pushes a new task onto the stack
     * @param task The task to be pushed
     */
    public void push(String task) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = task;
    }

    /**
     * Pops the top task from the stack
     * @return The task that was popped
     */
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return null;
        }
        return stack[top--];
    }

    /**
     * Peeks at the top task without removing it
     * @return The top task
     */
    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack[top];
    }

    /**
     * Checks if the stack is empty
     * @return True if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }
}
