package component.scheduler;
import java.time.LocalDateTime;
import component.tasks.Task;

public interface TaskScheduler {
    // Agenda uma tarefa para execução em um momento específico.
    void scheduleTask(Task task, LocalDateTime executionTime);
    
    // Cancela a execução de uma tarefa agendada.
    void cancelTask(Task task);
}
