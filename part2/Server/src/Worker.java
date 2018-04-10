import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author jacek blady 228140
 *
 * Worker class implementing IWorker interface
 * It creates workers and specify their methods
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
	 * @params ITask - task for worker to perform
	 */
	@Override
	public Result calculate(ITask t) throws RemoteException 
	{
		return t.calculate();
	}

	@Override
	public ResultSort calculateSort(ITask t) throws RemoteException 
	{
		return t.calculateSort();
	}
}
