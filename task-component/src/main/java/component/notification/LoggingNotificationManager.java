package component.notification;
import java.util.ArrayList;
import java.util.List;
import component.tasks.Task;
import component.tasks.TaskCompletionListener;

public class LoggingNotificationManager implements TaskNotificationManager {
	// Lista para armazenar os ouvintes 
    private List<TaskCompletionListener> listeners;

    public LoggingNotificationManager() {
        this.listeners = new ArrayList<>();
    }

    // Método para registrar um ouvinte 
    public void registerListener(TaskCompletionListener listener) {
        listeners.add(listener);
    }

    // Método para notificar a conclusão de uma tarefa a todos os ouvintes registrados.
    public void notifyTaskCompletion(Task task) {
        for (TaskCompletionListener listener : listeners) {
            listener.onTaskCompleted(task);
        }
    }
}
