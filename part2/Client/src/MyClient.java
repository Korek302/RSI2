import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MyClient 
{
	public static void main(String[] args) 
	{
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<IWorker> workerList = new ArrayList<IWorker>();
		ArrayList<Result> resultList = new ArrayList<Result>();
		ArrayList<ITask> taskList = new ArrayList<ITask>();
		
		/*if(args.length == 0)
		{
			System.out.println("You have to enter 1st RMI object address in the form: //host_address/service_name");
			return;
		}*/
		
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
		
		String choice;
		Scanner reader = new Scanner(System.in);
		do
		{
			System.out.println("Liczba dostepnych worker'ow: " + workerList.size());
			System.out.println("Nacisnij: \n[1] - dodaj zadanie1\n[2] - dodaj zadanie2\n[0] - zakoncz\n");
	    	choice = reader.next();
	    	
	    	if(choice.toCharArray()[0] != '0')
	    	{
				if(taskList.size() < workerList.size())
				{
					System.out.println("Podaj operacje (add/sub): ");
					String in1 = reader.next();
					System.out.println(in1);
					if(!in1.equals("add") && !in1.equals("sub"))
					{
						System.out.println("Bledna operacja!");
					}
					else
					{
						System.out.println("Podaj pierwsza liczbe: ");
						double in2 = reader.nextDouble();
						System.out.println("Podaj druga liczbe: ");
						double in3 = reader.nextDouble();
						
						if(choice.toCharArray()[0] == '1')
						{
							taskList.add(new Task(in2, in3, in1));
						}
						else if(choice.toCharArray()[0] == '2')
						{
							taskList.add(new Task2(in2, in3, in1));
						}
					}
				}
				else
				{
					System.out.println("Wszyscy pracownicy zostali zajeci!");
				}
	    	}
		}while(choice.toCharArray()[0] != '0');
	    reader.close();
		
		/*taskList = new ArrayList<ITask>
		(
			Arrays.asList
			(
				new Task(1.4, 5.6, "add"),
				new Task2(3.3, 4.1, "sub"),
				new Task(3.3, 4.1, "sub")
			)
		);*/
		
		try
		{
			for(int i = 0; i < taskList.size(); i++)
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
