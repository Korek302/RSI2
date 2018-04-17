import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jacek blady 228140
 *
 * Task1 class
 * extends Task
 * Specifies tasks for workers
 */
public class Task1 extends Task
{
	/**
	 * Default constructor of the Task1 class.
	 */
	public Task1()
	{
		super();
	}
	
	/**
	 * Parametrized constructor of the Task1 abstract class.
	 * @param input - Input - values for the operation
	 */
	public Task1(Input input)
	{
		super(input);
	}
	
	/**
	 * Implementation of calculate method from ITask interface.
	 * returns Result type result
	 * throws RemoteException
	 */
	@Override
	public Result calculate() throws RemoteException 
	{
		Result out = new Result();
		out.result_description = operation + this.getClass().getName();
		out.result.add(0, list.get(0) + list.get(1));
		
		return out;
	}
}
