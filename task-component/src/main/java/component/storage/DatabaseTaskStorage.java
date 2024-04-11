package component.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import component.tasks.Task;
import component.tasks.TaskImpl;
import component.tasks.TaskStatus;

public class DatabaseTaskStorage implements TaskStorage{
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/taskdb";
	private static final String USER = "postgres";
    private static final String PASS = "postgre";
	
	@Override
	public void saveTask(Task task) {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO tasks (id, task_data, status) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, task.getId());
                pstmt.setString(2, serializeTaskData(task));
                pstmt.setString(3, task.getStatus().name());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Task loadTaskById(String taskId) {
		 try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	            String sql = "SELECT task_data, status FROM tasks WHERE id = ?";
	            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                pstmt.setString(1, taskId);
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        return deserializeTask(rs.getString("task_data"), TaskStatus.valueOf(rs.getString("status")));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	@Override
	public List<Task> loadTasksByStatus(TaskStatus status) {
		List<Task> tasks = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT id, task_data FROM tasks WHERE status = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, status.name());
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        tasks.add(deserializeTask(rs.getString("task_data"), status));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();        }
        return tasks;
	}

	private String serializeTaskData(Task task) {
        return task.toString();
    }
	
	private Task deserializeTask(String data, TaskStatus status) {
        return new TaskImpl(data, status);
    }
}
