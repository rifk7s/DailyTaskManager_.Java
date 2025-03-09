public class F_LinkedList {
    private Test_Node head;

    public void addTask(String task) {
        Test_Node newNode = new Test_Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Test_Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean removeTask(String task) {
        if (head == null) return false;

        if (head.task.equals(task)) {
            head = head.next;
            return true;
        }

        Test_Node current = head;
        while (current.next != null && !current.next.task.equals(task)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the dynamic list.");
            return;
        }

        System.out.println("\nDynamic Task List:");
        Test_Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.task);
            current = current.next;
            index++;
        }
    }
}
