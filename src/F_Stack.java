public class F_Stack {
    private String[] stack;
    private int top;
    private static final int MAX_SIZE = 100;

    public F_Stack() {
        stack = new String[MAX_SIZE];
        top = -1;
    }

    public void push(String task) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = task;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return null;
        }
        return stack[top--];
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
