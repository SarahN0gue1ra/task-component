package component.tasks;

public interface Task {
    void execute();
    TaskStatus getStatus();
    void cancel();
    void addCompletionListener(TaskCompletionListener listener);
	String getId();
}