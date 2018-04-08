import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MySerwer 
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
			return;
		}
		
		if(System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
		try
		{
			Registry reg = LocateRegistry.createRegistry(1099);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			CalcObjImpl implObiektu = new CalcObjImpl();
			java.rmi.Naming.rebind(args[0], implObiektu);
			System.out.println("Server is registered now :-)");
			System.out.println("Press Ctrl + C to stop...");
			
		} 
		catch(Exception e)
		{
			System.out.println("SERVER CAN'T BE REGISTERED!");
			e.printStackTrace();
			return;
		}
		
		if(args.length < 2)
		{
			System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
			return;
		}
		
		try
		{
			CalcObjImpl2 implObiektu = new CalcObjImpl2();
			java.rmi.Naming.rebind(args[1], implObiektu);
			System.out.println("Server is registered now :-)");
			System.out.println("Press Ctrl + C to stop...");
			
		} 
		catch(Exception e)
		{
			System.out.println("SERVER CAN'T BE REGISTERED!");
			e.printStackTrace();
			return;
		}
	}
}
