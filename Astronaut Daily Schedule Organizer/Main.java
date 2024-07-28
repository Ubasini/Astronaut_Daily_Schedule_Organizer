import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);

        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add, remove, view, complete, viewPriority, exit):");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    addTask(scheduleManager, taskFactory, scanner);
                    break;
                case "remove":
                    removeTask(scheduleManager, scanner);
                    break;
                case "view":
                    scheduleManager.viewTasks();
                    break;
                case "complete":
                    completeTask(scheduleManager, scanner);
                    break;
                case "viewpriority":
                    viewTasksByPriority(scheduleManager, scanner);
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static void addTask(ScheduleManager scheduleManager, TaskFactory taskFactory, Scanner scanner) {
        try {
            System.out.println("Enter task description:");
            String description = scanner.nextLine();
            System.out.println("Enter start time (HH:mm):");
            String startTime = scanner.nextLine();
            System.out.println("Enter end time (HH:mm):");
            String endTime = scanner.nextLine();
            System.out.println("Enter priority level (Low, Medium, High):");
            String priority = scanner.nextLine();

            Task task = taskFactory.createTask(description, startTime, endTime, priority);
            if (scheduleManager.addTask(task)) {
                System.out.println("Task added successfully. No conflicts.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
            logger.severe("Error adding task: " + e.getMessage());
        }
    }

    private static void removeTask(ScheduleManager scheduleManager, Scanner scanner) {
        System.out.println("Enter task description to remove:");
        String description = scanner.nextLine();
        if (scheduleManager.removeTask(description)) {
            System.out.println("Task removed successfully.");
        }
    }

    private static void completeTask(ScheduleManager scheduleManager, Scanner scanner) {
        System.out.println("Enter task description to mark as completed:");
        String description = scanner.nextLine();
        scheduleManager.markTaskAsCompleted(description);
    }

    private static void viewTasksByPriority(ScheduleManager scheduleManager, Scanner scanner) {
        System.out.println("Enter priority level to view tasks (Low, Medium, High):");
        String priority = scanner.nextLine();
        scheduleManager.viewTasksByPriority(priority);
    }
}
