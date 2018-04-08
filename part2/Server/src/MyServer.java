import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer 
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
			LocateRegistry.createRegistry(1099);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			
			for(String s : args)
			{
				Worker worker = new Worker();
				java.rmi.Naming.rebind(s, worker);
			}
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
