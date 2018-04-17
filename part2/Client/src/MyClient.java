import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author jacek blady 228140
 *
 * Main class of the Client side of the service
 * Specifies the behaviour of client side of the application
 * Contains main method
 */
public class MyClient 
{
	/*
	 * Main method of the project - entry point of the application
	 * @params String args - contains the supplied command-line arguments
	 */
	public static void main(String[] args) 
	{
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<IWorker> workerList = new ArrayList<IWorker>();
		ArrayList<Result> resultList = new ArrayList<Result>();
		ArrayList<Input> inputList = new ArrayList<Input>();
		
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
				System.out.println("Referencja do " + addressList.get(i) + " jest pobrana");
				//System.out.println("Do serwera zostala przekazana lista: " + list);
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
			System.out.println("Nacisnij: \n[1] - dodawanie\n[2] - silnia\n[3] - sortowanie\n[4] - sortowanie 1000 losowych liczb\n[0] - zakoncz\n");
	    	choice = reader.next();
	    	
	    	if(choice.toCharArray()[0] != '0')
	    	{
				if(inputList.size() < workerList.size())
				{
					if(choice.toCharArray()[0] == '1')
					{
						System.out.println("Podaj pierwsza liczbe: ");
						int in1 = reader.nextInt();
						System.out.println("Podaj druga liczbe: ");
						int in2 = reader.nextInt();
						inputList.add(new Input("add", Arrays.asList(in1, in2)));
					}
					else if(choice.toCharArray()[0] == '2')
					{
						System.out.println("Podaj liczbe: ");
						int in1 = reader.nextInt();
						inputList.add(new Input("fac", Arrays.asList(in1)));
					}
					else if(choice.toCharArray()[0] == '3')
					{
						System.out.println("Podaj liczby do posortowania: ");
						String in1 = reader.next();
						System.out.println("Podaj liczbe watkow: ");
						int in2 = reader.nextInt();
						List<Integer> tempList = new ArrayList<Integer>();
						for(String s : in1.split(","))
						{
							tempList.add(Integer.parseInt(s));
						}
						tempList.add(in2);
						inputList.add(new Input("sort", tempList));
					}
					else if(choice.toCharArray()[0] == '4')
					{
						System.out.println("Podaj liczbe watkow: ");
						int in1 = reader.nextInt();
						List<Integer> list = new ArrayList<Integer>();
						Random rand = new Random();
						for(int i = 0; i < 999; i++)
						{
							list.add(rand.nextInt(10000));
						}
						list.add(in1);
						inputList.add(new Input("sort", list));
					}
					else
					{
						System.out.println("Nieprawidlowa operacja!");
					}
				}
				else
				{
					System.out.println("Wszyscy pracownicy zostali zajeci!");
				}
	    	}
		}while(choice.toCharArray()[0] != '0');
	    reader.close();
		
		try
		{
			for(int i = 0; i < inputList.size(); i++)
			{
				resultList.add(workerList.get(i).calculate(inputList.get(i)));
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
			System.out.println("Wynik uslugi nr " + ++i + ": ");
			for(int j = 0; j < r.result.size(); j++)
			{
				System.out.print(r.result.get(j) + " ");
			}
			System.out.println("\nopis: " + r.result_description + "\n");
		}
		return;
	}
}
