import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWorker extends Remote
{
	public Result calculate(ITask t) throws RemoteException;
}
