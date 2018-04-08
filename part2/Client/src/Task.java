import java.rmi.RemoteException;

/**
 * @author jacek blady 228140
 *
 * Task class
 * implements ITask
 * Specifies tasks for workers
 */
public class Task implements ITask
{
	/**
	 * double x1
	 * First value in task calculate method.
	 */
	public double x1;
	
	/**
	 * double x2
	 * Second value in task calculate method.
	 */
	public double x2;
	
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
		x1 = 0.0;
		x2 = 0.0;
		operation = null;
	}
	
	/**
	 * Parametrized constructor of the Task class.
	 * @param x1 - double - new value of x1 variable
	 * @param x2 - double - new value of x2 variable
	 * @param operation - String - new value of operation variable
	 */
	public Task(double x1, double x2, String operation)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.operation = operation;
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
		
		switch(operation)
		{
			case "add" :
				out.result = x1 + x2;
				break;
			case "sub" :
				out.result = x1 - x2;
				break;
			default :
				out.result = 0;
				out.result_description = "Podano zla operacje";
		}
		
		return out;
	}
}
