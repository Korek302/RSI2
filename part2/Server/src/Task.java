import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/*
 * @author jacek blady 228140
 * Task abstract class
 * Stores basic Task variables and constructors
 * implements ITask
 */
public abstract class Task implements ITask
{
	/*
	 * List of values used for the task (List<Integer)
	 */
	public List<Integer> list;
	
	/**
	 * Specifies operation of the task (String)
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
	
	/*
	 * @see ITask#calculate()
	 */
	@Override
	public abstract Result calculate() throws RemoteException;
}
