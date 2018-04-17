import java.rmi.RemoteException;

/**
 * @author jacek blady 228140
 * Task2 class
 * extends Task
 * Specifies tasks for workers
 */
public class Task2 extends Task
{
	/**
	 * Default constructor of the Task2 class.
	 */
	public Task2()
	{
		super();
	}
	
	/**
	 * Parametrized constructor of the Task2 abstract class.
	 * @param input - Input - values for the operation
	 */
	public Task2(Input input)
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
		int fact = 1;
		for(int i = 1; i <= list.get(0); i++)
		{    
		      fact = fact*i;
		}  
		out.result_description = operation + this.getClass().getName();
		out.result.add(fact);
			
		return out;
	}
}
