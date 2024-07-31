public class TaskLinkedList {
    private Node head;

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add a new task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Not found
    }

    // Traverse the list and print tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false; // List is empty
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }
        if (current.next == null) {
            return false; // Task not found
        }
        current.next = current.next.next;
        return true;
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        
        // Adding tasks
        taskList.addTask(new Task(1, "Design database schema", "Pending"));
        taskList.addTask(new Task(2, "Implement login feature", "In Progress"));
        taskList.addTask(new Task(3, "Create unit tests", "Pending"));

        // Traversing tasks
        System.out.println("Traversing tasks:");
        taskList.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for task with ID 2:");
        Task foundTask = taskList.searchTask(2);
        System.out.println(foundTask != null ? foundTask : "Task not found");

        // Deleting a task
        System.out.println("\nDeleting task with ID 1:");
        boolean isDeleted = taskList.deleteTask(1);
        System.out.println(isDeleted ? "Task deleted" : "Task not found");

        // Traversing tasks after deletion
        System.out.println("\nTraversing tasks after deletion:");
        taskList.traverseTasks();
    }
}
