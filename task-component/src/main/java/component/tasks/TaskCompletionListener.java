package component.tasks;

public interface TaskCompletionListener {
    // Método chamado quando a tarefa é concluída com sucesso.
    void onTaskCompleted(Task task);
}
