import java.rmi.RemoteException;

public interface CalcObject 
{
	public double calculate(double a, double b) throws RemoteException;
}
