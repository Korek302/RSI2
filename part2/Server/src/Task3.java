import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 extends Task
{
	public Task3()
	{
		super();
	}
	
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
