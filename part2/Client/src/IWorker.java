import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author jacek blady 228140
 *
 * IWorker interface used to create workers class and specify their methods
 */
public interface IWorker extends Remote
{
	/**
	 * Method that specifies what workers do
	 * @return Result type value - outcome of the method is specified in the implementation of the interface
	 * @throws RemoteException
	 * @params ITask - task for worker to perform
	 */
	public Result calculate(ITask t) throws RemoteException;

	public ResultSort calculateSort(ITask iTask);
}
