import java.util.ArrayList;
import java.util.Arrays;

public class MyClient 
{
	public static void main(String[] args) 
	{
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<IWorker> workerList = new ArrayList<IWorker>();
		ArrayList<Result> resultList = new ArrayList<Result>();
		ArrayList<ITask> taskList = new ArrayList<ITask>();
		
		if(args.length == 0)
		{
			System.out.println("You have to enter 1st RMI object address in the form: //host_address/service_name");
			return;
		}
		
		if(System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
		for(int i = 0; i < args.length; i++)
		{
			addressList.add(args[i]);
			try
			{
				workerList.add((IWorker) java.rmi.Naming.lookup(addressList.get(i)));
			}
			catch(Exception e)
			{
				System.out.println("Nie mozna pobrac referencji do " + addressList.get(i));
				e.printStackTrace();
				return;
			}
		}
		
		taskList = new ArrayList<ITask>
		(
			Arrays.asList
			(
				new Task(1.4, 5.6, "add"),
				new Task2(3.3, 4.1, "sub"),
				new Task(3.3, 4.1, "sub")
			)
		);
		
		try
		{
			for(int i = 0; i < workerList.size(); i++)
			{
				resultList.add(workerList.get(i).calculate(taskList.get(i)));
			}
		}
		catch(Exception e)
		{
			System.out.println("Blad zdalnego wywolania.");
			e.printStackTrace();
			return;
		}
		
		int i = 0;
		for(Result r : resultList)
		{
			System.out.println("Wynik uslugi nr " + ++i + ": " + r.result);
			System.out.println("opis: " + r.result_description);
		}
		return;
	}
}
