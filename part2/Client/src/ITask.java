import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * @author jacek blady 228140
 *
 * ITask interface used to create tasks for workers
 */
public interface ITask extends Serializable
{
	/**
	 * Method that specifies task for workers to do
	 * @return Result type value - outcome of the method is specified in the implementation of the interface
	 * @throws RemoteException
	 */
	public Result calculate() throws RemoteException;
}