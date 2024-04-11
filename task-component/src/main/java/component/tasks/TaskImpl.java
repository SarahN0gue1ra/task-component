package component.tasks;

public class TaskImpl implements Task {
	private String id;
    private String data;
    private TaskStatus status;
    
    public TaskImpl(String id, String data, TaskStatus status) {
        this.id = id;
        this.data = data;
        this.status = status;
    }
    
    public TaskImpl( String data, TaskStatus status) {
        this.data = data;
        this.status = status;
    }
    
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public TaskStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCompletionListener(TaskCompletionListener listener) {
		// TODO Auto-generated method stub
		
	}

}
