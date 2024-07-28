import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public boolean addTask(Task task) {
        for (Task t : tasks) {
            if (isOverlapping(t, task)) {
                System.out.println("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                logger.warning("Task conflict detected: " + task.getDescription() + " overlaps with " + t.getDescription());
                return false;
            }
        }
        tasks.add(task);
        logger.info("Task added successfully: " + task.getDescription());
        return true;
    }

    public boolean removeTask(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equals(description)) {
                tasks.remove(t);
                logger.info("Task removed successfully: " + description);
                return true;
            }
        }
        System.out.println("Error: Task not found.");
        logger.warning("Task not found: " + description);
        return false;
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public boolean isOverlapping(Task t1, Task t2) {
        return (t1.getStartTime().compareTo(t2.getEndTime()) < 0 && t1.getEndTime().compareTo(t2.getStartTime()) > 0);
    }

    public void markTaskAsCompleted(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equals(description)) {
                t.setCompleted(true);
                logger.info("Task marked as completed: " + description);
                return;
            }
        }
        System.out.println("Error: Task not found.");
        logger.warning("Task not found: " + description);
    }

    public void viewTasksByPriority(String priority) {
        for (Task t : tasks) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(t);
            }
        }
    }
}
