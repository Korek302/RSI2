import java.io.Serializable;
import java.rmi.RemoteException;

public interface ITask extends Serializable
{
	public Result calculate() throws RemoteException;
}