package component.notification;

import component.tasks.Task;

public interface TaskNotificationManager {
	void notifyTaskCompletion(Task task);
}
