import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Worker extends UnicastRemoteObject implements IWorker
{
	public Worker() throws RemoteException 
	{
		super();
	}

	@Override
	public Result calculate(ITask t) throws RemoteException 
	{
		return t.calculate();
	}

}
