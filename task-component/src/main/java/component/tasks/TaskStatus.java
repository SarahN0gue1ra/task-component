package component.tasks;

public enum TaskStatus {
 // Indica que a tarefa está pronta para ser executada.
	PENDING,
 // Indica que a tarefa está em execução.
	RUNNING,
 // Indica que a tarefa foi concluída com sucesso.
	COMPLETED,
 // Indica que a tarefa foi cancelada antes de sua conclusão.
	CANCELED,
 // Indica que a tarefa encontrou uma falha durante a execução.
	FAILED
}

