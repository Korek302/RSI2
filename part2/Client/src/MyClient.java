import java.util.ArrayList;

public class MyClient 
{
	public static void main(String[] args) 
	{
		double wynik;
		
		int workerNum = 3;
		
		IWorker worker1;
		IWorker worker2;
		IWorker worker3;
		
		Result result1;
		Result result2;
		Result result3;
		
		Task task1;
		Task2 task2;
		Task task3;
		
		ArrayList<IWorker> workerList = new ArrayList<IWorker>();
		for(int i = 0; i < workerNum; i++)
		{
			workerList.add();
		}
		
		ArrayList<String> addressList = new ArrayList<String>();
		
		if(args.length == 0)
		{
			System.out.println("You have to enter 1st RMI object address in the form: //host_address/service_name");
			return;
		}
		
		for(String s : args)
		{
			addressList.add(s);
		}
		
		if(System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
		try
		{
			for(String s : addressList)
			{
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Nie mozna pobrac referencji do " + adres);
			e.printStackTrace();
			return;
		}
		System.out.println("Referencja do " + adres + " jest pobrana.");
		
		inObj = new InputType();
		inObj.x1 = 5.2;
		inObj.x2 = 1.3;
		inObj.operation = "add";
		
		try
		{
			zObiekt2 = (CalcObject2) java.rmi.Naming.lookup(adres2);
		}
		catch(Exception e)
		{
			System.out.println("Nie mozna pobrac referencji do " + adres2);
			e.printStackTrace();
			return;
		}
		System.out.println("Referencja do " + adres2 + " jest pobrana.");
		
		try
		{
			wynik = zObiekt.calculate(1.1, 2.2);
			wynik2 = zObiekt2.calculate(inObj);
		}
		catch(Exception e)
		{
			System.out.println("Blad zdalnego wywolania.");
			e.printStackTrace();
			return;
		}
		System.out.println("Wynik = " + wynik);
		System.out.println("Wynik2 = " + wynik2.result + ", desc: " + wynik2.result_description);
		return;
	}
}
