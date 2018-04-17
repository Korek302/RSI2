import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public abstract class Task implements ITask
{
	public List<Integer> list;
	
	/**
	 * String operation
	 * Specifies operation of the task
	 */
	public String operation;
	
	/**
	 * Default constructor of the Task class.
	 */
	public Task()
	{
		list = new ArrayList<Integer>();
		operation = null;
	}
	
	/**
	 * Parametrized constructor of the Task abstract class.
	 * @param list - List<Integer> - new list of values for the operation
	 * @param operation - String - new value of operation variable
	 */
	public Task(Input input)
	{
		this.list = input.list;
		this.operation = input.operation;
	}
	
	@Override
	public abstract Result calculate() throws RemoteException;
}
