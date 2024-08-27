import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Enums.Priority;
import Enums.Status;

public class TaskApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Task Management System");
        while (true) {
            System.out.println("-----------------------");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Filter Tasks by Status");
            System.out.println("6. Filter Tasks by Priority");
            System.out.println("7. Filter Tasks by Due Date");
            System.out.println("8. Search Tasks");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                    Priority priority = Priority.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter status (PENDING, IN_PROGRESS, COMPLETED): ");
                    Status status = Status.valueOf(sc.nextLine().toUpperCase());

                    Task task = new Task(title, description, dueDate, priority, status);
                    taskManager.addTask(task);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.print("Enter task index to update: ");
                    int updateIndex = sc.nextInt();
                    sc.nextLine(); 

                    Optional<Task> taskToUpdate = taskManager.findTaskByIndex(updateIndex);
                    if (taskToUpdate.isPresent()) {
                        System.out.print("Enter new title: ");
                        title = sc.nextLine();
                        System.out.print("Enter new description: ");
                        description = sc.nextLine();
                        System.out.print("Enter new due date (YYYY-MM-DD): ");
                        dueDate = LocalDate.parse(sc.nextLine());
                        System.out.print("Enter new priority (HIGH, MEDIUM, LOW): ");
                        priority = Priority.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Enter new status (PENDING, IN_PROGRESS, COMPLETED): ");
                        status = Status.valueOf(sc.nextLine().toUpperCase());

                        Task updatedTask = new Task(title, description, dueDate, priority, status);
                        taskManager.updateTask(updateIndex, updatedTask);
                        System.out.println();
                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println();
                        System.out.println("Task not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = sc.nextInt();
                    sc.nextLine(); 
                    Optional<Task> taskTodelete = taskManager.findTaskByIndex(deleteIndex);
                    if (!taskTodelete.isPresent()) {
                        System.out.println();
                        System.out.println("Task not found!");
                        break;
                    }
                    taskManager.deleteTask(deleteIndex);
                    System.out.println();
                    System.out.println("Task deleted successfully!");
                    break;

                case 4:
                    List<Task> allTasks = taskManager.getTasks();
                    if (allTasks.isEmpty()) {
                        System.out.println();
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println();
                        System.out.println("All Tasks:");
                        allTasks.forEach(System.out::println);
                    }
                    break;

                case 5:
                    System.out.print("Enter status to filter (PENDING, IN_PROGRESS, COMPLETED): ");
                    status = Status.valueOf(sc.nextLine().toUpperCase());
                    List<Task> statusFilteredTasks = taskManager.filterTasksByStatus(status);
                    if (statusFilteredTasks.isEmpty()) {
                        System.out.println();
                        System.out.println("No tasks found with the status: " + status);
                    } else {
                        System.out.println();
                        statusFilteredTasks.forEach(System.out::println);
                    }
                    break;

                case 6:
                    System.out.print("Enter priority to filter (HIGH, MEDIUM, LOW): ");
                    priority = Priority.valueOf(sc.nextLine().toUpperCase());
                    List<Task> priorityFilteredTasks = taskManager.filterTasksByPriority(priority);
                    if (priorityFilteredTasks.isEmpty()) {
                        System.out.println();
                        System.out.println("No tasks found with the priority: " + priority);
                    } else {
                        System.out.println();
                        priorityFilteredTasks.forEach(System.out::println);
                    }
                    break;

                case 7:
                    System.out.print("Enter due date to filter (YYYY-MM-DD): ");
                    dueDate = LocalDate.parse(sc.nextLine());
                    List<Task> dueDateFilteredTasks = taskManager.filterTasksByDueDate(dueDate);
                    if (dueDateFilteredTasks.isEmpty()) {
                        System.out.println();
                        System.out.println("No tasks found with the due date: " + dueDate);
                    } else {
                        System.out.println();
                        dueDateFilteredTasks.forEach(System.out::println);
                    }
                    break;

                case 8:
                    System.out.print("Enter keyword to search in title or description: ");
                    String keyword = sc.nextLine();
                    List<Task> searchedTasks = taskManager.searchTasks(keyword);
                    if (searchedTasks.isEmpty()) {
                        System.out.println();
                        System.out.println("No tasks found containing the keyword: " + keyword);
                    } else {
                        System.out.println();
                        searchedTasks.forEach(System.out::println);
                    }
                    break;

                case 9:
                System.out.println();
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
