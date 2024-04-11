package component.scheduler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import component.tasks.Task;

public class SimpleTaskScheduler implements TaskScheduler {
	 // Mapa para armazenar as tarefas agendadas.
	private Map<Task, TimerTask> scheduledTasks;
	
	public SimpleTaskScheduler() {
		this.scheduledTasks = new HashMap<Task, TimerTask>();
	}
	
	// Método para agendar uma tarefa para execução em um momento específico.
	public void scheduleTask(final Task task, LocalDateTime executionTime) {
		TimerTask timerTask = new TimerTask() {
			@Override
            public void run() {
				task.execute();
				scheduledTasks.remove(task);
			}
		};
		// Cria um Timer para agendar a execução da tarefa.
		Timer timer = new Timer();
        timer.schedule(timerTask, Date.from(executionTime.atZone(ZoneId.systemDefault()).toInstant()));
        scheduledTasks.put(task, timerTask);
	}
	
	// Método para cancelar a execução de uma tarefa agendada.
	public void cancelTask(Task task) {
		TimerTask timerTask = scheduledTasks.get(task); 
        if (timerTask != null) {
            timerTask.cancel(); 
            scheduledTasks.remove(task);
        }
		
	}
}
