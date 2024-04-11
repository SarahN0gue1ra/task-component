package component.executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import component.tasks.Task;

public class SimpleTaskExecutor implements TaskExecutor {
	// Executar as tarefas em threads separadas.
    private ExecutorService executor;
	
    public SimpleTaskExecutor() {
    // Número fixo de threads.
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
    
	public void executeTask(Task task) {
    // Submete a tarefa para execução no ExecutorService.
        executor.submit(() -> task.execute());
		
	}

}
