import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author jacek blady 228140
 *
 * Worker class implementing IWorker interface
 * It is used for creating workers and specify their methods
 */
public class Worker extends UnicastRemoteObject implements IWorker
{
	/*
	 * Default constructor of Worker class
	 * Calls super()
	 */
	public Worker() throws RemoteException 
	{
		super();
	}

	/**
	 * Implementation of method from IWorker interface that specifies what workers do
	 * @return Result type value - outcome of the method is specified in the implementation of the interface
	 * @throws RemoteException
	 * @params intpu - Input - Values for worker to perform tasks with
	 */
	@Override
	public Result calculate(Input input) throws RemoteException 
	{
		if(input.operation.equals("add"))
		{
			return (new Task1(input)).calculate();
		}
		else if(input.operation.equals("fac"))
		{
			return (new Task2(input)).calculate();
		}
		else if(input.operation.equals("sort"))
		{
			return (new Task3(input)).calculate();
		}
		else
		{
			return new Result();
		}
	}

}
