package component.storage;
import java.util.List;
import component.tasks.Task;
import component.tasks.TaskStatus;

public interface TaskStorage {
    void saveTask(Task task);
    
    // Carrega pelo ID.
    Task loadTaskById(String taskId);
    
    // Carrega todas as tarefas com um determinado status.
    List<Task> loadTasksByStatus(TaskStatus status);
}
