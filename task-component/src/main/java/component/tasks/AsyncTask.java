package component.tasks;

public abstract class AsyncTask {
	// Método abstrato que contém a lógica da tarefa a ser executada de forma assíncrona.
    public abstract void execute();

    // Método para cancelar a execução da tarefa.
    public abstract void cancel();
}
