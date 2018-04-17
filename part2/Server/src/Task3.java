import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 extends Task
{
	/**
	 * Default constructor of the Task1 class.
	 */
	public Task3()
	{
		super();
	}
	
	/**
	 * Parametrized constructor of the Task3 abstract class.
	 * @param input - Input - values for the operation
	 */
	public Task3(Input input)
	{
		super(input);
	}
	
	/**
	 * Implementation of calculate method from ITask interface.
	 * returns Result type result
	 * throws RemoteException
	 */
	@Override
	public Result calculate() throws RemoteException 
	{
		Result out = new Result();
		out.result_description = operation + this.getClass().getName();
		
		int threadCount = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		
		try
		{
			out.result = sort(list, threadCount);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return out;
	}
	
	/*
	 * Method used for sorting list in ascending order
	 * Uses many thread and ExecutorService, CountDownLatch classes
	 * @return List<Integer> type value - sorted l list
	 * @throws InterruptedException
	 * @params l - List<Integer> - input list to sort
	 * @params threadCount - int - number of threads to be used
	 */
	private List<Integer> sort(List<Integer> l, int threadCount) throws InterruptedException
	{
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
	    List<List<Integer>> listsToSort = split(l, threadCount);
	    CountDownLatch latch = new CountDownLatch(threadCount);

	    listsToSort.forEach
	    (list -> executor.execute
    		(() -> 
		        {
		            list.sort(Comparator.naturalOrder());
		            latch.countDown();
		        }
	        )
	    );

	    latch.await();
	    return merge(listsToSort, l.size());
	}
	
	/*
	 * Method used for spliting one list into list of lists
	 * @return List<List<Integer>> type value - unsorted list of lists of the input values
	 * @params l - List<Integer> - input list to split
	 * @params count - int - number of sublists
	 */
	private List<List<Integer>> split(List<Integer> l, int count) 
	{
	    List<List<Integer>> out = new ArrayList<>();
	    int batchSize = l.size() / count;
	    for(int i=0; i < l.size(); i += batchSize)
	    {
	        out.add(l.subList(i, Math.min(i + batchSize, l.size())));
	    }
	    return out;
	}
	
	/*
	 * Method used to merge sorted sublists in ascending order
	 * @return List<Integer> type value - sorted and merged list
	 * @params l - List<List<Integer>> - input list of lists to merge
	 * @params listLength - int - length of the final list
	 */
	private List<Integer> merge(List<List<Integer>> listOfLists, int listLength) 
	{
		List<Integer> out = new ArrayList<Integer>();
		int nrOfLists = listOfLists.size();
		
		while(out.size() < listLength) 
		{
			int number = Integer.MAX_VALUE;
			int index = 0;
			for(int i = 0; i < nrOfLists; i++) 
			{
				if(!listOfLists.get(i).isEmpty())
				{
					if(listOfLists.get(i).get(0) < number) 
					{
						number = listOfLists.get(i).get(0); 
						index = i;
					}
				}
			}
			listOfLists.set(index, listOfLists.get(index).subList(1, listOfLists.get(index).size()));
			out.add(number);
		}
		
		return out;
	}
}
